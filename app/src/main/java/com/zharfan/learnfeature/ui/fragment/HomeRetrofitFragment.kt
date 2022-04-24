package com.zharfan.learnfeature.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.zharfan.learnfeature.databinding.FragmentHomeRetrofitBinding
import com.zharfan.learnfeature.ui.adapter.ListRetrofitAdapter
import com.zharfan.learnfeature.ui.viewmodel.RetrofitViewModel


class HomeRetrofitFragment : Fragment() {

   private var _binding: FragmentHomeRetrofitBinding? = null
   private val binding get() = _binding!!

    private lateinit var viewModel: RetrofitViewModel
    private lateinit var listRetrofitAdapter: ListRetrofitAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeRetrofitBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        showListUser()
    }

    private fun showListUser() {
        binding.apply {
            viewModel.apply {
                setListUsers()
                getListUsers().observe(viewLifecycleOwner) {
                    if (it != null) {
                        listRetrofitAdapter = ListRetrofitAdapter { item ->
                            Toast.makeText(requireContext(), item.email, Toast.LENGTH_SHORT).show()
                        }
                        with(rvListUserRetrofit){
                            layoutManager = LinearLayoutManager(context)
                            adapter = listRetrofitAdapter
                        }
                        listRetrofitAdapter.setListUsers(it)
                    }
                }
            }
        }
    }


    private fun initViewModel() {
        viewModel = ViewModelProvider(requireActivity())[RetrofitViewModel::class.java]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}