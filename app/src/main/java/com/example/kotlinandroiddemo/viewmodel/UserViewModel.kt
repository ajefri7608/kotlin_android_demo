package com.example.kotlinandroiddemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinandroiddemo.model.User
import com.example.kotlinandroiddemo.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {

    val user: MutableLiveData<User> = repository.userInfo

    fun login(userName: String, password: String) = viewModelScope.launch {
        repository.getUser(userName, password)
    }
//    val nameObserver = Observer<String> { newName ->
//        // Update the UI, in this case, a TextView.
//        nameTextView.text = newName
//    }
//
//    // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
//    repository..observe(this, nameObserver)

}