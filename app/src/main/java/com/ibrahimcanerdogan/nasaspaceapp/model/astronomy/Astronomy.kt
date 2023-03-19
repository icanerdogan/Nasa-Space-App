package com.ibrahimcanerdogan.nasaspaceapp.model.astronomy

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "apod")
data class Astronomy(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    @SerializedName("title")
    val astronomyTitle : String,
    @SerializedName("date")
    val astronomyDate : String,
    @SerializedName("explanation")
    val astronomyExplanation : String,
    @SerializedName("url")
    val astronomyImage : String?
)