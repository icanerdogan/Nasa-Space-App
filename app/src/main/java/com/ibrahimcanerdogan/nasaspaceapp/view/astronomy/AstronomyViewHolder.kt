package com.ibrahimcanerdogan.nasaspaceapp.view.astronomy

import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.ibrahimcanerdogan.nasaspaceapp.databinding.CardAstronomyBinding
import com.ibrahimcanerdogan.nasaspaceapp.model.astronomy.Astronomy
import com.ibrahimcanerdogan.nasaspaceapp.util.GlideUtil

class AstronomyViewHolder(private val binding: CardAstronomyBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(astronomy: Astronomy) {
        // ImageView
        GlideUtil.setImageAstronomy(astronomy, binding)

        // Info
        binding.astronomyTextTitle.text = astronomy.astronomyTitle
        binding.astronomyTextDate.text = astronomy.astronomyDate
        binding.layoutInfo.setOnClickListener {
            binding.layoutDetail.visibility = View.VISIBLE
            binding.layoutInfo.visibility = View.INVISIBLE
        }
        // Detail
        binding.astronomyTextTitleDetail.text = astronomy.astronomyTitle
        binding.astronomyTextDateDetail.text = astronomy.astronomyDate
        binding.astronomyTextExplanation.text = astronomy.astronomyExplanation
        binding.astronomyTextExplanation.movementMethod = ScrollingMovementMethod()
        binding.layoutDetail.setOnClickListener {
            binding.layoutDetail.visibility = View.INVISIBLE
            binding.layoutInfo.visibility = View.VISIBLE
        }
    }
}