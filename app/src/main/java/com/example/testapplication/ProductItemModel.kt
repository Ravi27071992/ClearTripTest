package com.example.testapplication

//data class ProductData(var data: List<ProductItemModel>)
data class ProductItemModel(var prName: String, var prPrice: Int, var prRating: Double)

data class ProductItemModelApi(var id: Int, var title: String, var price: Double,var description: String, var category: String, var image: String,var Rating:Rating )
data class Rating(var rate:Double,var count:Int)