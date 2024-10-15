package com.shopping.kasbaandroidapp

import com.shopping.kasbaandroidapp.R.drawable as r

data class Category(val category: String, val img: Int)

data class ProductDetails(val name: String,
                          val brand: String,
                          val category: String,
                          val size: String,
                          val quantity: Int,
                          val mrp: Int,
                          val discountOff: Int,
                          val country: String,
                          val details: String,
                          val weight: Int,
                          val rating: Float,
                          val imageSet: List<Int>,
                          val id: Int
)
object Categories {
    val categories = listOf(
        Category("Categories", r.category_icon),
        Category("Sarees", r.saree),
        Category("Kurtas & Kurtis", r.p2_2),
        Category("Jewelry", r.necklace),
        Category("Handicrafts", r.handicraft),
        Category("Footwear",r.shoes),
        Category("Home Decor", r.p1_2),
        Category("Traditional Bags", r.bag),
        Category("Puja Essentials", r.pooja),
        Category("Shawls", r.p3_2),
    )
}
object ProductDetailedData {
    val products = listOf(
        ProductDetails(
            name = "Handmade Madhubani Painting Wall Hanging",
            brand = "Crafts of Mithila",
            category = "Handicrafts",
            size = "24x18 inches",
            quantity = 50,
            mrp = 3499,
            discountOff = 30,
            country = "India",
            details = "Traditional Madhubani painting handcrafted on natural canvas, representing Indian folklore. Perfect for home décor.",
            weight = 500,
            rating = 4.6f,
            imageSet = listOf(r.p1_1, r.p1_2, r.p1_3, r.p1_4),
            id = 1
        ),
        ProductDetails(
            name = "Chikankari Kurta Set",
            brand = "Awadh Weaves",
            category = "Ethnic Wear",
            size = "M",
            quantity = 200,
            mrp = 2499,
            discountOff = 25,
            country = "India",
            details = "Handcrafted Lucknowi Chikankari kurta set with cotton dupatta. A perfect choice for festive occasions.",
            weight = 400,
            rating = 4.5f,
            imageSet = listOf(r.p2_1, r.p2_2, r.p2_3, r.p2_4),
            id = 2
        ),
        ProductDetails(
            name = "Pashmina Wool Shawl",
            brand = "Kashmir Handloom",
            category = "Accessories",
            size = "200x70 cm",
            quantity = 80,
            mrp = 7499,
            discountOff = 40,
            country = "India",
            details = "Luxurious Kashmiri Pashmina shawl with intricate embroidery. Lightweight, warm, and elegant.",
            weight = 300,
            rating = 4.9f,
            imageSet = listOf(r.p3_1, r.p3_2, r.p3_3, r.p3_4),
            id = 3
        ),
        ProductDetails(
            name = "Terracotta Necklace Set",
            brand = "Bengal Artisans",
            category = "Jewelry",
            size = "One Size",
            quantity = 150,
            mrp = 1999,
            discountOff = 15,
            country = "India",
            details = "Handcrafted terracotta necklace set with intricate patterns, perfect for ethnic wear.",
            weight = 100,
            rating = 4.7f,
            imageSet = listOf(r.p4_1, r.p4_2, r.p4_3, r.p4_4),
            id = 4
        ),
        ProductDetails(
            name = "Brass Diya for Pooja",
            brand = "South Indian Handicrafts",
            category = "Home Décor",
            size = "Small",
            quantity = 300,
            mrp = 599,
            discountOff = 20,
            country = "India",
            details = "Traditional brass diya used for pooja and religious rituals. Handmade by local artisans.",
            weight = 250,
            rating = 4.8f,
            imageSet = listOf(r.p5_1, r.p5_2, r.p5_3, r.p5_4),
            id = 5
        ),
        ProductDetails(
            name = "Jute Handbag",
            brand = "Green Earth",
            category = "Bags",
            size = "Medium",
            quantity = 120,
            mrp = 899,
            discountOff = 30,
            country = "India",
            details = "Eco-friendly jute handbag with ethnic prints. Sturdy, stylish, and sustainable.",
            weight = 350,
            rating = 4.4f,
            imageSet = listOf(r.p6_1, r.p6_2, r.p6_3, r.p6_4),
            id = 6
        ),
        ProductDetails(
            name = "Rajasthani Block Print Bedsheet",
            brand = "Jaipur Crafts",
            category = "Home Textiles",
            size = "Queen",
            quantity = 70,
            mrp = 1599,
            discountOff = 25,
            country = "India",
            details = "Hand block printed cotton bedsheet from Rajasthan. Vibrant and perfect for ethnic-themed bedrooms.",
            weight = 1200,
            rating = 4.5f,
            imageSet = listOf(r.p7_1, r.p7_2, r.p7_3, r.p7_4),
            id = 7
        ),
        ProductDetails(
            name = "Banarasi Silk Saree",
            brand = "Varanasi Silks",
            category = "Sarees",
            size = "Free Size",
            quantity = 50,
            mrp = 6999,
            discountOff = 35,
            country = "India",
            details = "Elegant Banarasi silk saree with traditional zari work. Perfect for weddings and special occasions.",
            weight = 600,
            rating = 4.9f,
            imageSet = listOf(r.p8_1, r.p8_2, r.p8_3, r.p8_4),
            id = 8
        ),
        ProductDetails(
            name = "Clay Water Pot",
            brand = "Terracotta Treasures",
            category = "Kitchenware",
            size = "1 liters",
            quantity = 60,
            mrp = 999,
            discountOff = 20,
            country = "India",
            details = "Eco-friendly terracotta water pot. Keeps water naturally cool and fresh. Ideal for summers.",
            weight = 2500,
            rating = 4.6f,
            imageSet = listOf(r.p9_1, r.p9_2, r.p9_3, r.p9_4),
            id = 9
        ),
        ProductDetails(
            name = "Wooden Handcrafted Table Lamp",
            brand = "Kashmir Woodworks",
            category = "Home Décor",
            size = "Medium",
            quantity = 40,
            mrp = 1999,
            discountOff = 45,
            country = "India",
            details = "Handcrafted wooden table lamp with intricate carvings. A beautiful addition to any room.",
            weight = 1500,
            rating = 4.7f,
            imageSet = listOf(r.p10_1, r.p10_2, r.p10_3, r.p10_4),
            id = 10
        )
    )
}
