package com.example.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.screen.ui.theme.DarkModeColors
import com.example.screen.ui.theme.ScreenTheme

@Composable
fun ProductsScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 70.dp, start = 24.dp, end = 24.dp)
    ) {
        ProductItems()
    }
}

@Composable
fun ProductItems() {
    val list = getList()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(list) { it ->
            ProductItem(it)
        }
    }

}

@Composable
fun ProductItem(product: Product) {
    val selected = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .width(LocalConfiguration.current.screenWidthDp.dp / 3)
            .wrapContentHeight()
            .clip(RoundedCornerShape(10))
            .border(2.dp, color = colorResource(id = R.color.selected))
            .background(colorResource(id = R.color.selected)),
        horizontalAlignment = Alignment.Start,
    ) {
        Image(
            painter = painterResource(id = product.image),
            contentDescription =null,
            modifier = Modifier
                .padding(top = 12.dp, start = 12.dp)
                .clip(CircleShape)
                .height(40.dp)
                .width(40.dp)
                .background(colorResource(id = R.color.background_image))
        )
        Text(
            text = product.mainText,
            color = colorResource(id = R.color.desc_color),
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 15.dp, start = 12.dp),
            maxLines = 1,
            overflow = TextOverflow.Clip,
        )
        Text(
            text = product.description,
            color = colorResource(id = R.color.text_color),
            fontSize = 19.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 15.dp, start = 12.dp, bottom = 15.dp),
            letterSpacing = 1.sp,
            maxLines = 1,
            overflow = TextOverflow.Clip,
        )
    }
}


fun getList(): List<Product> {
    return listOf(
        Product(R.drawable.baseline_person_24, "Accounts (3)", "$421,321,213,2321,421,21,00"),
        Product(R.drawable.baseline_person_24, "Crds (3)", "3 Cards"),
        Product(R.drawable.baseline_person_24, "Deposits (2)", "$4,324,00"),
        Product(R.drawable.baseline_person_24, "Loans (1)", "$3,509,00"),
        Product(R.drawable.baseline_person_24, "Insurance (1)", "$4,129,00"),
        Product(R.drawable.baseline_person_24, "Insurance (1)", "$4,129,00"),
    )
}

data class Product(
    val image: Int,
    val mainText: String,
    val description: String
)

@Preview
@Composable
fun ProductsScreenPreview() {
    ScreenTheme {
        ProductsScreen()
    }
}