package com.zharfan.learnfeature.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zharfan.learnfeature.data.api.ApiConfig
import com.zharfan.learnfeature.data.response.Response
import com.zharfan.learnfeature.data.response.ResponseItem
import retrofit2.Call
import retrofit2.Callback

class RetrofitViewModel(application: Application):AndroidViewModel(application) {

    private val user = MutableLiveData<List<ResponseItem>>()
    private val TAG = RetrofitViewModel::class.java.simpleName

    fun setListUsers(){
        ApiConfig.getApiService().getResponse()
            .enqueue(object : Callback<List<ResponseItem>>{
                override fun onResponse(
                    call: Call<List<ResponseItem>>,
                    response: retrofit2.Response<List<ResponseItem>>
                ) {
                    if (response.isSuccessful){
                        user.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<List<ResponseItem>>, t: Throwable) {
                    Log.e(TAG, "onFailure: ${t.message}" )
                }
            })
    }

    fun getListUsers():LiveData<List<ResponseItem>>{
        return user
    }
}