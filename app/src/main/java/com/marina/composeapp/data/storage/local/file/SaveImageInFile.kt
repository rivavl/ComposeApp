package com.marina.composeapp.data.storage.local.file

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import java.io.IOException
import javax.inject.Inject

class SaveImageInFile @Inject constructor(
    private val context: Application
) : SaveImageIntoStorage {

    override suspend fun saveImage(image: InternalStoragePicture) {
        try {
            context.openFileOutput(image.name, MODE_PRIVATE).use { stream ->
                if (!image.bmp.compress(Bitmap.CompressFormat.JPEG, 95, stream)) {
                    throw IOException("Couldn't save bitmap.")
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override suspend fun deleteImage(name: String) {
        Log.d("SaveImageIntoFile", "name: $name")
        try {
            context.deleteFile(name)
        } catch (exception: IOException) {
            exception.printStackTrace()
        }
    }

    override suspend fun loadImage(name: String): InternalStoragePicture {
        val files = context.filesDir.listFiles()
        files?.first { it.canRead() && it.isFile && it.name.equals(name) }?.apply {
            val bytes = this.readBytes()
            val bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
            return InternalStoragePicture(this.name, bmp)
        }
        throw RuntimeException("File $name not found")
    }

    override suspend fun loadAllImages(): List<InternalStoragePicture> {
        val files = context.filesDir.listFiles()
        return files?.filter { it.canRead() && it.isFile && it.name.endsWith(".jpg") }?.map {
            val bytes = it.readBytes()
            val bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
            InternalStoragePicture(it.name, bmp)
        } ?: listOf()
    }

    override suspend fun deleteAllImages() {
        val allPics = loadAllImages()
        for (pic in allPics) {
            deleteImage(pic.name)
        }
    }
}