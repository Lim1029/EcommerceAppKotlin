package com.mingkang.ecommerceappkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(var context: Context,var arrayList: ArrayList<EProduct>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var productView = LayoutInflater.from(context).inflate(R.layout.rv_row, parent, false)
        return  ProductViewHolder(productView)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ProductViewHolder).initialiseUIComponents(arrayList.get(position).id, arrayList.get(position).name,
        arrayList.get(position).price, arrayList.get(position).productPicture)
    }

    inner class ProductViewHolder(myView: View) :
        RecyclerView.ViewHolder(myView) {
        var pIdTextView = myView.findViewById<TextView>(R.id.rv_row_productId)
        var pNameTextView = myView.findViewById<TextView>(R.id.rv_rpw_productName)
        var pPriceTextView = myView.findViewById<TextView>(R.id.rv_row_productPrice)
        var pImageVIew = myView.findViewById<ImageView>(R.id.rv_row_productImage)

        fun initialiseUIComponents(pId: Int, pName: String, pPrice: Int, pPicture: Int){
            pIdTextView.text = pId.toString()
            pNameTextView.text = pName
            pPriceTextView.text = pPrice.toString()
            pImageVIew.setImageResource(pPicture)
        }
    }

}