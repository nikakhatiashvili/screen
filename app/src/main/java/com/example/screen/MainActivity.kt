package com.example.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.screen.ui.theme.ScreenTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScreenTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen() {
    val tabData = getTabList()
    val pagerState = rememberPagerState(pageCount = tabData.size)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.tab_layout))
    ) {
        TabLayout(tabData, pagerState)
        //TabContent(tabData, pagerState)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(list: List<String>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    Box(modifier = Modifier.padding(start = 1.dp, end = 1.dp, top = 50.dp, bottom = 24.dp)) {
        CustomTabs(pagerState,list)
        Spacer(modifier = Modifier.padding(top = 50.dp))
        TabContent(list,pagerState)
    }
}


@Preview
@Composable
fun MainScreenPreview() {
    ScreenTheme() {
        MainScreen()
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ScreenTheme {
        Greeting("Android")
    }
}

private fun getTabList(): List<String> {
    return listOf(
        "My products",
        "Offers",
    )
}
