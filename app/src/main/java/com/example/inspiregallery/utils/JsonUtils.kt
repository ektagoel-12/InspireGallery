package com.example.imagelistapp.utils

import android.content.Context
import com.example.imagelistapp.model.ImageResponse
import com.google.gson.Gson
import java.io.InputStreamReader

object JsonUtils {

    fun loadImagesFromJson(context: Context): ImageResponse {
        val inputStream = context.assets.open("images.json")
        val reader = InputStreamReader(inputStream)
        return Gson().fromJson(reader, ImageResponse::class.java)
    }
}
