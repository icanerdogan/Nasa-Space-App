package com.ibrahimcanerdogan.nasaspaceapp.view.earth

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ibrahimcanerdogan.nasaspaceapp.databinding.CardEarthBinding
import com.ibrahimcanerdogan.nasaspaceapp.model.earth.EarthDetail
import com.ibrahimcanerdogan.nasaspaceapp.util.GlideUtil
import java.text.DecimalFormat

class EarthViewHolder(
    private val binding : CardEarthBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(earth: EarthDetail) {

        // Info
        binding.earthDateTitle.text = earth.earthDate
        binding.earthButtonLearnMore.setOnClickListener {
            binding.layoutDetail.visibility = View.VISIBLE
            binding.layoutInfo.visibility = View.INVISIBLE
        }

        // ImageView
        GlideUtil.setImageEarth(earth, binding)

        // Detail
        binding.earthDateTitleDetail.text = earth.earthDate
        binding.earthCaptionDetail.text = earth.earthCaption

        val decimalFormat = DecimalFormat("#.##")
        // center coordinates
        binding.earthCenterCoordinates.earthCenterCoordinatesLatitude.text = decimalFormat.format(earth.earthCentroidCoordinates.lat).toString()
        binding.earthCenterCoordinates.earthCenterCoordinatesLongitude.text = decimalFormat.format(earth.earthCentroidCoordinates.lon).toString()
        // discover position
        binding.earthDiscoverPosition.earthDiscoverPositionX.text = decimalFormat.format(earth.earthDscovrJ2000Position.x).toString()
        binding.earthDiscoverPosition.earthDiscoverPositionY.text = decimalFormat.format(earth.earthDscovrJ2000Position.y).toString()
        binding.earthDiscoverPosition.earthDiscoverPositionZ.text = decimalFormat.format(earth.earthDscovrJ2000Position.z).toString()
        // lunar position
        binding.earthLunarPosition.earthLunarPositionX.text = decimalFormat.format(earth.earthLunarJ2000Position.x).toString()
        binding.earthLunarPosition.earthLunarPositionY.text = decimalFormat.format(earth.earthLunarJ2000Position.y).toString()
        binding.earthLunarPosition.earthLunarPositionZ.text = decimalFormat.format(earth.earthLunarJ2000Position.z).toString()
        // sun position
        binding.earthSunPosition.earthSunPositionX.text = "X = ${decimalFormat.format(earth.earthSunJ2000Position.x)}"
        binding.earthSunPosition.earthSunPositionY.text = "Y = ${decimalFormat.format(earth.earthSunJ2000Position.y)}"
        binding.earthSunPosition.earthSunPositionZ.text = "Z = ${decimalFormat.format(earth.earthSunJ2000Position.z)}"

        binding.layoutDetail.setOnClickListener {
            binding.layoutDetail.visibility = View.INVISIBLE
            binding.layoutInfo.visibility = View.VISIBLE
        }
    }
}