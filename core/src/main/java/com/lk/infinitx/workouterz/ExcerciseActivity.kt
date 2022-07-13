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
import androidx.recyclerview.widget.LinearLayoutManager
import com.lk.infinitx.workouterz.analytics.Analytics
import com.lk.infinitx.workouterz.analytics.FirebaseAnalytics
import com.lk.infinitx.workouterz.databinding.ActivityExcerciseBinding
import com.lk.infinitx.workouterz.databinding.DialogCustomBackConfirmationBinding
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class ExcerciseActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private lateinit var binding: ActivityExcerciseBinding

    private var restTimer:CountDownTimer? = null
    private var restProgress:Int = 0

    private var excerciseTimer:CountDownTimer? = null
    private var excerciseProgress:Int = 0

    private var excerciseList:ArrayList<ExcerciseModel>? = null
    private var currentExcercisePosition = -1

    private var tts:TextToSpeech? = null
    private lateinit var player:MediaPlayer

    private var analytics : Analytics? = null

    private var excerciseAdapter:ExcerciseStatusAdapter? = null

    private var restTimerDuration: Long = 1
    private var excerciseTimerDuration: Long = 1


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityExcerciseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolBar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.toolBar?.setNavigationOnClickListener{
            customDialogForBackbutton()
        }

       // binding.toolBar?.title = "Just Workout"

        excerciseList = Constants.defaultExcerciseList()
        excerciseList!!.sortBy { list -> list.getId() }
        tts = TextToSpeech(this,this)
        analytics  =  FirebaseAnalytics(application)

        setupMediaSound()
        //binding.flProgressBar?.visibility = View.GONE
        setupRestView()
        setupExcerciseStatusRecycler()

    }

    override fun onBackPressed() {
        //super.onBackPressed()
        customDialogForBackbutton()
    }

    private fun customDialogForBackbutton() {
        var customDialog = Dialog(this)
        var dialogBinding = DialogCustomBackConfirmationBinding.inflate(layoutInflater)
        customDialog.setContentView(dialogBinding.root)
        customDialog.setCanceledOnTouchOutside(false)

        dialogBinding.btnYes?.setOnClickListener{
            this@ExcerciseActivity.finish()
            customDialog.dismiss()
        }
        dialogBinding.btnNo?.setOnClickListener{
            customDialog.dismiss()
        }
        customDialog.show()
    }

    private fun setupExcerciseStatusRecycler(){
        binding.rvExcerciseStatus?.layoutManager =
            LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        excerciseAdapter = ExcerciseStatusAdapter(excerciseList!!)
        binding.rvExcerciseStatus?.adapter = excerciseAdapter
    }

    private fun setupMediaSound(){
        var sound = Uri.parse("android.resource://com.lk.infinitx.workouterz/" + R.raw.press_start)
        player = MediaPlayer.create(applicationContext,sound)
        player.isLooping = false
    }

    private fun setupRestView(){
        try {
            player?.start()
        }catch (e:Exception){
            e.printStackTrace()
        }

        binding.flRestView?.visibility = View.VISIBLE
        binding.flExcerciseView?.visibility = View.INVISIBLE
        binding.tvTitle?.visibility = View.VISIBLE
        binding.tvUpcomingExerciseName?.visibility = View.VISIBLE
        binding.tvUpcomingLabel?.visibility = View.VISIBLE
        binding.tvExcerciseName?.visibility = View.INVISIBLE
        binding.flExcerciseView?.visibility = View.INVISIBLE
        binding.ivExcercise?.visibility = View.INVISIBLE

        if (currentExcercisePosition<= excerciseList!!.size){
            binding.tvUpcomingExerciseName?.text = excerciseList!![currentExcercisePosition+1].getName()

        }

        speakOut("Upcoming Excercise, "+excerciseList!![currentExcercisePosition + 1].getName())

        if(restTimer !=null ){
            restTimer?.cancel()
            restProgress = 0
        }

        setRestProgressBar()
    }

    private fun setupExcerciseView(){
        binding.flRestView?.visibility = View.INVISIBLE
        binding.flExcerciseView?.visibility = View.VISIBLE
        binding.tvTitle?.visibility = View.INVISIBLE
        binding.tvExcerciseName?.visibility = View.VISIBLE
        binding.flExcerciseView?.visibility = View.VISIBLE
        binding.ivExcercise?.visibility = View.VISIBLE
        binding.tvUpcomingExerciseName?.visibility = View.INVISIBLE
        binding.tvUpcomingLabel?.visibility = View.INVISIBLE
        if(excerciseTimer !=null ){
            excerciseTimer?.cancel()
            excerciseProgress = 0
        }
        binding.ivExcercise?.setImageResource(excerciseList!![currentExcercisePosition].getImage())
        binding.tvExcerciseName?.text = excerciseList!![currentExcercisePosition].getName()

        speakOut(excerciseList!![currentExcercisePosition].getName())
        setExcerciseProgressBar()
    }

    private fun setExcerciseProgressBar(){

        binding.progessBarExcercise?.progress = excerciseProgress

        excerciseTimer = object : CountDownTimer(excerciseTimerDuration*1000,1000){

            override fun onTick(p0: Long) {
                excerciseProgress++
                binding.progessBarExcercise?.progress = 30 - excerciseProgress
                binding.tvTimerExcercise?.text = (30 - excerciseProgress).toString()

            }

            override fun onFinish() {
                if(currentExcercisePosition < excerciseList?.size!! - 1){
                    excerciseList!![currentExcercisePosition].setIsSelected(false)
                    excerciseList!![currentExcercisePosition].setIsCompleted(true)
                    excerciseAdapter!!.notifyDataSetChanged()
                    analytics?.logEvent( excerciseList!![currentExcercisePosition].getName(),"Excercise Screen")
                    setupRestView()
                }else{

                    throw RuntimeException("Test Crash") // Force a crash

                    finish()
                    var intent = Intent(this@ExcerciseActivity,FinishActivity::class.java)
                    startActivity(intent)
                }
            }

        }.start()

    }

    private fun setRestProgressBar(){

        binding.progessBarExcercise?.progress = excerciseProgress

        restTimer = object : CountDownTimer(restTimerDuration*1000,1000){

            override fun onTick(p0: Long) {
                restProgress++
                binding.progessBarRest?.progress = 10 - restProgress
                binding.tvTimerRest?.text = (10 - restProgress).toString()

            }

            override fun onFinish() {
                currentExcercisePosition++
                excerciseList!![currentExcercisePosition].setIsSelected(true)
                excerciseAdapter!!.notifyDataSetChanged()
                setupExcerciseView()
            }

        }.start()

    }

    override fun onDestroy() {
        super.onDestroy()

        if(restTimer !=null ){
            restTimer?.cancel()
            restProgress = 0
        }

        if(excerciseTimer !=null ){
            excerciseTimer?.cancel()
            excerciseProgress = 0
        }

        if(tts!=null){
            tts!!.stop()
            tts!!.shutdown()
        }

        if(player != null){
            player!!.stop()
        }
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