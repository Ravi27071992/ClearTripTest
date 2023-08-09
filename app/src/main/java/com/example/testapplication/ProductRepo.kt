package com.example.testapplication

class ProductRepo {

    fun getProductList():ArrayList<ProductItemModel>{
       return arrayListOf<ProductItemModel>(
           ProductItemModel("Product - 1",30,4.0),
           ProductItemModel("Product - 2",40,4.7),
           ProductItemModel("Product - 3",60,4.3),
           ProductItemModel("Product - 4",55,4.6)
       ) as ArrayList<ProductItemModel>
    }
}