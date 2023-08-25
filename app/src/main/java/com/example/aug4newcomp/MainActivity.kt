package com.example.aug4newcomp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent


import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.material3.ShapeDefaults.Large
import androidx.compose.material3.BottomSheetScaffold

import androidx.compose.runtime.Composable

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.aug4newcomp.ui.theme.Aug4newCompTheme
import com.example.aug4newcomp.ui.theme.ChatApp
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.time.format.TextStyle
import kotlin.math.sqrt

@OptIn(ExperimentalMaterial3Api::class)



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Aug4newCompTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationScreenApp()
//                    newChat()
//                    ChatWindow("raj", "@raj", painterResource(id = R.drawable.profile))
                }
            }
        }
    }
}


//
////top and bottom bar
//@Composable
//@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//fun PlanterDashboard(){
//    val scope = rememberCoroutineScope()
//    val scaffoldState = rememberBottomSheetScaffoldState()
//    var flag by remember { mutableStateOf(1) }
//    var sheetGesturesEnabled by remember { mutableStateOf(false) }
//    fun exp(){
//        if(flag==1){
//            scope.launch { scaffoldState.bottomSheetState.expand() }
//            sheetGesturesEnabled = true
//            flag--
//        }
//        else{
//            scope.launch { scaffoldState.bottomSheetState.partialExpand() }
//            sheetGesturesEnabled = false
//            flag++
//        }
//    }
//    val items = listOf<bottomItems>(
//        bottomItems(painterResource(R.drawable.tree), "Tag", {  }),
//        bottomItems(painterResource(R.drawable.trace), "Trace", {  }),
//        bottomItems(painterResource(R.drawable.track), "Track",{ }),
//        bottomItems(painterResource(R.drawable.more), "More", {exp() })
//    )
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                {
//                    CenterAlignedTopAppBar(
//                        title = {
//                            Text(
//                                text = "Planter's App",
//                                color = Color.White,
//                                modifier = Modifier
//                                    .background(color = Color(0xE5212121))
//                            )
//
//                        })
//                }
//            )
//        } ,
//        bottomBar = {
//            NavigationBar(
//                modifier = Modifier
//                    .clip(RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp))
//            ) {
//                items.forEachIndexed { index1, item ->
//                    NavigationBarItem(
//                        icon = { Icon(
//                            painter = item.imgg,
//                            contentDescription =item.cnt,
//                            modifier = Modifier
//                                .size(20.dp),
//                            tint = Color.Unspecified
//                        ) },
//                        label = {  Text(text = item.cnt)},
//                        selected = true ,
//                        onClick = { item.executeFunction() }
//
//                    )
//
//                }
//
//            }
//
//
//        },) {
//
//        BottomSheetScaffold(
//            scaffoldState = scaffoldState,
//            sheetSwipeEnabled = sheetGesturesEnabled,
////            sheetTonalElevation = 50.dp,
//            sheetContent = {
//
//                Column(
//                    Modifier
//                        .fillMaxWidth()
//                        .padding(10.dp),
//                ) {
//                    // bottom sheet menu
////                    BottomSheetMenu()
//                }
//            }) { innerPadding ->
//            Box(Modifier.padding(innerPadding)) {
//                //home page or main page
//
//
//            }
//
//    }
// } }
