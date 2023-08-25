package com.example.aug4newcomp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel()
{
    var searchItem : String by mutableStateOf("")
    var Clicked : Boolean by mutableStateOf(false)

    var message = mutableStateListOf<String>()
    fun addmessage(mess : String){
        message += mess
    }



}
