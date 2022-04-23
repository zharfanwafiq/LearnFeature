package com.zharfan.learnfeature.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.zharfan.learnfeature.R
import com.zharfan.learnfeature.adapter.ListJsonAdapter
import com.zharfan.learnfeature.databinding.FragmentListJsonBinding
import cz.msebera.android.httpclient.Header
import org.json.JSONArray

class ListJsonFragment : Fragment() {

    private var _binding : FragmentListJsonBinding? = null
    private val binding get() = _binding!!
    private lateinit var listJsonAdapter :ListJsonAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentListJsonBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initToolbar()
        showData()
    }



    private fun initToolbar() {
        listJsonAdapter = ListJsonAdapter()
        binding.apply {
            with(rvListFeature){
                layoutManager = LinearLayoutManager(requireActivity())
                setHasFixedSize(true)
                adapter = listJsonAdapter
            }
        }
    }

    private fun showData()=with(binding) {
        pbListQuote.visibility =View.VISIBLE
        val client = AsyncHttpClient()
        val url = "https://jsonplaceholder.typicode.com/users"
        client.get(url,object :AsyncHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray
            ) {
                when(statusCode){
                    200 ->{
                        pbListQuote.visibility = View.GONE

                        val result = String(responseBody)

                        val listJson = ArrayList<String>()
                        val jsonArray = JSONArray(result)

                        for (i in 0 until jsonArray.length()){
                            val jsonObject = jsonArray.getJSONObject(i)
                            val username = jsonObject.getString("username")
                            val email = jsonObject.getString("email")
                            listJson.add("\n$username\n$email\n")
                        }
                        listJsonAdapter.showListJson(listJson)
                    }
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable
            ) {
                val  errorMessage = when (statusCode){
                    400 -> String.format("%s: %s",statusCode,getString(R.string.error400))
                    401 -> String.format("%s: %s",statusCode,getString(R.string.error401))
                    403 -> String.format("%s: %s",statusCode,getString(R.string.error403))
                    404 -> String.format("%s: %s",statusCode,getString(R.string.error404))
                    500 -> String.format("%s: %s",statusCode,getString(R.string.error500))

                    else -> String.format("%s: %s",statusCode,error.message)
                }
                Toast.makeText(requireActivity(), errorMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}