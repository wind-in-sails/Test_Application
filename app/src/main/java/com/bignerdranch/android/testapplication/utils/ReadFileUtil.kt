package com.bignerdranch.android.testapplication.utils

import android.content.Context
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

object ReadFileUtil {
    fun <T : Any> deserializeObject(json: String, dataClass: Class<T>): T {
        return Gson().fromJson(json, dataClass)
    }

    fun getJsonFromAssets(context: Context, fileName: String): String? {
        val jsonString: String = try {
            val json: InputStream = context.assets.open(fileName)
            val size = json.available()
            val buffer = ByteArray(size)
            json.read(buffer)
            json.close()
            String(buffer, Charset.forName("UTF-8"))
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        return jsonString
    }
}
