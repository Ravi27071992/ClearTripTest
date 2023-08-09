package com.example.testapplication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    var productData = MutableLiveData<ArrayList<ProductItemModelApi>>()
    val apiService = RetrofitClient.getInstance().create(ApiService::class.java)

    init {
        getProductList()
    }

    private fun getProductList() {
        viewModelScope.launch {
            val result = apiService.getProductList()
            if (result != null)
                productData.value = result.body() as ArrayList<ProductItemModelApi>?
        }
    }


    // launching a new coroutine
//    GlobalScope.launch {
//        val result = quotesApi.getQuotes()
//        if (result != null)
//        // Checking the results
//            Log.d("ayush: ", result.body().toString())
//    }


}