package com.ibrahimcanerdogan.nasaspaceapp.util

import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.ibrahimcanerdogan.nasaspaceapp.databinding.CardAstronomyBinding
import com.ibrahimcanerdogan.nasaspaceapp.model.astronomy.Astronomy

object GlideUtil {

    fun setImage(astronomy : Astronomy, binding : CardAstronomyBinding) {
        val circularProgressDrawable = CircularProgressDrawable(binding.astronomyImageView.context)
        circularProgressDrawable.strokeWidth = 6f
        circularProgressDrawable.centerRadius = 100f
        circularProgressDrawable.start()
        Glide.with(binding.astronomyImageView.context)
            .load(astronomy.astronomyImage)
            .placeholder(circularProgressDrawable)
            .into(binding.astronomyImageView)
    }
}