package com.example.aug4newcomp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

//navController.navigate(NavigationScreenApp.Chat.name)


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun BottomSheetMenu(
    navController: NavHostController,expam: ()->Unit
){
    fun CloseOpen(navControl: String){
        navController.navigate(navControl)
        expam()
    }
                Column(
                    modifier = Modifier.padding(5.dp)
                ) {
                    //title
                    Text(text = "Profile", color = Color.White)
                    FlowRow(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.padding(6.dp)
                    ) {
                        newButton(painterResource(R.drawable.mycards), "My Cards", {})
                        newButton(painterResource(R.drawable.contacts), "Contacts", {})
                        newButton(painterResource(R.drawable.version), "Card Version", {})
                        newButton(painterResource(R.drawable.tree), "My Tree", {})
                        newButton(painterResource(R.drawable.wallet), "Wallet", {})
                    }
                    //title
                    Text(text = "SDGs", color = Color.White)
                    FlowRow(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.padding(6.dp)
                    ) {
                        newButton(painterResource(R.drawable.mycards), "My Cards", {})
                        newButton(painterResource(R.drawable.contacts), "Contacts", {})
                        newButton(painterResource(R.drawable.version), "Card Version", {})
                        newButton(painterResource(R.drawable.group), "My Tree", {})
                        newButton(painterResource(R.drawable.wallet), "Wallet", {})
                        newButton(painterResource(R.drawable.chat), "Chat", {CloseOpen(NavigationScreenApp.Chat.name)})

                    }
                    //title
                    Text(text = "Support", color = Color.White)
                    FlowRow(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier.padding(6.dp)
                    ) {
                        newButton(painterResource(R.drawable.mycards), "My Cards", {})
                        newButton(painterResource(R.drawable.contacts), "Contacts", {})
                        newButton(painterResource(R.drawable.version), "Card Version", {})
                        newButton(painterResource(R.drawable.tree), "My Tree", {})
                        newButton(painterResource(R.drawable.wallet), "Wallet", {})
                    }
                    Spacer(modifier = Modifier.height(50.dp))
                }
            }    


//}
//imgg: Painter, name : String, onClickFun :()-> Unit
@Composable
fun newButton ( img: Painter, name : String, OnClick : ()-> Unit){
    TextButton(
        onClick = { OnClick()},
        modifier = Modifier.padding(9.dp),
//        colors = ButtonColors.C
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = img,
                contentDescription = name,
                modifier = Modifier.size(30.dp)
            )
            Text(
                text = name,
                fontSize = 12.sp,
                color = Color.White
            )
        }
    }
}

class bottomItems(val imgg :Painter,val cnt: String,val onClickMenu: () -> Unit?){
    val immg : Painter = imgg
    val cnnt : String = cnt
    fun executeFunction() {
        onClickMenu.invoke()
    }

}