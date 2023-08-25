package com.example.aug4newcomp

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeApp(){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color(0xE5212121)) ,
        verticalArrangement = Arrangement.spacedBy(20.dp) ,
        horizontalAlignment = Alignment.CenterHorizontally,


        ) {
        item(){
            Spacer(modifier = Modifier.height(50.dp))
        }
        item{ Info() }
        item(){mapScroll()}
        item(){PlanterScroll()}
        item(){
            Spacer(modifier = Modifier.height(70.dp))
        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Info(){
    Column(
        modifier = Modifier.padding(30.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            //profile
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = "profile pic",
                contentScale = ContentScale.Crop,            // crop the image if it's not a square
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)                       // clip to the circle shape
                    .border(2.dp, Color.Gray, CircleShape)
            )
            //Spacer
            Spacer(modifier = Modifier)
            // button
            Button(
                onClick = { /*TODO*/ },
                modifier= Modifier
                    .height(50.dp)
                    .width(150.dp),

                shape = RoundedCornerShape(50)  ,
                border= BorderStroke(0.dp, Color(0xFFD9D9D9)),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFD9D9D9),
                    contentColor = Color.Black)
            ) {

                Row( modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    //Image
                    Image(
                        painter = painterResource(R.drawable.tree),
                        contentDescription = "tree",
                        contentScale = ContentScale.Crop,            // crop the image if it's not a square
                        modifier = Modifier
                            .size(34.dp)
                            .clip(CircleShape)                       // clip to the circle shape
                            .border(1.dp, Color.Gray, CircleShape)
                    )
                    //Text
                    Text(
                        text = "tag a tree",
                        fontSize = 20.sp,
                        color = Color.Black,
                    )
                }
            }
        }
        Row() {
            var name  = "Ritick"
            Column() {
                //title text
                Text(
                    text = "Welcome $name",
                    fontSize = 30.sp,
                    modifier = Modifier.padding(top = 10.dp, start = 5.dp ),
                    color = Color.White,

                    )
                // description text
                Text(
                    text = "Tag, Trace & Track your trees.",
                    fontSize = 10.sp,
                    modifier = Modifier.padding(bottom = 10.dp, start = 5.dp),
                    color = Color.White,

                    )
            }
        }
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically) {
            //tagged tree button
            FrameButtons(ButtonNum = "1100", ButtonName ="Tagged trees", img= painterResource(R.drawable.minted))
            // untagged tree button
            FrameButtons(ButtonNum = "24", ButtonName = "Unminted trees", img= painterResource(R.drawable.unminted))
            // Minted trees button
            FrameButtons(ButtonNum= "21", ButtonName = "Minted trees", img= painterResource(R.drawable.minted))
        }



    }



}




//maps
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun mapScroll() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(10.dp)
    ) {
        Text(
            text = "Farm",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Start,
        )

        LazyRow(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            item(){

                Box {
                    Image(
                        painter = painterResource(R.drawable.map),
                        contentDescription = "profile pic",
                        modifier = Modifier
                            .width(400.dp)
                            .height(500.dp)
                            .padding(20.dp)
                            .clip(RoundedCornerShape(30.dp))
                            .shadow(
                                elevation = 130.dp,
                                shape = ShapeDefaults.Large,
                                true
                            )
                    )

                }

            }
            item() {
                Image(
                    painter = painterResource(R.drawable.map),
                    contentDescription = "profile pic",
                    modifier = Modifier
                        .width(400.dp)
                        .height(500.dp)
                        .padding(20.dp)
                        .clip(RoundedCornerShape(30.dp))
//                        .fillMaxSize(.001f)
                )
            }
        }
    }
}




//planter
@Composable
fun PlanterScroll() {
    Column(
        modifier = Modifier.padding( start = 20.dp, end = 20.dp, )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            //title
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Planters : ", color = Color.White,)

                // buttons
                //1
                Button(
                    onClick = { /*TODO*/ },
                    modifier= Modifier
                        .height(40.dp)
                        .width(150.dp),
                    shape = RoundedCornerShape(50)  ,
                    border= BorderStroke(0.dp, Color(0XFF9C9D9D)),
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFD9D9D9),
                        contentColor = Color.Black)

                ) {

                    Row( modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            Icons.Default.Add ,
                            contentDescription = "content description",
                            modifier = Modifier.size(20.dp),
                            tint=Color.Black,

                            )


                        //Text
                        Text(
                            text = "Add Planter",
                            fontSize = 15.sp,
                            color = Color.Black,
                        )
                    }

                }
            }
            //button 2
            Button(onClick = { /*TODO*/ },
                modifier= Modifier.size(60.dp),
                shape = CircleShape,
//                border= BorderStroke(2.dp, Color(0XFF0F9D58)),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00D179),
                    contentColor = Color.White)
            ) {
                // Adding an Icon "Add" inside the Button
                Icon(
                    Icons.Default.Add ,
                    contentDescription = "content description",
                    modifier = Modifier.size(40.dp),
                    tint=Color(0XFFFFFFFF))

            }

        }
        LazyRow (horizontalArrangement = Arrangement.spacedBy(20.dp),){
            //planters
            items(3) {
                PlanterDetail(userID = "@RITICK", userName = "Ritick KUMAR")
            }
        }
    }
}



//frame buttons - tagged trees, unminted trees, minted trees
@Composable
fun FrameButtons(ButtonNum:String, ButtonName : String, img: Painter){
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {  },
            modifier= Modifier
                .height(40.dp)
                .width(80.dp),
            shape = RoundedCornerShape(50)  ,
            border= BorderStroke(0.dp, Color(0xFFD9D9D9)),
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFD9D9D9),
                contentColor = Color.Black)

        ) {

            Row( modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                //Image
                Image(
                    painter = img,
                    contentDescription = "profile pic", // crop the image if it's not a square
                    modifier = Modifier
                        .size(25.dp) // clip to the circle shape
                )

                //Text
                Text(
                    text = "$ButtonNum",
                    fontSize = 20.sp,
                    color = Color.Black,

                    )
            }
        }
        //text
        Text(
            text ="$ButtonName",
            color = Color.White,
        )
    }
}


@Composable
fun PlanterDetail( userID: String , userName: String){
    Card(
        Modifier.size(width = 180.dp, height = 140.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF707070),
            contentColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(5.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, bottom = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween ,
            ) {
                Image(
                    painter = painterResource(R.drawable.profile),
                    contentDescription = "profile",
                    contentScale = ContentScale.Crop,            // crop the image if it's not a square
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)                       // clip to the circle shape
                        .border(2.dp, Color.Gray, CircleShape) )
                Image(
                    painter = painterResource(R.drawable.profile),
                    contentDescription = "LOGO",
                    contentScale = ContentScale.Crop,            // crop the image if it's not a square
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)                       // clip to the circle shape
                        .border(2.dp, Color.Gray, CircleShape) )
            }
            Text(
                text = userID,
                fontSize = 10.sp,
                color = Color.White,
            )
            Text(
                text = userName,
                color = Color.White,
            )
            Text(text = "Planter",fontSize = 10.sp,color = Color.White, )


        }
    }
}
