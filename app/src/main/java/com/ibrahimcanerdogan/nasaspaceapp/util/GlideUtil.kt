package com.ibrahimcanerdogan.nasaspaceapp.util

import android.content.Context
import android.graphics.Color
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.ibrahimcanerdogan.nasaspaceapp.databinding.CardAstronomyBinding
import com.ibrahimcanerdogan.nasaspaceapp.databinding.CardEarthBinding
import com.ibrahimcanerdogan.nasaspaceapp.databinding.CardMarsRoverBinding
import com.ibrahimcanerdogan.nasaspaceapp.model.astronomy.Astronomy
import com.ibrahimcanerdogan.nasaspaceapp.model.earth.EarthDetail
import com.ibrahimcanerdogan.nasaspaceapp.model.marsrover.MarsRoverDetail
import java.text.SimpleDateFormat
import java.util.Locale

object GlideUtil {

    private fun createCircularProgress(context: Context) : CircularProgressDrawable {
        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.apply {
            strokeWidth = 6f
            centerRadius = 100f
            setColorSchemeColors(Color.WHITE)
            start()
        }
        return circularProgressDrawable
    }
    fun setImageAstronomy(astronomy : Astronomy, binding : CardAstronomyBinding) {
        val context = binding.astronomyImageView.context
        Glide.with(context)
            .load(astronomy.astronomyImage)
            .placeholder(createCircularProgress(context))
            .into(binding.astronomyImageView)
    }

    fun setImageMarsRover(marsRoverDetail: MarsRoverDetail, binding : CardMarsRoverBinding) {
        val context = binding.marsRoverImageView.context
        Glide.with(context)
            .load(marsRoverDetail.detailImageSource)
            .placeholder(createCircularProgress(context))
            .into(binding.marsRoverImageView)
    }

    fun setImageEarth(earthDetail: EarthDetail, binding : CardEarthBinding) {
        val context = binding.earthImageView.context

        Glide.with(context)
            .load(getEarthImageUrl(earthDetail))
            .placeholder(createCircularProgress(context))
            .into(binding.earthImageView)
    }

    private fun getEarthImageUrl(earthDetail: EarthDetail): String {
        // https://api.nasa.gov/EPIC/archive/natural/2019/05/30/png/epic_1b_20190530011359.png?api_key=DEMO_KEY
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val date = dateFormat.parse(earthDetail.earthDate)
        val year = SimpleDateFormat("yyyy", Locale.getDefault()).format(date!!)
        val month = SimpleDateFormat("MM", Locale.getDefault()).format(date)
        val day = SimpleDateFormat("dd", Locale.getDefault()).format(date)

        return "https://api.nasa.gov/EPIC/archive/natural/${year}/${month}/${day}/png/${earthDetail.earthImageCode}.png?api_key=${AppConstant.API_KEY}"
    }
}