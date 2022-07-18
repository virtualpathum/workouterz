package com.lk.infinitx.workouterz

import android.app.Dialog
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lk.infinitx.workouterz.analytics.Analytics
import com.lk.infinitx.workouterz.analytics.FirebaseAnalytics
import com.lk.infinitx.workouterz.data.entity.Excercise
import com.lk.infinitx.workouterz.presentation.ExerciseViewModel
import com.lk.infinitx.workouterz.presentation.ExerciseViewModelFactory
import com.lk.infinitx.workouterz.databinding.ActivityExerciseBinding
import com.lk.infinitx.workouterz.databinding.DialogCustomBackConfirmationBinding
import com.lk.infinitx.workouterz.presentation.adapter.ExcerciseStatusAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@AndroidEntryPoint
class ExerciseActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    @Inject
    lateinit var vmFactory: ExerciseViewModelFactory
    private lateinit var binding: ActivityExerciseBinding
    private lateinit var viewModel: ExerciseViewModel

    private var restTimer:CountDownTimer? = null
    private var restProgress:Int = 0

    private var exerciseTimer:CountDownTimer? = null
    private var exerciseProgress:Int = 0

    private var currentPosition = -1

    private var tts:TextToSpeech? = null
    private lateinit var player:MediaPlayer

    private var analytics : Analytics? = null

    private var statusAdapter: ExcerciseStatusAdapter? = null

    private var restTimerDuration: Long = 1
    private var exerciseTimerDuration: Long = 1


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolBar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolBar.setNavigationOnClickListener{
            customDialogForBackButton()
        }

        viewModel = ViewModelProvider(this,vmFactory)[ExerciseViewModel::class.java]

       // binding.toolBar?.title = "Just Workout"

        val liveData = viewModel.getExerciseList()
        liveData.observe(this) {
            val list = ArrayList(it)
            list.sortBy { item -> item.getId() }
            setupRestView(list)
            setupExerciseStatusRecycler(list)
        }
        tts = TextToSpeech(this,this)
        analytics  =  FirebaseAnalytics(application)

        setupMediaSound()
        //binding.flProgressBar?.visibility = View.GONE

    }

    override fun onBackPressed() {
        //super.onBackPressed()
        customDialogForBackButton()
    }

    private fun customDialogForBackButton() {
        val customDialog = Dialog(this)
        val dialogBinding = DialogCustomBackConfirmationBinding.inflate(layoutInflater)
        customDialog.setContentView(dialogBinding.root)
        customDialog.setCanceledOnTouchOutside(false)

        dialogBinding.btnYes.setOnClickListener{
            this@ExerciseActivity.finish()
            customDialog.dismiss()
        }
        dialogBinding.btnNo.setOnClickListener{
            customDialog.dismiss()
        }
        customDialog.show()
    }

    private fun setupExerciseStatusRecycler(list:ArrayList<Excercise>){
        binding.rvExerciseStatus.layoutManager =
            LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        statusAdapter = ExcerciseStatusAdapter(list)
        binding.rvExerciseStatus.adapter = statusAdapter
    }

    private fun setupMediaSound(){
        try {
            val sound = Uri.parse("android.resource://com.lk.infinitx.workouterz/" + R.raw.press_start)
            player = MediaPlayer.create(applicationContext,sound)
            player.isLooping = false
            player.start()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    private fun setupRestView(list:ArrayList<Excercise>){

        binding.flRestView.visibility = View.VISIBLE
        binding.flExerciseView.visibility = View.INVISIBLE
        binding.tvTitle.visibility = View.VISIBLE
        binding.tvUpcomingExerciseName.visibility = View.VISIBLE
        binding.tvUpcomingLabel.visibility = View.VISIBLE
        binding.tvExerciseName.visibility = View.INVISIBLE
        binding.flExerciseView.visibility = View.INVISIBLE
        binding.ivExercise.visibility = View.INVISIBLE

        if (currentPosition<= list.size){
            binding.tvUpcomingExerciseName.text = list[currentPosition+1].getName()

        }

        speakOut("Upcoming Exercise, "+list[currentPosition + 1].getName())

        if(restTimer !=null ){
            restTimer?.cancel()
            restProgress = 0
        }

        setRestProgressBar(list)
    }

    private fun setupExerciseView(list:ArrayList<Excercise>){
        binding.flRestView.visibility = View.INVISIBLE
        binding.flExerciseView.visibility = View.VISIBLE
        binding.tvTitle.visibility = View.INVISIBLE
        binding.tvExerciseName.visibility = View.VISIBLE
        binding.flExerciseView.visibility = View.VISIBLE
        binding.ivExercise.visibility = View.VISIBLE
        binding.tvUpcomingExerciseName.visibility = View.INVISIBLE
        binding.tvUpcomingLabel.visibility = View.INVISIBLE
        if(exerciseTimer !=null ){
            exerciseTimer?.cancel()
            exerciseProgress = 0
        }
        binding.ivExercise.setImageResource(list[currentPosition].getImage())
        binding.tvExerciseName.text = list[currentPosition].getName()

        speakOut(list[currentPosition].getName())
        setExerciseProgressBar(list)
    }

    private fun setExerciseProgressBar(list:ArrayList<Excercise>){

        binding.progessBarExercise.progress = exerciseProgress

        exerciseTimer = object : CountDownTimer(exerciseTimerDuration*1000,1000){

            override fun onTick(p0: Long) {
                exerciseProgress++
                binding.progessBarExercise.progress = 30 - exerciseProgress
                binding.tvTimerExercise.text = (30 - exerciseProgress).toString()

            }

            override fun onFinish() {
                if(currentPosition < list.size - 1){
                    list[currentPosition].setIsSelected(false)
                    list[currentPosition].setIsCompleted(true)
                    statusAdapter!!.notifyDataSetChanged()
                    analytics?.logEvent( list[currentPosition].getName(),"Exercise Screen")
                    setupRestView(list)
                }else{
                    finish()
                    val intent = Intent(this@ExerciseActivity,FinishActivity::class.java)
                    startActivity(intent)
                }
            }

        }.start()

    }

    private fun setRestProgressBar(list:ArrayList<Excercise>){

        binding.progessBarExercise.progress = exerciseProgress

        restTimer = object : CountDownTimer(restTimerDuration*1000,1000){

            override fun onTick(p0: Long) {
                restProgress++
                binding.progessBarRest.progress = 10 - restProgress
                binding.tvTimerRest.text = (10 - restProgress).toString()

            }

            override fun onFinish() {
                currentPosition++
                list[currentPosition].setIsSelected(true)
                statusAdapter!!.notifyDataSetChanged()
                setupExerciseView(list)
            }

        }.start()

    }

    override fun onDestroy() {
        super.onDestroy()

        if(restTimer !=null ){
            restTimer?.cancel()
            restProgress = 0
        }

        if(exerciseTimer !=null ){
            exerciseTimer?.cancel()
            exerciseProgress = 0
        }

        if(tts!=null){
            tts!!.stop()
            tts!!.shutdown()
        }

        player.stop()
    }

    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS){
            val result = tts?.setLanguage(Locale.US)

            if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Toast.makeText(this,"Language not supported",Toast.LENGTH_LONG)
            }
        }else{
            Log.e("tts" , "Initialisation Error")
        }
    }

    private fun speakOut(text:String){
        tts!!.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")

    }
}