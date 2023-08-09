package com.example.testapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main_app.*

class ProductListActivity : AppCompatActivity() {

    var productViewModel: ProductViewModel? = null
    var productListAdapter: ProductListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_app)

        setUpObserver()
        productListAdapter = ProductListAdapter(this@ProductListActivity, arrayListOf())
        mRcItem?.apply {
            layoutManager =
                LinearLayoutManager(this@ProductListActivity, LinearLayoutManager.VERTICAL, false)
            adapter = productListAdapter
            setHasFixedSize(true)
        }
    }

    private fun setUpObserver() {
        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        productViewModel?.productData?.observe(this, Observer {
            productListAdapter?.updateProductList(it)
//            Toast.makeText(this@ProductListActivity,it.size.toString(),Toast.LENGTH_SHORT).show()
        })
    }
}