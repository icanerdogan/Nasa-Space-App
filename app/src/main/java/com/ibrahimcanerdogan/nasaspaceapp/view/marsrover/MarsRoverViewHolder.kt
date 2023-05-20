package com.ibrahimcanerdogan.nasaspaceapp.view.marsrover

import androidx.recyclerview.widget.RecyclerView
import com.ibrahimcanerdogan.nasaspaceapp.databinding.CardMarsRoverBinding
import com.ibrahimcanerdogan.nasaspaceapp.model.marsrover.MarsRoverDetail
import com.ibrahimcanerdogan.nasaspaceapp.util.GlideUtil

class MarsRoverViewHolder(
    private val binding: CardMarsRoverBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item : MarsRoverDetail) {
        GlideUtil.setImageMarsRover(item, binding)
        binding.marsRoverTextTitle.text = "${item.detailCamera.cameraFullName}"
        binding.marsRoverTextEarthDate.text = "Earth Date : ${item.detailEarthDate}"
    }
}
