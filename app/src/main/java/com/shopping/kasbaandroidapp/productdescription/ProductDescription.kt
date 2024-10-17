package com.shopping.kasbaandroidapp.productdescription

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shopping.kasbaandroidapp.ProductDetailedData
import com.shopping.kasbaandroidapp.R
import com.shopping.kasbaandroidapp.home.BottomAppBarHome
import kotlinx.coroutines.launch
import kotlin.math.cos
import kotlin.math.sin

class ProductDescription{
    @Composable
    fun LoadProductInFullPage(id: Int) {
        Scaffold(topBar = {
            Surface(
                color = MaterialTheme.colorScheme.primaryContainer,
                modifier = Modifier
                    .border(width = 2.dp, color = Color.Gray)
                    .fillMaxWidth()
                    .heightIn(max = 180.dp)
            )
            {   val obj = TopAppBarProduct()
                obj.TopAppBarCommon()
            }
        }, bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primaryContainer)
                ) {
                        val obj = BottomAppBarHome()
                        obj.BottomAppBar(modifier = Modifier)
                }
            }
        }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) { Spacer(modifier = Modifier.size(4.dp))
                GenerateLazyColumn(id)
            }
        }
    }
    @Composable
    private fun GenerateLazyColumn(id: Int){
        var fullImage by rememberSaveable {
            mutableStateOf(false)
        }
        var images: List<Int> = ProductDetailedData.products.find { it.id == id }?.imageSet ?: ProductDetailedData.products[0].imageSet

        if (fullImage){
            OpenImageFullScreen(imageSet = images, onClicked = {fullImage = false})
        }
        else {
            LazyColumn {
                item {
                    SimpleMarqueeAd()
                    LoadDetail(id)
                    GenerateProductImage(id, onClick = {imageSet ->
                        images = imageSet
                        fullImage = true
                    })
                }
                item {
                    PriceDetail(id)
                    BuyOrAddToCart(id)
                    ProductDetailedDescription(id = id)
                }
            }
        }
    }
    @Composable
    private fun ProductDetailedDescription(id: Int) {
        Column (modifier = Modifier
            .border(2.dp, Color.Gray)
            .padding(6.dp)){
            Column  {
                Text(
                    text = "Product Details",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.W500,
                    modifier = Modifier.padding(bottom = 4.dp, top = 4.dp, start = 20.dp)
                )
                HorizontalDivider(
                    modifier = Modifier.padding(start = (2).dp),
                    thickness = 2.dp,
                    color = Color.Gray
                )
            }
            val product = ProductDetailedData.products.find { it.id == id }
            Column(
                modifier = Modifier.padding(start = 20.dp, top = 18.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ){
                product?.let {
                    Row {
                        Text(
                            text = "Name:             ",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W500
                        )
                        Text(
                            text = product.brand+" "+product.category,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W500
                        )
                    }
                    Text(
                        text = "Brand:              ${product.brand}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W500
                    )
                    Text(
                        text = "Category:         ${product.category}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W500
                    )
                    Text(
                        text = "Color:               Black",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W500
                    )
                    Text(
                        text = "Fit:                    Regular Fit",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W500
                    )
                    Text(
                        text = "Off:                   ${product.discountOff}%",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W500
                    )
                    Row {

                        Text(
                            text = "Other Details:  ",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W500
                        )
                        Text(
                            text = product.details,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W500
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun SimpleMarqueeAd() {
        Column(Modifier.fillMaxWidth()) {
            Text(
                "This is a simple advertisement that tells that this app can sponsor other things which lets you earn more money. Thank You! ",
                modifier = Modifier
                    .basicMarquee(velocity = 70.dp)
                    .padding(4.dp),
                fontSize = 20.sp
            )
        }
    }
    @Composable
    private fun BuyOrAddToCart(id: Int) {
        val product = ProductDetailedData.products.find { it.id == id }
        product?.let {
            Box(modifier = Modifier
                .fillMaxSize()
                .border(2.dp, Color.Gray)) {
                Column(
                    modifier = Modifier.padding(start = 20.dp, top = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(0.dp)
                ) {
                    Row {
                        Text(text = "Total: ", fontSize = 20.sp, fontWeight = FontWeight.W500)
                        Text(text = "₹${(it.discountOff*it.mrp)/100}", fontSize = 22.sp, fontWeight = FontWeight.W500)
                    }
                    Spacer(modifier = Modifier.heightIn(4.dp))
                    Text(
                        text = "Free Delivery Monday.",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W500
                    )
                    Row {

                        Column {
                            Spacer(modifier = Modifier.heightIn(10.dp))
                            Text(
                                text = "Deliver to Patna.",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.W500,
                                textAlign = TextAlign.Center,
                            )
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.location),
                                contentDescription = "Location"
                            )
                        }
                    }
                    Text(
                        text = "In Stock", fontSize = 24.sp, color = Color(
                            red = 0.0f,
                            green = 0.463f,
                            blue = 0.0f,
                            alpha = 1.0f
                        ), modifier = Modifier.padding(bottom = 2.dp)
                    )
                    DropdownList()

                    Spacer(modifier = Modifier.size(25.dp))
                    BuyAndAddToCart(text = "Add To Cart", modifier = Modifier)
                    BuyAndAddToCart(text = "Buy Now", modifier = Modifier)
                    Spacer(modifier = Modifier.size(35.dp))
                }
            }
        }
    }
@Composable
private fun BuyAndAddToCart(text: String, modifier: Modifier)
     {
        Box(modifier = modifier
            .fillMaxSize()
            .padding(10.dp),
            contentAlignment = Alignment.Center)
        {
            Text(
                text = text,
                modifier = Modifier
                    .drawWithCache {
                        val brush = Brush.linearGradient(
                            listOf(
                                Color(0xFF9E82F0),
                                Color(0xFF42A5F5)
                            )
                        )
                        onDrawBehind {
                            drawRoundRect(
                                brush,
                                cornerRadius = CornerRadius(10.dp.toPx())
                            )
                        }
                    }
                    .padding(horizontal = 10.dp, vertical = 10.dp)
                    .size(width = 300.dp, height = 40.dp)
                    .clickable { }
                ,
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp
            )
        }
    }
    @Composable
    private fun PriceDetail(id: Int) {
        val product = ProductDetailedData.products.find { it.id == id }
        product?.let {
            Column (modifier = Modifier.border(2.dp, Color.Gray)){
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                    ){
                    Text(text = "-${it.discountOff}% ",
                        fontSize = 50.sp,
                        fontWeight = FontWeight.W200,
                        color = Color(red = 0.835f, green = 0.271f, blue = 0.271f, alpha = 1.0f),
                        modifier = Modifier.padding(start = 10.dp))
                    Row {
                        Text(text = " ₹", fontSize = 30.sp)
                        Text(
                            text = "${it.discountOff*it.mrp/100}",
                            fontSize = 50.sp,
                            fontWeight = FontWeight.W400
                            )
                    }
                }
                Row (modifier = Modifier.padding(start = 20.dp, bottom = 5.dp)){
                    Text(
                        text = "M.R.P.:  ",
                        fontSize = 20.sp,
                        color = Color(red = 0.259f, green = 0.267f, blue = 0.263f, alpha = 1.0f),
                        fontWeight = FontWeight.W400
                    )
                    Text(
                        text="₹${it.mrp}",
                        fontSize = 20.sp,
                        color = Color(red = 0.259f, green = 0.267f, blue = 0.263f, alpha = 1.0f),
                        style = TextStyle(textDecoration = TextDecoration.LineThrough),
                        fontWeight = FontWeight.W400
                    )
                }
                Text(text = "Inclusive of all Taxes",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.W400,
                    modifier = Modifier.padding(start = 20.dp, bottom = 10.dp))
            }
        }
    }
    @Composable
    fun DropdownList(){
        LocalContext.current
        var expanded by rememberSaveable { mutableStateOf(false) }
        var text by remember {
            mutableIntStateOf(1)
        }
        Card (elevation = CardDefaults.cardElevation(5.dp), border = BorderStroke(2.dp, Color.DarkGray)){
            Row(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(6.dp)

                    .clickable { expanded = !expanded },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "$text",
                    fontSize = 22.sp,
                    modifier = Modifier.padding(start = 2.dp)
                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "DropDown"
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("1") },
                        onClick = {
                            text = 1
                            expanded = !expanded}
                    )
                    DropdownMenuItem(
                        text = { Text("2") },
                        onClick = {
                            text = 2
                            expanded = !expanded
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("3") },
                        onClick = {
                            text = 3
                            expanded = !expanded
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("4") },
                        onClick = {
                            text = 4
                            expanded = !expanded
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("5") },
                        onClick = {
                            text = 5
                            expanded = !expanded
                        }
                    )

                }
            }
        }
    }
    @Composable
    fun OpenImageFullScreen(imageSet: List<Int>, onClicked: () -> Unit){
        val lazyState: LazyListState = rememberLazyListState()
        LazyRow(
            modifier = Modifier.fillMaxSize(1f),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            state = lazyState
        )
        {
            items(imageSet) { data ->
                Box (modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()
                    .border(2.dp, Color.Black, shape = RoundedCornerShape(4.dp))){
                    Image(
                        painter = painterResource(id = data),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(8.dp)
                            .size(height = 730.dp, width = 380.dp)
                            .border(2.dp, Color.Gray, shape = RoundedCornerShape(4.dp)),
                    )
                    IconButton(onClick = { onClicked() }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close",
                            modifier = Modifier.size(50.dp),
                        )
                    }
                }
            }
        }
    }
    @Composable
    private fun GenerateProductImage(id:Int, onClick:(List<Int>)-> Unit) {
        val product = ProductDetailedData.products.find { it.id == id }
        Box (modifier = Modifier
            .heightIn(min = 300.dp)
            .border(2.dp, Color.Gray)){
            product?.let {
                val images = product.imageSet
                val pagerState = rememberPagerState(pageCount = {images.size})
                val scope = rememberCoroutineScope()
                Box(modifier = Modifier.fillMaxSize()) {
                    HorizontalPager(
                        state = pagerState,
                        modifier = Modifier.fillMaxSize()
                    ) { index ->
                    Image(
                            painter = painterResource(id = images[index]),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable { onClick(images) }
                        )
                    }
                    Box(
                        modifier = Modifier
                            .offset(y = -(16).dp)
                            .fillMaxWidth(0.5f)
                            .clip(RoundedCornerShape(100))
                            .background(MaterialTheme.colorScheme.background)
                            .padding(8.dp)
                            .align(Alignment.BottomCenter)
                    ) {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    pagerState.animateScrollToPage(
                                        pagerState.currentPage - 1
                                    )
                                }
                            },
                            modifier = Modifier.align(Alignment.CenterStart)
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                                contentDescription = "Go back"
                            )
                        }
                        IconButton(
                            onClick = {
                                scope.launch {
                                    pagerState.animateScrollToPage(
                                        pagerState.currentPage + 1
                                    )
                                }
                            },
                            modifier = Modifier.align(Alignment.CenterEnd)
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                                contentDescription = "Go forward"
                            )
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .align(Alignment.TopStart)
                        .padding(start = 4.dp, top = 4.dp)
                ) {

                    Text(
                        text = "${it.discountOff}% OFF",
                        modifier = Modifier
                            .drawWithCache {
                                val brush = Brush.linearGradient(
                                    listOf(
                                        Color(0xFF9E82F0),
                                        Color(0xFF42A5F5)
                                    )
                                )
                                onDrawBehind {
                                    drawRoundRect(
                                        brush,
                                        cornerRadius = CornerRadius(30.dp.toPx())
                                    )
                                }
                            }
                            .padding(horizontal = 10.dp, vertical = 5.dp)
                            .padding(start = 5.dp),
                        color = Color.White,
                        fontSize = 14.sp
                        )
                }

                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .align(Alignment.TopEnd)
                        .padding(end = 4.dp, top = 4.dp)
                ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Share, contentDescription = "Share Button")
                        }
                }
            }
        }
    }
    @Composable
    fun RatingBar(
        rating: Float,
        modifier: Modifier = Modifier,
        color: Color = Color(red = 1.0f, green = 0.643f, blue = 0.11f, alpha = 1.0f)
    ) {
        Row(modifier = modifier.wrapContentSize()) {
            (1..5).forEach { step ->
                val stepRating = when {
                    rating > step -> 1f
                    step.rem(rating) < 1 -> rating - (step - 1f)
                    else -> 0f
                }
                RatingStar(stepRating, color)
            }
        }
    }

    @Composable
    private fun RatingStar(
        rating: Float,
        ratingColor: Color = Color.Yellow,
        backgroundColor: Color = Color.Gray
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .clip(starShape)
        ) {
            Canvas(modifier = Modifier.size(maxHeight)) {
                drawRect(
                    brush = SolidColor(backgroundColor),
                    size = Size(
                        height = size.height * 1.4f,
                        width = size.width * 1.4f
                    ),
                    topLeft = Offset(
                        x = -(size.width * 0.1f),
                        y = -(size.height * 0.1f)
                    )
                )
                if (rating > 0) {
                    drawRect(
                        brush = SolidColor(ratingColor),
                        size = Size(
                            height = size.height * 1.1f,
                            width = size.width * rating
                        )
                    )
                }
            }
        }
    }

    private val starShape = GenericShape { size, _ ->
        addPath(starPath(size.height))
    }

    private val starPath = { size: Float ->
        androidx.compose.ui.graphics.Path().apply {
            val outerRadius: Float = size / 1.8f
            val innerRadius: Double = outerRadius / 2.5
            var rot: Double = Math.PI / 2 * 3
            val cx: Float = size / 2
            val cy: Float = size / 20 * 11
            var x: Float
            var y: Float
            val step = Math.PI / 5

            moveTo(cx, cy - outerRadius)
            repeat(5) {
                x = (cx + cos(rot) * outerRadius).toFloat()
                y = (cy + sin(rot) * outerRadius).toFloat()
                lineTo(x, y)
                rot += step

                x = (cx + cos(rot) * innerRadius).toFloat()
                y = (cy + sin(rot) * innerRadius).toFloat()
                lineTo(x, y)
                rot += step
            }
            close()
        }
    }
    @Composable
    private fun LoadDetail(id: Int){
        val product = ProductDetailedData.products.find { it.id == id }
        Column (modifier = Modifier
            .border(1.dp, Color.Gray)
            .padding(10.dp)){
            product?.let {
                Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                    Row {
                        Text(
                            text = "Brand:  ",
                            fontSize = 24.sp
                        )
                        Text(
                            text = it.brand,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                        Box (modifier = Modifier
                            .background(Color.Transparent)
                            .align(Alignment.CenterVertically), contentAlignment = Alignment.BottomEnd) {
                            RatingBar(
                                it.rating,
                                modifier = Modifier.height(20.dp)
                            )
                    }
                }
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = "${it.brand} ${it.name}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400
                )
                Spacer(modifier = Modifier.width(2.dp))
            }
        }
    }
}