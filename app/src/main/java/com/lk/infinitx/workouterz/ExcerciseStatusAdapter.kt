package com.lk.infinitx.workouterz

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.lk.infinitx.workouterz.databinding.ItemExcerciseStatusBinding

class ExcerciseStatusAdapter(val items:ArrayList<ExcerciseModel>) : RecyclerView.Adapter<
        ExcerciseStatusAdapter.ViewHolder>() {

    class ViewHolder(binding: ItemExcerciseStatusBinding):
        RecyclerView.ViewHolder(binding.root) {
            val tvItem = binding.tvItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemExcerciseStatusBinding.inflate(
            LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val model:ExcerciseModel = items[position]
        holder.tvItem.text = model.getId().toString()

        when{
            model.getIsCompleted() -> {
                holder.tvItem.background = ContextCompat.
                getDrawable(holder.itemView.context, R.drawable.item_circular_green_background )
            }model.getIsSelected() -> {
                holder.tvItem.background = ContextCompat.
                getDrawable(holder.itemView.context, R.drawable.item_circular_orange_background )
            }else -> {
            holder.tvItem.background = ContextCompat.
            getDrawable(holder.itemView.context, R.drawable.item_circular_grey_background )

            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}