package com.shopping.kasbaandroidapp.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.shopping.kasbaandroidapp.Categories

class CategoryContent
{
    @Composable
    fun GenerateLazyRow(onClicked: (String) -> Unit){
        LazyRow (horizontalArrangement = Arrangement.spacedBy(4.dp)){
            items(Categories.categories){ cat->
                GenerateImage(
                    drawable = cat.img,
                    text = cat.category,
                    onClick = {onClicked(cat.category)}
                )
            }
        }
    }
    @Composable
    fun GenerateImage(
        drawable: Int,
        text: String,
        onClick: (String) -> Unit,
        modifier: Modifier = Modifier,
    ) {
        Column(
            modifier = modifier
                .wrapContentSize()
                .clickable {
                    onClick(text)
                },
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .size(88.dp)
                    .clip(CircleShape)
                    .border(1.dp, Color.Gray, shape = CircleShape)
            )
            Box(modifier = Modifier.size(width = 88.dp, height = 20.dp)) {
                Text(
                    text = text,
                    modifier = Modifier
                        .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
                        .align(Alignment.Center),
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }

}