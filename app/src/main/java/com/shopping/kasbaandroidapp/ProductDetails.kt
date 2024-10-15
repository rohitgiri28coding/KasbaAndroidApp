package com.shopping.kasbaandroidapp

import com.shopping.kasbaandroidapp.R.drawable as r
data class Category(val category: String, val img: Int)
//object Categories{
//    val category = listOf(
//        Category("Categories", r.category_icon),
//        Category("Knee Support", r.drorthokneesupportp1),
//        Category("Back Belt", r.tynorbackbeltp1),
//        Category("Wrist Support", r.flamingowristsuppportp1),
//        Category("Cervical Collar", r.tynorcervicalcollarp1),
//        Category("Forearm And Wrist Support", r.tynorwristandforearmp1),
//        Category("Shoulder Support", r.tynorshouldersupportp2),
//        Category("Fracture Aid", r.healthyogafractureaidp1)
//    )
//}


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
                          val id: Int)

//object ProductDetailedData {
//    val products = listOf(
//        ProductDetails(
//            name = "Knee cap for Men & Women, Knee Sleeve for Pain Relief",
//            brand = "Dr Ortho",
//            category = Categories.category[1].category,
//            size = "S",
//            quantity = 100,
//            mrp = 1099,
//            discountOff = 20,
//            country = "India",
//            details = "Bilayered body of Nylon protects from sports related injuries\n" +
//                    "Made of hypoallergenic material\n" +
//                    "Four-way stretchable provides uniform compression and better grip in sports\n" +
//                    "The material absorbs sweat and dries quickly",
//            weight = 250,
//            rating = 3.8f,
//            imageSet = listOf(r.drorthokneesupportp1,
//            r.drorthokneesupportp2,
//            r.drorthokneesupportp3,
//            r.drorthokneesupportp4,
//            r.drorthokneesupportp5
//        ),
//            id = 1
//        ),
//        ProductDetails(
//            name = "Knee cap for Men & Women, Knee Sleeve for Pain Relief",
//            brand = "Accu Sure",
//            category = Categories.category[1].category,
//            size = "M",
//            quantity = 100,
//            mrp = 1299,
//            discountOff = 40,
//            country = "India",
//            details = "Bilayered body of Nylon protects from sports related injuries\n" +
//                    "Made of hypoallergenic material\n" +
//                    "Four-way stretchable provides uniform compression and better grip in sports\n" +
//                    "The material absorbs sweat and dries quickly",
//            weight = 250,
//            rating = 4.2f,
//            imageSet = listOf(r.accusurekneesupportp1,
//                r.accusurekneesupportp2,
//                r.accusurekneesupportp3,
//                r.accusurekneesupportp4
//            ),
//            id = 2
//        ),
//        ProductDetails(
//            name = "Wrist Support Brace with Thumb Loop for Wrist Pain Relief | Wrist Hand Brace for Men & Women | Wrist Support for Sports Injuries, Fracture Support and Thumb Support | Color-Beige (Universal)",
//            brand = "Flamingo",
//            category = Categories.category[3].category,
//            size = "S",
//            quantity = 100,
//            mrp = 899,
//            discountOff = 25,
//            country = "India",
//            details = "Uniform Compression for Effective Recovery: The elastic design of this wrist support brace provides consistent and uniform compression around the wrist and palmar area. This ensures a supportive environment, aiding in the recovery process for wrist sprains, strains, and moderate injuries. The compression contributes to stabilizing the affected area, allowing for natural healing while helping ease discomfort.\n" +
//                    "Anatomical Thumb Opening for Unrestricted Movement: With a thoughtfully crafted anatomical thumb opening, this wristband for pain relief allows natural and unrestrained thumb and finger movement. This feature maintains mobility while securing the wrist, enabling flexibility, and facilitating daily activities without compromising the healing process.\n" +
//                    "Therapeutic Warmth and Support: Offering both warmth and support to the wrist and palmar area, this elastic wrist support brace provides a comforting environment that encourages healing. The warm and snug fit helps ease discomfort, enhancing the rehabilitation experience while supporting the affected area during recovery.\n" +
//                    "Adaptable for Versatile Use: This wrist wrap for gym for men and women is designed to be adaptable, fitting both left and right wrists. Its versatile nature ensures a convenient and customized fit regardless of which wrist needs support. The universal size accommodates various wrist circumferences, providing comfort and stability for a wide range of users.\n" +
//                    "Effective Aid for Various Conditions: Whether dealing with wrist strains, moderate injuries, or seeking prophylactic support, this wrist support band offers a versatile solution. Its elastic construction, along with the anatomical thumb opening, makes it suitable for multiple wrist-related conditions, aiding recovery and providing stability.",
//            weight = 100,
//            rating = 4.8f,
//            imageSet = listOf(r.flamingowristsuppportp1,
//                r.flamingowristsuppportp2,
//                r.flamingowristsuppportp3,
//                r.flamingowristsuppportp4,
//            ),
//            id = 3
//        ),
//        ProductDetails(
//            name = "GuardNHeal Two Finger Splint Brace (Pack of 1-Small)- Orthopedic Buddy Taping Hand Support- Sports & Gym Aid, Fracture, Sprain, Pain Relief, Heals Injury Faster- Fits Left & Right Hand",
//            brand = "Health And Yoga",
//            category = Categories.category[7].category,
//            size = "S",
//            quantity = 100,
//            mrp = 999,
//            discountOff = 40,
//            country = "India",
//            details = "ORIGINAL HEALTHANDYOGA PRODUCT BY SOULGENIE- GuardNHeal Two Finger Splint helps to keep injured finger protected and immobile for faster healing and comfort. It can be used for finger fracture, sprain, swelling, drop finger, sports injury, mallet finger, basketball or cricket injury.\n" +
//                    "BUDDY TAPING & METAL SPLINT- Injured finger is wrapped with a healthy finger for support. GuardNHeal Two Finger Brace, has finger straps that enable to achieve this concept. It also has a removable Metal Strip for additional support & protection of hand and fingers.\n" +
//                    "LONG WEAR COMFORT- Made of breathable Drytex material. Has padded sponge foam to prevent the splint from digging into the skin. The hand stays comfortable during extended wear at night or day. Lightweight.\n" +
//                    "ADJUSTABLE STRAPS- GuardNHeal has 2 Finger straps, 1 Palm strap in the middle and 1 Wrist strap. These can be fastened and removed as per hand shape, comfort and injury requirement. It can be used for wrapping any two fingers, leaving the other 2 fingers and thumb free.\n" +
//                    "MEN, WOMEN & CHILDREN- Measure your hand size: Using a soft and flexible tape measure, find the distance from the base of your palm to the tip of the longest finger you wish to immobilize (see size chart in Pic). Available in 3 sizes- Large and Medium have 4 straps; Small size has 3 straps.\n",
//            weight = 150,
//            rating = 4.5f,
//            imageSet = listOf(r.healthyogafractureaidp1,
//                r.healthyogafractureaidp2,
//                r.healthyogafractureaidp3,
//                r.healthyogafractureaidp4,
//                r.healthyogafractureaidp5
//            ),
//            id = 4
//        ),
//        ProductDetails(
//            name = "Knee cap for Men & Women, Knee Sleeve for Pain Relief\n",
//            brand = "Nivia",
//            category = Categories.category[1].category,
//            size = "S",
//            quantity = 100,
//            mrp = 1699,
//            discountOff = 50,
//            country = "India",
//            details = "Bilayered body of Nylon protects from sports related injuries\n" +
//                    "Made of hypoallergenic material\n" +
//                    "Four-way stretchable provides uniform compression and better grip in sports\n" +
//                    "The material absorbs sweat and dries quickly",
//            weight = 250,
//            rating = 4.4f,
//            imageSet = listOf(r.niviakneesupportp1,
//                r.niviakneesupportp2,
//                r.niviakneesupportp3,
//                r.niviakneesupportp4,
//                r.niviakneesupportp5
//            ),
//            id = 5
//        ),
//        ProductDetails(
//            name = "Lumbo Sacral Belt, Black, Small, 1 Unit",
//            brand = "Tynor",
//            category = Categories.category[2].category,
//            size = "S",
//            quantity = 100,
//            mrp = 1499,
//            discountOff = 25,
//            country = "India",
//            details = "PERFECT BACK SUPPORT/IMMEDIATE PAIN RELIEF -Tynor Lumbo Sacral Belt provides perfect back support for general use. Its Flexible back splints takes the body shape for comfortable immobilization which relief the immediate lower back pain. More effective results in more relaxation.\n" +
//                    "BREATHABLE MATERIAL - Lumbo sacral belt is made with breathable material. It's highly porous elastic webbing on the sides makes our more ventilated which enhance comfort level of the user.\n" +
//                    "SPECIAL PULL MECHANISM - The double pull mechanism of our belt ensures the perfect fitting and strong fastening of the back. Its large hook panel allows to control the compression giving flexibility of sizing for the user.\n" +
//                    "LIGHTWEIGHT AND EASY TO USE - Tynor Lumbo sacral belt is very light to carry and hastle free. It is super easy to wear and remove which makes it more durable and long lasting. This can be worn over the clothes, making it more user friendly.\n" +
//                    "HEAT RESISTANT RUBBER - The rubber used in our product is heat resistant which helps the user to wear long time",
//            weight = 250,
//            rating = 4.3f,
//            imageSet = listOf(r.tynorbackbeltp1,
//                r.tynorbackbeltp2,
//                r.tynorbackbeltp3,
//                r.tynorbackbeltp4,
//
//            ),
//            id = 6
//        ),
//        ProductDetails(
//            name = "Cervical Collar Soft with Support, Beige, Medium, 1 Unit",
//            brand = "Tynor",
//            category = Categories.category[4].category,
//            size = "M",
//            quantity = 100,
//            mrp = 1899,
//            discountOff = 55,
//            country = "India",
//            details = "Anatomical & rigid design with high cushioning provides rigid support,effective immobilization and enhanced comfort.\n" +
//                    "Adjustable height ensures a secure fit & improved immobilization.\n" +
//                    "Perforted collar body provides improved ventilation and enhanced comfort.\n" +
//                    "Long hook loop tape ensures perfect fitting and easy application.\n" +
//                    "Easy to use, Hypoallergenic(No rash/allergy),good aesthetics, Light in weight, durable and long functional life.",
//            weight = 280,
//            rating = 4.3f,
//            imageSet = listOf(r.tynorcervicalcollarp1,
//                r.tynorcervicalcollarp2,
//                r.tynorcervicalcollarp3,
//                r.tynorcervicalcollarp4,
//
//            ),
//            id = 7
//        ),
//        ProductDetails(
//            name = "Cervical Collar Hard Adjustable, White, Medium, 1 Unit",
//            brand = "Tynor",
//            category = Categories.category[4].category,
//            size = "S",
//            quantity = 100,
//            mrp = 1299,
//            discountOff = 45,
//            country = "India",
//            details = "Anatomical & rigid design with high cushioning provides rigid support,effective immobilization and enhanced comfort.\n" +
//                    "Adjustable height ensures a secure fit & improved immobilization.\n" +
//                    "Perforted collar body provides improved ventilation and enhanced comfort.\n" +
//                    "Long hook loop tape ensures perfect fitting and easy application.\n" +
//                    "Easy to use, Hypoallergenic(No rash/allergy),good aesthetics, Light in weight, durable and long functional life.",
//            weight = 200,
//            rating = 4.7f,
//            imageSet = listOf(r.tynorhardcervicalcollarp1,
//                r.tynorhardcervicalcollarp2,
//                r.tynorhardcervicalcollarp3,
//                r.tynorhardcervicalcollarp4,
//                r.tynorhardcervicalcollarp5
//                ),
//            id = 8
//        ),
//        ProductDetails(
//            name = "Knee cap for Men & Women, Knee Sleeve for Pain Relief\n",
//            brand = "Tynor",
//            category = Categories.category[1].category,
//            size = "S",
//            quantity = 100,
//            mrp = 1499,
//            discountOff = 25,
//            country = "India",
//            details = "Bilayered body of Nylon protects from sports related injuries\n" +
//                    "Made of hypoallergenic material\n" +
//                    "Four-way stretchable provides uniform compression and better grip in sports\n" +
//                    "The material absorbs sweat and dries quickly",
//            weight = 250,
//            rating = 4.3f,
//            imageSet = listOf(r.tynorkneesupportp1,
//                r.tynorkneesupportp2,
//                r.tynorkneesupportp3,
//                r.tynorkneesupportp4,
//                r.tynorkneesupportp5
//            ),
//            id = 9
//        ),
//        ProductDetails(
//            name = "Shoulder Support for Men & Women Double Lock ",
//            brand = "Tynor",
//            category = Categories.category[6].category,
//            size = "M",
//            quantity = 100,
//            mrp = 1299,
//            discountOff = 35,
//            country = "India",
//            details = "Anatomical shape amd four way stretchable fabric provides customized compression,better immobilization.\n" +
//                    "3\" wide stretchable shoulder band ensures strong grip with universal sizing.\n" +
//                    "Neoprene helps in better body heat retention, faster pain relief and appealing aesthetics.\n" +
//                    "Can be worn inconspicuously under clothing.\n" +
//                    "Easy to use, washable, light weight,sleek design, bilateral symmetry, pleasing aesthetics,long functional life & durable.\n",
//            weight = 220,
//            rating = 4.3f,
//            imageSet = listOf(r.tynorshouldersupportp1,
//                r.tynorshouldersupportp2,
//                r.tynorshouldersupportp3,
//                r.tynorshouldersupportp4,
//                r.tynorshouldersupportp5,
//                r.tynorshouldersupportp6
//            ),
//            id = 10
//        ),
//        ProductDetails(
//            name = "Forearm And Elastic Wrist Splint, Grey, Left, Large",
//            brand = "Tynor",
//            category = Categories.category[5].category,
//            size = "L",
//            quantity = 100,
//            mrp = 1899,
//            discountOff = 65,
//            country = "India",
//            details = "It provides perfect immobilization to wrist and forearm with long length of brace and removable splint.\n" +
//                    "Excellent aesthetics, optimum compression & customizable fititng enhances user experience.\n" +
//                    "Built in opening helps in better pair relief and further enhances comfort.\n" +
//                    "Easy to use, breathable, long functional lift, light weight and durable.\n" +
//                    "EXACT FIT - For perfect fit and more comfort we recommend user to strictly follow the size chart shown and measurement must be taken according to the instructions provided.",
//            weight = 250,
//            rating = 3.9f,
//            imageSet = listOf(r.tynorwristandforearmp1,
//                r.tynorwristandforearmp2,
//                r.tynorwristandforearmp3,
//                r.tynorwristandforearmp4,
//            ),
//            id = 11
//        ),
//        ProductDetails(
//            name = "Wrist Band for Men & Women, Wrist Supporter for Gym Wrist Wrap/Straps Gym Accessories for Men for Hand Grip & Wrist Support While Workout & Muscle Relaxation",
//            brand = "Tynor",
//            category = Categories.category[4].category,
//            size = "S",
//            quantity = 100,
//            mrp = 899,
//            discountOff = 15,
//            country = "India",
//            details = "Uniform Compression for Effective Recovery: The elastic design of this wrist support brace provides consistent and uniform compression around the wrist and palmar area. This ensures a supportive environment, aiding in the recovery process for wrist sprains, strains, and moderate injuries. The compression contributes to stabilizing the affected area, allowing for natural healing while helping ease discomfort.\n" +
//                    "Anatomical Thumb Opening for Unrestricted Movement: With a thoughtfully crafted anatomical thumb opening, this wristband for pain relief allows natural and unrestrained thumb and finger movement. This feature maintains mobility while securing the wrist, enabling flexibility, and facilitating daily activities without compromising the healing process.\n" +
//                    "Therapeutic Warmth and Support: Offering both warmth and support to the wrist and palmar area, this elastic wrist support brace provides a comforting environment that encourages healing. The warm and snug fit helps ease discomfort, enhancing the rehabilitation experience while supporting the affected area during recovery.\n" +
//                    "Adaptable for Versatile Use: This wrist wrap for gym for men and women is designed to be adaptable, fitting both left and right wrists. Its versatile nature ensures a convenient and customized fit regardless of which wrist needs support. The universal size accommodates various wrist circumferences, providing comfort and stability for a wide range of users.\n" +
//                    "Effective Aid for Various Conditions: Whether dealing with wrist strains, moderate injuries, or seeking prophylactic support, this wrist support band offers a versatile solution. Its elastic construction, along with the anatomical thumb opening, makes it suitable for multiple wrist-related conditions, aiding recovery and providing stability.",
//            weight = 250,
//            rating = 4.9f,
//            imageSet = listOf(r.tynorwristsuppportp1,
//                r.tynorwristsuppportp2,
//                r.tynorwristsuppportp3,
//                r.tynorwristsuppportp4,
//            ),
//            id = 11
//        )
//    )
//
//}
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
