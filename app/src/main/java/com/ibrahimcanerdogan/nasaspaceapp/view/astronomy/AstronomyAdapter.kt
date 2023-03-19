package com.ibrahimcanerdogan.nasaspaceapp.view.astronomy

import android.content.Context
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.ibrahimcanerdogan.nasaspaceapp.R
import com.ibrahimcanerdogan.nasaspaceapp.databinding.CardAstronomyBinding
import com.ibrahimcanerdogan.nasaspaceapp.model.astronomy.Astronomy

class AstronomyAdapter : RecyclerView.Adapter<AstronomyViewHolder>() {

    private val astronomyList = ArrayList<Astronomy>()

    fun setAstronomyList(astronomers: List<Astronomy>) {
        astronomyList.clear()
        astronomyList.addAll(astronomers)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AstronomyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : CardAstronomyBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.card_astronomy,
            parent,
            false
        )
        return AstronomyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return astronomyList.size
    }

    override fun onBindViewHolder(holder: AstronomyViewHolder, position: Int) {
        holder.bind(astronomyList[position])
    }
}

