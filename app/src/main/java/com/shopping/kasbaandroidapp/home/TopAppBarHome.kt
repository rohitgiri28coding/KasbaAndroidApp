package com.shopping.kasbaandroidapp.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shopping.kasbaandroidapp.R

class TopAppBarHome {
    @Composable
    fun GenerateTopAppBarHome(modifier: Modifier = Modifier) {
        Column(modifier.background(MaterialTheme.colorScheme.primaryContainer)) {
            AddWelcomeAndCartSection(modifier = modifier)
//        SearchBar(query = , onQueryChange = , onSearch = , active = , onActiveChange = ) {}
            AddSearchBar(modifier = modifier)
            AddDeliveryLocation(modifier = modifier)
        }
    }

    @Composable
    fun AddWelcomeAndCartSection(modifier: Modifier) {

        Box(
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 66.dp),

            ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.padding(top = 10.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile Section",
                    modifier.padding(start = 5.dp)
                )
                Column(modifier = modifier.padding(start = 10.dp)) {
                    Text(text = "Welcome", fontSize = 18.sp)
                    Row {
                        Text(
                            text = "SIGN IN",

                            )
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "Goto Profile Section"
                        )
                    }
                }
            }
            Icon(
                painter = painterResource(id = R.drawable.cart),
                contentDescription = "Cart",
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 10.dp)
            )
        }
    }

    @Composable
    fun AddSearchBar(
        modifier: Modifier
    ) {
        Box {

            TextField(
                value = "",
                onValueChange = {},
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                }, trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.microphone),
                        contentDescription = null
                    )
                },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    focusedContainerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                placeholder = {
                    Text(stringResource(R.string.placeholder_search))
                },
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(min = 45.dp)
                    .border(width = 1.dp, color = Color.Gray)
            )
        }
    }

    @Composable
    fun AddDeliveryLocation(modifier: Modifier) {

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 5.dp)
                .heightIn(min = 40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { }) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.location
                    ),
                    contentDescription = "Location Icon",
                    modifier = modifier.padding(start = 10.dp)
                )
            }
            Text(
                text = "Add delivery location",
                fontSize = 14.sp,

                modifier = modifier
                    .padding(start = 20.dp)
            )
        }
    }
}