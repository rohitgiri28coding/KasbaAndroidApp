package com.shopping.kasbaandroidapp.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shopping.kasbaandroidapp.R
import com.shopping.kasbaandroidapp.data.NavigationItem
import com.shopping.kasbaandroidapp.ui.theme.BgColor
import com.shopping.kasbaandroidapp.ui.theme.GrayColor
import com.shopping.kasbaandroidapp.ui.theme.Primary
import com.shopping.kasbaandroidapp.ui.theme.Purple40
import com.shopping.kasbaandroidapp.ui.theme.Secondary
import com.shopping.kasbaandroidapp.ui.theme.Shape
import com.shopping.kasbaandroidapp.ui.theme.TextColor

@Composable
fun NormalTextComposable(
    textValue: String,
    fontSize: TextUnit = 24.sp,
    color: Color = TextColor
){
    Text(
        text = textValue,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = fontSize,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color =  color,      //colorResource(id= R.color.colorText) other method
        textAlign = TextAlign.Center
    )
}
@Composable
fun HeadingTextComposable(textValue: String){
    Text(
        text = textValue,
        modifier = Modifier.fillMaxWidth(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,      //colorResource(id= R.color.colorText) other method
        textAlign = TextAlign.Center
    )
}

@Composable
fun MyTextField(
    labelValue: String,
    painterResource: Painter,
    onTextSelected: (String) -> Unit,
){
    var textValue by remember{
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(Shape.small),
        value = textValue,
        onValueChange = {
            textValue = it
            onTextSelected(it)
        },
        label = {Text(text = labelValue)},
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            focusedLabelColor = Color.Black,
            cursorColor = Primary,
            unfocusedContainerColor = BgColor,
            focusedContainerColor = BgColor
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        maxLines = 1,
        singleLine = true,
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = null)
        },
    )

}
@Composable
fun OtpTextField(
    labelValue: String,
    painterResource: Painter,
    isOtpEnabled: Boolean = false
){
    var textValue by remember{
        mutableStateOf("")
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(Shape.small),
        value = textValue,
        onValueChange = {
            textValue = it
        },
        label = {Text(text = labelValue)},
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            focusedLabelColor = Color.Black,
            cursorColor = Primary,
            unfocusedContainerColor = BgColor,
            focusedContainerColor = BgColor
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Number
        ),
        maxLines = 1,
        singleLine = true,
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = stringResource(id = R.string.otp))
        },
        enabled = isOtpEnabled
    )

}

@Composable
fun MyPasswordTextField(
    labelValue: String,
    painterResource: Painter,
    onTextSelected: (String) -> Unit,

){
    val localFocus = LocalFocusManager.current
    var password by remember{
        mutableStateOf("")
    }
    var passwordVisible by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(Shape.small),
        value = password,
        onValueChange = {
            password = it
            onTextSelected(it)
        },
        label = {Text(text = labelValue)},
        placeholder = {
            Text(text = "Rohit#123")
        },
        colors = TextFieldDefaults.colors(
            focusedTextColor = Primary,
            focusedLabelColor = Primary,
            cursorColor = Primary,
            unfocusedContainerColor = BgColor,
            focusedContainerColor = BgColor
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
        maxLines = 1,
        singleLine = true,
        keyboardActions = KeyboardActions { localFocus.clearFocus()},
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = null)
        },
        trailingIcon = {
            val iconImage = if (passwordVisible){
                Icons.Filled.Visibility
            }else{
                Icons.Filled.VisibilityOff
            }
            val description = if (passwordVisible){
                stringResource(R.string.hide_password)
            }else{
                stringResource(R.string.show_password)
            }
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )

}

@Composable
fun CheckBoxComponent(onTextSelected: (String) -> Unit, newCheckedState: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        var checkedState by remember{
            mutableStateOf(false)
        }
        newCheckedState(checkedState)
        Checkbox(checked = checkedState, onCheckedChange = {
            checkedState = !checkedState
        })
//        ClickableTextComponent(onTextSelected)
    }
}

//@Composable
//fun ClickableTextComponent(onTextSelected: (String) -> Unit){
//    val annotatedString = buildAnnotatedString {
//        append(stringResource(R.string.by_continuing_you_accept_our))
//        withStyle(style = SpanStyle(color = Primary)){
//            pushStringAnnotation(
//                tag = stringResource(R.string.privacy_policy),
//                annotation = stringResource(R.string.privacy_policy)
//            )
//            append(stringResource(R.string.privacy_policy))
//        }
//        append(stringResource(R.string.and))
//        withStyle(style = SpanStyle(color = Primary)){
//            pushStringAnnotation(
//                tag = stringResource(R.string.term_of_use),
//                annotation = stringResource(R.string.term_of_use)
//            )
//            append(stringResource(R.string.term_of_use))
//        }
//    }
//    ClickableText(
//        text = annotatedString
//    ) {offset->
//        annotatedString.getStringAnnotations(offset,offset)
//            .firstOrNull()?.also { span->
//                Log.d("ClickableTextComponent", span.toString())
//                if (span.item == "Term of Use" || span.item == "Privacy Policy"){
//                    onTextSelected(span.item)
//                }
//            }
//
//    }
//}

@Composable
fun ButtonComponent(
    value: String,
    isEnabled: Boolean = false,
    onClick: () -> Unit
){
    Button(
        onClick = { onClick.invoke() },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            Color.Transparent
        ),
        enabled = isEnabled
    )
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(Secondary, Primary)
                    ), shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ){
            Text(text = value, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun DividerComponent(){
    Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = GrayColor,
            thickness = 1.dp
        )
        Text(
            text = "or",
            fontSize = 18.sp,
            color = TextColor,
            modifier = Modifier.padding(8.dp)
        )
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = GrayColor,
            thickness = 1.dp
        )
    }
}

//@Composable
//fun ClickableLoginTextComponent(txt: String, clickableText: String,onTextSelected: (String) -> Unit){
//    val annotatedString = buildAnnotatedString {
//        append(txt)
//        withStyle(style = SpanStyle(color = Primary)){
//            pushStringAnnotation(tag = clickableText, annotation = clickableText)
//            append(clickableText)
//        }
//    }
//    ClickableText(text = annotatedString,
//        modifier = Modifier
//            .fillMaxWidth()
//            .heightIn(min = 40.dp),
//        style = TextStyle(
//            fontSize = 18.sp,
//            fontWeight = FontWeight.Normal,
//            fontStyle = FontStyle.Normal,
//            textAlign = TextAlign.Center
//        ),) {offset->
//        annotatedString.getStringAnnotations(offset,offset)
//            .firstOrNull()?.also { span->
//                Log.d("ClickableTextComponent", span.toString())
//                if (span.item == clickableText){
//                    onTextSelected(span.item)
//                }
//            }
//
//    }
//}

@Composable
fun UnderlinedTextComposable(textValue: String, onClick:()->Unit){
    Text(
        text = textValue,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp)
            .clickable {
                onClick()
            },
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = Primary,      //colorResource(id= R.color.colorText) other method
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}

@Composable
private fun BoxedIcon(img: Int, onClick: () -> Unit){
    Card (elevation = CardDefaults.cardElevation(), modifier = Modifier
        .padding(start = 15.dp)
        .clickable { onClick() }){
        Image(painter = painterResource(id = img), contentDescription = null)
    }
}

@Composable
fun AddIcons(onClick: (String) -> Unit){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        BoxedIcon(img = R.drawable.google, onClick = { onClick("google") })
        BoxedIcon(img = R.drawable.facebook, onClick = { onClick("facebook") })
        BoxedIcon(img = R.drawable.apple, onClick = { onClick("apple") })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(topBarText: String, logoutButtonClicked: () -> Unit, openNavigationDrawer: () -> Unit){
    TopAppBar(
        title = { Text(
            text = topBarText,
            color = Color.White,
            modifier = Modifier.padding(start = 30.dp)
        ) },
        navigationIcon = {
            IconButton(onClick = { openNavigationDrawer.invoke() }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = stringResource(id = R.string.home)
                )
            }
        },
        colors = TopAppBarColors(
            containerColor = Purple40,
            scrolledContainerColor = Color.White,
            navigationIconContentColor = Color.White,
            titleContentColor = Color.Black,
            actionIconContentColor = Color.White
        ),
        actions = {
            IconButton(onClick = { logoutButtonClicked() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Logout,
                    contentDescription = stringResource(R.string.logout)
                )
            }
        }
    )
}

@Composable
fun NavigationDrawerHeader(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(32.dp)){
        Text(
            text = "S.R.I.T\n" +
                    "Classes",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal
            ),
            color = Primary,      //colorResource(id= R.color.colorText) other method
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun NavigationDrawerBody(navigationDrawerItems: List<NavigationItem>){
    LazyColumn(modifier = Modifier.fillMaxWidth()){
        items(navigationDrawerItems){
            NavigationItemRow(item = it)
        }
    }
}

@Composable
fun NavigationItemRow(item: NavigationItem){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp))
    {
        Icon(imageVector = item.icon, contentDescription = item.description)
        Spacer(modifier = Modifier.width(5.dp))
        NormalTextComposable(textValue = item.title)
    }

}