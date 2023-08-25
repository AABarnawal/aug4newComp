package com.example.aug4newcomp

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel






@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatBottomBar( viewModel: MainViewModel=viewModel()){
    var mess : String by remember {mutableStateOf("")}
    BottomAppBar() {

            TextField(
                value = mess,
                onValueChange = {mess = it},
                label = { Text("Type your text...") },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                leadingIcon = {
                    IconButton(
                        onClick = {
                            //floating button
                        },) {
                        Icon(
                            Icons.Default.Add ,
                            contentDescription = "content description",
                            modifier = Modifier.size(20.dp),
                            tint=Color.Black,

                            )
                    }
                },
                trailingIcon = {
                    IconButton(onClick = {
                        if(mess != ""){
                            viewModel.message.add(mess)
                        }
                        mess= ""
                    },

                    ) {
                        Image(painter = painterResource(id = R.drawable.send), contentDescription = "",
                            modifier = Modifier
                                .size(200.dp)
                                .background(color = Color(0xFF00D179))
                                .padding(10.dp)
                                .clip(RoundedCornerShape(50)))
                    }

                },
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(50))
                    .height(100.dp)

            )
    }
}

@Composable
fun chatDetail (name : String, userId: String){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Spacer(modifier = Modifier.height(70.dp))
        Image(
            painter = painterResource(R.drawable.profile),
            contentDescription ="",
            modifier = Modifier
                .size(150.dp)
                .padding(10.dp)
                .clip(RoundedCornerShape(50))

        )
        Text(text = name, fontSize = 20.sp)
        Text(text = userId, fontSize = 20.sp)
        Image(
            painter = painterResource(R.drawable.shield_checkmark),
            contentDescription ="",
            modifier = Modifier
                .size(100.dp)
                .padding(top = 20.dp, bottom = 20.dp)

        )
        Text(text = "This Chat is a one on one secured chat.", fontSize = 15.sp)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState")
@Composable
fun ChatWindow(name: String, userId : String, img: Painter, viewModel: MainViewModel = viewModel()){
    Scaffold(
        bottomBar = {ChatBottomBar()}
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                chatDetail(name, userId)
            }
            items(viewModel.message.size) { index ->
                message(mess = viewModel.message[index])

            }

        }
    }
}
@Composable
fun message(mess : String){
    Card(
        modifier = Modifier
            .fillMaxWidth(.8f)
            .padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFD2FBFB),
            contentColor = Color.Black)
    ) {
        Text(
            text = mess,
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(.8f),

        )
    }


}