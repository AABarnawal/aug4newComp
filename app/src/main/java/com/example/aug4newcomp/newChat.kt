package com.example.aug4newcomp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.aug4newcomp.ui.theme.chatOptions

@Composable
fun newChat(viewModel: MainViewModel = viewModel(), navController: NavHostController){

    val contactList =listOf<Contacts>(
        Contacts("abc", "xyz", "CEO", {}),
        Contacts("jkl", "mno", "CTO", {}),
        Contacts("pqrs", "tuv", "Developer", {}),
        Contacts("mno", "pqrs", "Tester", {}),
        Contacts("def", "xyz", "CEO", {}),
        Contacts("ghi", "mno", "CTO", {}),
        Contacts("tux", "tuv", "Developer", {}),
        Contacts("wxyz", "pqrs", "Tester", {}),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xE5212121)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        //Seearch field
        SearchFeild(viewModel)
        if(viewModel.Clicked){
            SearchContacts(contactList, viewModel, navController)
        }
        else{
            ContactScreen(contactList, navController)
        }

    }
}
@Composable
fun ContactScreen(contactList :List<Contacts>, navController : NavHostController ){
   Column(

   ) {
       //create group button
       TextButton(onClick = { /*TODO*/ }) {
           Row(
               modifier= Modifier.padding(top= 10.dp, bottom = 10.dp),
               verticalAlignment = Alignment.CenterVertically
           ) {
               Icon(
                   painter = painterResource(R.drawable.creategroup),
                   contentDescription = "Add FAB",
                   modifier = Modifier.size(30.dp),
                   tint = Color.White,
               )
               Text(text = "Create Group")
           }
       }
       ////chat request button
       TextButton(onClick = { /*TODO*/ }) {
           Row(
               modifier= Modifier.padding(top= 10.dp, bottom = 10.dp),
               verticalAlignment = Alignment.CenterVertically
           ) {
               Icon(
                   painter = painterResource(R.drawable.chartrequest),
                   contentDescription = "Add FAB",
                   modifier = Modifier.size(30.dp),
                   tint = Color.White,
               )
               Text(text = "Chat Request")
           }
       }

       Text(text = "Contacts")
       LazyColumn(){
           items(contactList.size) { index ->
               chatOptions(contactList[index].fullname, contactList[index].title, navController)
           }
       }

   }
}

//search bar function
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchFeild(viewModel: MainViewModel  ){

    TextField(
        value = viewModel.searchItem,
        onValueChange = {
            viewModel.searchItem = it
            if (viewModel.searchItem==""){viewModel.Clicked = false}else{viewModel.Clicked = true}
        },
        label = { Text("Search") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "search",
                    )
            },

            modifier = Modifier
                .fillMaxWidth(.9f)
                .height(50.dp)
                .clip(RoundedCornerShape(50))
        )
}
//Contact list card

class Contacts(fname: String, lname : String, titlename : String, OnClick: ()-> Unit){
    val fname = fname
    val lname = lname
    val fullname = fname + " " + lname
    val title = titlename
}
@Composable
fun SearchContacts (contact : List<Contacts>,viewModel: MainViewModel, navController : NavHostController ){
    for(i in contact){
        if(i.fname.contains(viewModel.searchItem) || i.lname.contains(viewModel.searchItem)){
            chatOptions(i.fullname, i.title, navController)
        }
    }
}


