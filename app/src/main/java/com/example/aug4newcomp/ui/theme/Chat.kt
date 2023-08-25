package com.example.aug4newcomp.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.aug4newcomp.NavigationScreenApp
import com.example.aug4newcomp.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ChatApp(navController: NavHostController){
    var active by remember { mutableStateOf(false) }
    fun Changevisibility(){
        if(active == true) active=false
        else active = true
    }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(NavigationScreenApp.NewChat.name)
                },
                containerColor = Color(0xFF17CE92),
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier.padding(bottom = 80.dp),
            ) {
                Icon(
                    painter = painterResource(R.drawable.chatadd),
                    contentDescription = "Add FAB",
                    modifier = Modifier.size(30.dp),
                    tint = Color.White,
                )
            }
        }

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color(0xE5212121)) ,
        ) {
            Spacer(modifier = Modifier.height(60.dp))
            //Search bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.End
            ) {
                //search button and search field
                OutlinedButton(
                    onClick = { Changevisibility() },

                    ) {
                    SearchFeild(active)
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "search",

                        )
                }
                //hamburger menu
            }
            //tab //chat and group
            Row( ) {
                var state by remember { mutableStateOf(0) }
                val titles = listOf("Chat", "Groups")
                Column(
                ) {
                    TabRow(
                        selectedTabIndex = state,

                    ) {
                        titles.forEachIndexed { index, title ->
                            Tab(
                                selected = state == index,
                                onClick = { state = index },
                                text = { Text(text = title,color = Color.White, fontSize = 25.sp, maxLines = 2, overflow = TextOverflow.Ellipsis) },
                                modifier = Modifier.background(color = Color(0xE5212121))
                            )
                        }
                    }
                    if(state==0){   //Chat Tab
                        chatOptions("name", "Sender : Message", navController)
                        chatOptions("name", "Sender : Message", navController)
                    }
                    else {          //Groups Tab
                        Text(
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            text = "Text tab ${state + 1} selected",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }

        }
    }
}
//search box
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchFeild(isVisible: Boolean){
    if(isVisible){
        SearchBar(
            query = "",
            onQueryChange = {},
            onSearch = {},
            active =true,
            onActiveChange = {},
            modifier = Modifier
                .width(350.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(50))
        ) {

        }

    }
}

//chat card
@Composable
fun chatOptions( name: String, nametitle : String, navController: NavHostController ){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clip(RoundedCornerShape(50))
            .clickable { navController.navigate(NavigationScreenApp.ChatWindow.name) },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xA6717171),
        )
    ) {
        Row(
            modifier = Modifier
                .padding(top = 12.dp, bottom = 12.dp, start = 14.dp, end = 14.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription ="",
                contentScale = ContentScale.Crop,            // crop the image if it's not a square
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)                       // clip to the circle shape
                    .border(2.dp, Color.Gray, CircleShape)
            )
            Column(
                modifier = Modifier
                    .padding(start = 7.dp)
            ) {
                Text(text=name)
                Text(text = nametitle)
            }
        }
    }
}
//floating button
@Composable
fun FloatButton(){

}