package com.marina.composeapp.data.storage.local.file

interface SaveImageIntoStorage {

    suspend fun saveImage(image: InternalStoragePicture)

    suspend fun deleteImage(name: String)

    suspend fun loadImage(name: String): InternalStoragePicture

    suspend fun loadAllImages(): List<InternalStoragePicture>

    suspend fun deleteAllImages()
}