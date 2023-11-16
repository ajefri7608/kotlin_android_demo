package com.example.kotlinandroiddemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinandroiddemo.model.User
import com.example.kotlinandroiddemo.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

    val user: MutableLiveData<User> by lazy {
        MutableLiveData<User>()
    }
//    val nameObserver = Observer<String> { newName ->
//        // Update the UI, in this case, a TextView.
//        nameTextView.text = newName
//    }
//
//    // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
//    repository..observe(this, nameObserver)

}