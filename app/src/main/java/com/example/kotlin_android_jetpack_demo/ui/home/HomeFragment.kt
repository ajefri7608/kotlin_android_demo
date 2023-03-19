package com.example.kotlin_android_jetpack_demo.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_android_jetpack_demo.data.RealmProductRepository
import com.example.kotlin_android_jetpack_demo.databinding.FragmentHomeBinding
import com.example.kotlin_android_jetpack_demo.domain.ProductItem
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val productRepository = RealmProductRepository()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        CoroutineScope(Dispatchers.IO).launch {
            productRepository.getProductList().collect {
                Log.e("totalDataLength: ", "totalDataLength: ${it.list.size}")

            }
        }

            val saveLargeBtn: Button = binding.saveLargeDataButton
            saveLargeBtn.setOnClickListener {
                kotlin.runCatching {
                    CoroutineScope(Dispatchers.IO).launch {
                        for (i in 1..1000) {
                            productRepository.addProduct(
                                ProductItem()
                            )
                        }

                    }
                }
//            }.onSuccess { value ->
//                CoroutineScope(Dispatchers.IO).launch {
//                    productRepository.getProductList().collect {
//                        Log.e("totalDataLength: ", "totalDataLength: ${it.list.size}")
//
//                    }
//                }
//            }.onFailure { error -> Log.e("addDataFail", error.message ?: "addDataFail") }

            }
            return root
        }

        //    fun addTask() {
//        CoroutineScope(Dispatchers.IO).launch {
//            runCatching {
//                productRepository.addProduct(ProductItem())
//            }.onSuccess {
//                withContext(Dispatchers.Main) {
//                    _addItemEvent.emit(AddItemEvent.Info("Task '$taskSummary' added successfully."))
//                }
//            }.onFailure {
//                withContext(Dispatchers.Main) {
//                    _addItemEvent.emit(AddItemEvent.Error("There was an error while adding the task '$taskSummary'", it))
//                }
//            }
//            cleanUpAndClose()
//        }
//    }
        override fun onResume() {
            super.onResume()

        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }