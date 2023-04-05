package com.example.animationapp.Model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animationapp.AdapterClass
import com.example.animationapp.Constants
import com.example.animationapp.R
import com.example.animationapp.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
  private lateinit var recyclerView: RecyclerView
    var rvAdapter: AdapterClass? = null
    val data = mutableListOf<Data>()

  //  https://api.giphy.com/v1/gifs/trending?api_key=JUiIRca6foMiuY3AplEwQO4IgZAkfTIg&limit=25&rating=g
    override fun onCreate(savedInstanceState: Bundle?) {
   // recyclerView=findViewById(R.id.animationRecyclerView)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      recyclerView=findViewById(R.id.animationRecyclerView)
      setAdapter()

    }
    private fun setAdapter(){
        val recyclerview =findViewById<RecyclerView>(R.id.animationRecyclerView)
      recyclerview.layoutManager= GridLayoutManager(this,2)
       // val data = mutableListOf<Data>()
        getData()
    }
    private fun getData(){
     RetrofitInstance.apiInterface.getData(Constants.GIPHY_API_KEY,15).enqueue(object : Callback<GifData> {
         override fun onResponse(call: Call<GifData>, response: Response<GifData>) {
             if (response.isSuccessful && response.body()!!.data != null) {
                 Log.v("xyzz",(response.body()?.data?.size?:0).toString())
                 Log.v("xyzz",(response.body()?.data?.firstOrNull())?.id?:"null id")
                 data.addAll(response.body()!!.data)
                 rvAdapter = this@MainActivity?.let { AdapterClass(data) }
                 recyclerView.adapter =rvAdapter
                 rvAdapter!!.notifyDataSetChanged()
                 }

             else{
                 Toast.makeText(this@MainActivity,"Failure",Toast.LENGTH_SHORT).show()
             }
         }
         override fun onFailure(call: Call<GifData>, t: Throwable) {
             Toast.makeText(this@MainActivity,"failure attempt",Toast.LENGTH_SHORT).show()
         }
     })
 }

    }

