package com.mingkang.ecommerceappkotlin

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_get_all_json_object.*

class GetAllJsonObjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_all_json_object)

        textView3.setOnClickListener {
            val allProductURL = "http://192.168.43.132/Ecommerc/present_json_array.php"
            var allProductsString = ""
            val requestQ = Volley.newRequestQueue(this@GetAllJsonObjectActivity)
            val jsonAR = JsonArrayRequest(Request.Method.GET,allProductURL,null,
                Response.Listener { response ->
                    for(productIndex in 0.until(response.length())){
//                        allProductsString += response.getJSONObject(productIndex).getString("name") + " - " +
//                                response.getJSONObject(productIndex).getInt("price")
                        var pn = response.getJSONObject(productIndex).getString("name")
                        var pp = response.getJSONObject(productIndex).getInt("price")

                        allProductsString += pn + " - " + pp + "\n"
                    }
                    txtAllProduct.text = allProductsString
                },
                Response.ErrorListener { error -> txtAllProduct.text = error.message })
            requestQ.add(jsonAR)
        }
    }
}
