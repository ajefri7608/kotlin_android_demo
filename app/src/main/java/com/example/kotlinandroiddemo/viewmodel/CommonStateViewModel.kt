package com.example.kotlinandroiddemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinandroiddemo.model.BottomSheetState
import com.example.kotlinandroiddemo.model.GeneralException
import com.example.kotlinandroiddemo.model.User

class CommonStateViewModel : ViewModel() {
    private val _loadingState = MutableLiveData<Boolean>()
    val loadingState: LiveData<Boolean> get() = _loadingState;
    private val _errorState = MutableLiveData<GeneralException>()
    val errorState: LiveData<GeneralException> get() = _errorState;

    val _bottomSheetSate = MutableLiveData<BottomSheetState>();
    val bottomSheetSate: LiveData<BottomSheetState> get() = _bottomSheetSate;


    fun setLoading(isLoading: Boolean) {
        _loadingState.postValue(isLoading)
    }

    fun setErrorState(error: GeneralException) {
        _errorState.postValue(error)
    }

    fun setBottomSheetState(bottomSheetState: BottomSheetState) {
        val test = BottomSheetState()
        _bottomSheetSate.postValue(bottomSheetState)

    }


}