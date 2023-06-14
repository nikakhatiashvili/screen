package com.example.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.screen.ui.theme.DarkModeColors
import com.example.screen.ui.theme.ScreenTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.coroutines.launch



@OptIn(ExperimentalPagerApi::class)
@Composable
fun CustomTabs(state: PagerState, list: List<String>) {
    var selectedIndex by remember { mutableStateOf(0) }
    val scope = rememberCoroutineScope()


    TabRow(
        selectedTabIndex = state.currentPage,
        backgroundColor = colorResource(id = R.color.tab_layout),
        modifier = Modifier
            .padding(vertical = 1.dp, horizontal = 8.dp)
            .clip(RoundedCornerShape(25))
            .background(colorResource(id = R.color.tab_layout))
            .fillMaxWidth()
            .wrapContentHeight()
            .border(1.dp, color = colorResource(id = R.color.selected), RoundedCornerShape(25)),
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.pagerTabIndicatorOffset(state, tabPositions),
                height = 5.dp,
                color = colorResource(id = R.color.selected)
            )
        }
    ) {
        list.forEachIndexed { index, text ->
            val selected = state.currentPage == index
            Tab(
                modifier = if (selected) Modifier
                    .clip(RoundedCornerShape(20))
                    .background(
                        colorResource(id = R.color.selected)
                    )
                    .wrapContentSize()
                else Modifier
                    .clip(RoundedCornerShape(20))
                    .background(
                        color = colorResource(id = R.color.tab_layout)
                    )
                    .wrapContentSize(),
                selected = selected,
                onClick = {
                    scope.launch {
                        state.animateScrollToPage(index)
                    }
                },
                text = {
                    Text(
                        text = text,
                        color = if (selected) Color.White else Color.Gray,
                        fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
                    )
                }
            )
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabContent(tabData: List<String>, pagerState: PagerState) {
    HorizontalPager(state = pagerState) { index ->
        when (index) {
            0 -> {
                ProductsScreen()
            }
            1 -> {
                ProductsScreen()
            }
        }

    }
}



@Composable
fun OffersScreen(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp)
    ) {
        Text(text = "Offers screen",color = Color.White)
    }
}

@Preview
@Composable
fun ProductsPreview() {
    ScreenTheme {
        //Products()
    }
}