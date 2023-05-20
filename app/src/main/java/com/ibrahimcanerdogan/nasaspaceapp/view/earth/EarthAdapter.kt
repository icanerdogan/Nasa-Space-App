package com.ibrahimcanerdogan.nasaspaceapp.view.earth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ibrahimcanerdogan.nasaspaceapp.R
import com.ibrahimcanerdogan.nasaspaceapp.databinding.CardEarthBinding
import com.ibrahimcanerdogan.nasaspaceapp.model.earth.EarthDetail

class EarthAdapter : RecyclerView.Adapter<EarthViewHolder>() {

    private var earthList = ArrayList<EarthDetail>()

    fun setEarthList(newEarthList : List<EarthDetail>) {
        earthList.clear()
        earthList.addAll(newEarthList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EarthViewHolder {
        val binding : CardEarthBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.card_earth,
            parent,
            false
        )
        return EarthViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return earthList.size
    }

    override fun onBindViewHolder(holder: EarthViewHolder, position: Int) {
        holder.bind(earthList[position])
    }

}