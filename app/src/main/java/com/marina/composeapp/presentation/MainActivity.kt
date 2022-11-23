package com.marina.composeapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.marina.composeapp.data.storage.remote.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GlobalScope.launch(Dispatchers.IO) {
            val ch = RetrofitInstance.characterApi.getCharacters()
            Log.e(this.javaClass.simpleName, ch.characterDtos.toString())
        }
    }
}