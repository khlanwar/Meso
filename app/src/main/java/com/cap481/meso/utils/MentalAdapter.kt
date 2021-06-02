package com.cap481.meso.utils

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cap481.meso.databinding.ItemListMentalIllnessBinding
import com.cap481.meso.detail.DiagnoseDetailActivity
import com.cap481.meso.detail.MentalDetailActivity
import java.util.ArrayList

class MentalAdapter : RecyclerView.Adapter<MentalAdapter.MentalViewHolder>() {
    private var listMental = ArrayList<MentalEntity>()

    fun setMentals(mentals: List<MentalEntity>?) {
        if (mentals == null) return
        this.listMental.clear()
        this.listMental.addAll(mentals)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MentalViewHolder {
        val itemListMentalIllnessBinding = ItemListMentalIllnessBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MentalViewHolder(itemListMentalIllnessBinding)
    }

    override fun onBindViewHolder(holder: MentalViewHolder, position: Int) {
        val mental = listMental[position]
        holder.bind(mental)
    }

    override fun getItemCount(): Int = listMental.size


    class MentalViewHolder(private val binding: ItemListMentalIllnessBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(mental: MentalEntity) {
            with(binding) {
                tvItemTitle.text = mental.title
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, MentalDetailActivity::class.java)
                    intent.putExtra(MentalDetailActivity.EXTRA_DATA, mental.mentalId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(mental.image)
                    .into(ivItemImage)
            }
        }
    }
}

