package com.ibrahimcanerdogan.nasaspaceapp.util

import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.ibrahimcanerdogan.nasaspaceapp.databinding.CardAstronomyBinding
import com.ibrahimcanerdogan.nasaspaceapp.databinding.CardMarsRoverBinding
import com.ibrahimcanerdogan.nasaspaceapp.model.astronomy.Astronomy
import com.ibrahimcanerdogan.nasaspaceapp.model.marsrover.MarsRoverDetail

object GlideUtil {

    fun setImageAstronomy(astronomy : Astronomy, binding : CardAstronomyBinding) {
        val circularProgressDrawable = CircularProgressDrawable(binding.astronomyImageView.context)
        circularProgressDrawable.strokeWidth = 6f
        circularProgressDrawable.centerRadius = 100f
        circularProgressDrawable.start()
        Glide.with(binding.astronomyImageView.context)
            .load(astronomy.astronomyImage)
            .placeholder(circularProgressDrawable)
            .into(binding.astronomyImageView)
    }

    fun setImageMarsRover(marsRoverDetail: MarsRoverDetail, binding : CardMarsRoverBinding) {
        val circularProgressDrawable = CircularProgressDrawable(binding.marsRoverImageView.context)
        circularProgressDrawable.strokeWidth = 6f
        circularProgressDrawable.centerRadius = 100f
        circularProgressDrawable.start()
        Glide.with(binding.marsRoverImageView.context)
            .load(marsRoverDetail.detailImageSource)
            .placeholder(circularProgressDrawable)
            .into(binding.marsRoverImageView)
    }

}