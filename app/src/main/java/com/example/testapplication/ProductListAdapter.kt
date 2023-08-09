package com.example.testapplication
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductListAdapter(private val context: Context, var itemList: ArrayList<ProductItemModelApi>) :
    RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var mTxtProductName: TextView
        var mTxtProductPrice: TextView
        var mTxtProductRating: TextView
        var mImgProduct : ImageView

        init {
            mTxtProductName = view.findViewById(R.id.mTxtProductName)
            mTxtProductPrice = view.findViewById(R.id.mTxtProductPrice)
            mTxtProductRating = view.findViewById(R.id.mTxtProductRating)
            mImgProduct = view.findViewById(R.id.mImgProduct)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mTxtProductName.text = itemList[position].title
        holder.mTxtProductPrice.text = "\u20B9 ${itemList[position].price}"
        holder.mTxtProductRating.text = "Rating - ${itemList[position].Rating.rate}"

//        Picasso.with(context)
//            .load(itemList[position].image)
//            .into(holder.mImgProduct)
    }

    fun updateProductList(updatedList:ArrayList<ProductItemModelApi>){
        itemList.clear()
        itemList.addAll(updatedList)
        notifyDataSetChanged()
    }

}