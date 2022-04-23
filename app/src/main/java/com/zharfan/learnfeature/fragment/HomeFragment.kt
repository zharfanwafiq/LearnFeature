package com.zharfan.learnfeature.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.zharfan.learnfeature.R
import com.zharfan.learnfeature.adapter.ListFeatureAdapter
import com.zharfan.learnfeature.data.ListFeature
import com.zharfan.learnfeature.data.ListFeatureData
import com.zharfan.learnfeature.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var listFeatureAdapter: ListFeatureAdapter
    private var listFeature : ArrayList<ListFeature> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater,container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        showListFeature()
//        showToolbar()
    }

//    private fun showToolbar() {
//        binding.apply {
//            searchView.apply {
//                setSearchableInfo(searchManager.getSearchableInfo(componentName))
//                queryHint = "Masukan Kata"
//                setOnQueryTextListener(object: SearchView.OnQueryTextListener{
//                    override fun onQueryTextSubmit(query: String?): Boolean {
//                        return true
//                    }
//
//                    override fun onQueryTextChange(newText: String?): Boolean {
//
//                        return false
//                    }
//                })
//            }
//            return true
//        }
//    }

//    private fun showListFeature() {
//        listFeature.clear()
//        listFeature.addAll(ListFeatureData.listData)
//        listFeatureAdapter = ListFeatureAdapter(listFeature)
//        binding.apply {
//            with(rvListFeature){
//                layoutManager = LinearLayoutManager(requireActivity())
//                adapter = listFeatureAdapter
//            }
//        }
//
//    }
//



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}