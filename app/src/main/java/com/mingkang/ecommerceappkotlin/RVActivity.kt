package com.mingkang.ecommerceappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_r_v.*

class RVActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_r_v)

        var myProductList = ArrayList<EProduct>()
        myProductList.add(EProduct(0,"iPhone", 399,R.drawable.iphone))
        myProductList.add(EProduct(1,"MacBookA ir", 5499,R.drawable.macbookair))
        myProductList.add(EProduct(2,"MacBook Pro", 7499,R.drawable.macbookpro))
        myProductList.add(EProduct(3,"iMac", 8499,R.drawable.imac))
        myProductList.add(EProduct(4,"PS4", 1299,R.drawable.ps4))

        var rvAdapter = RVAdapter(this@RVActivity,myProductList)
        recyclerView.layoutManager = LinearLayoutManager(this@RVActivity)
        recyclerView.adapter = rvAdapter
    }
}
