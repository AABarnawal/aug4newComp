package com.example.aug4newcomp

import android.annotation.SuppressLint
import android.drm.DrmStore.RightsStatus
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aug4newcomp.ui.theme.ChatApp
import kotlinx.coroutines.launch

enum class NavigationScreenApp {
    Home,
    Chat,
    NewChat,
    ChatWindow
}
//topBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenTopAppBar(
    name : String,
    currentScreen: NavigationScreenApp,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    chatOrNot : Boolean = false
)
{
    if(chatOrNot){
        TopAppBar(
            title = {
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = "Localized description",
                            modifier = Modifier.size(60.dp)
                        )
                    }
                    Text(
                        name,
                        maxLines = 1,
                    )
                }
            },

            navigationIcon = {
                if (canNavigateBack) {
                    IconButton(onClick = navigateUp) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Go Back"
                        )
                    }
                }
            },
        )
    }else{
        TopAppBar(
            title = {
                Text(
                    text = name,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                )
                    },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xE5212121)),
            navigationIcon = {
                if (canNavigateBack) {
                    IconButton(onClick = navigateUp) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Go Back",
                            tint = Color.White,
                        )
                    }
                }
            }
        )}
}
//bottombar , bottom sheet and navigation
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationScreenApp(
    viewModel: MainViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = NavigationScreenApp.valueOf(
        backStackEntry?.destination?.route ?: NavigationScreenApp.Home.name
    )
    //bottomSheet
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState()
    var flag by remember { mutableStateOf(1) }
    var sheetGesturesEnabled by remember { mutableStateOf(false) }
    var topBarName by remember { mutableStateOf("Planter's App") }
    var ChatOrNot by remember { mutableStateOf(false) }
    //bottomsheet function
    fun exp(){
        if(flag==1){
            scope.launch { scaffoldState.bottomSheetState.expand() }
            sheetGesturesEnabled = true
            flag--
        }
        else{
            scope.launch { scaffoldState.bottomSheetState.partialExpand() }
            sheetGesturesEnabled = false
            flag++
        }
    }
    val items = listOf<bottomItems>(
        bottomItems(painterResource(R.drawable.tree), "Tag", {  }),
        bottomItems(painterResource(R.drawable.trace), "Trace", {  }),
        bottomItems(painterResource(R.drawable.track), "Track",{ }),
        bottomItems(painterResource(R.drawable.more), "More", {exp() })
    )
    Scaffold(
        //topbar Scaffold
        topBar = {
            ScreenTopAppBar(
                name = topBarName,
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
                chatOrNot = ChatOrNot
            )
            Modifier.fillMaxWidth()
                 },
        bottomBar = {
            if(!ChatOrNot){
            NavigationBar(
                modifier = Modifier
                    .clip(RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp)),
                containerColor = Color(0xE53a3a3a)
                ){
                items.forEachIndexed { index1, item ->
                    NavigationBarItem(
                        icon = { Icon(
                            painter = item.imgg,
                            contentDescription =item.cnt,
                            modifier = Modifier
                                .size(20.dp),
                            tint = Color.Unspecified,
                        ) },
                        label = {  Text(text = item.cnt, color = Color.White )},
                        selected = true ,
                        onClick = { item.executeFunction() },

                    ) }
            } }}
    ) {
        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetSwipeEnabled = sheetGesturesEnabled,
            sheetPeekHeight = 0.dp,
//            sheetTonalElevation = 50.dp,
            sheetContainerColor = Color(0xFF000000),
            sheetContent = {

                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                ) {
                    // bottom sheet menu
                    BottomSheetMenu(navController, { exp() })
                }
            }) { innerPadding ->
            Box(Modifier.padding(innerPadding)) {
                //navigation
                NavHost(
                    navController = navController,
                    startDestination = NavigationScreenApp.Home.name,
//                    modifier = Modifier.padding(innerPadding)
                ) {

                    composable(route = NavigationScreenApp.Home.name) {
                        HomeApp()
                        topBarName = "Planter's App"
                        ChatOrNot = false
                    }
                    composable(route = NavigationScreenApp.Chat.toString()) {
                        ChatApp(navController)
                        topBarName = "Chat"
                        ChatOrNot = false
                    }
                    composable(route = NavigationScreenApp.NewChat.toString()) {
                        newChat(navController =navController)
                        topBarName = "New Chat"
                        ChatOrNot = false
                    }
                    composable(route = NavigationScreenApp.ChatWindow.toString()) {
                        ChatWindow("raj", "@raj", painterResource(id = R.drawable.profile))
                        topBarName = "name"
                        ChatOrNot = true
                    }
                }
        }
        }
    }
}


