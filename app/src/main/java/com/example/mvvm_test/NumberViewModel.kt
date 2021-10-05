package com.example.mvvm_test

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class ActionType{
    PLUS,MINUS
}

class NumberViewModel : ViewModel() {
    private val _CurrentValue = MutableLiveData<Int>()

    val CurrentValue : LiveData<Int>
        get() = _CurrentValue
    //초기값 설정
    init {
        Log.d("로그","생성자 호출")
        _CurrentValue.value = 0
    }

    fun UpdateValue(actionType: ActionType,Value : Int){
        when(actionType){
            ActionType.PLUS ->
                _CurrentValue.value = _CurrentValue.value?.plus(Value)
            ActionType.MINUS ->
                _CurrentValue.value = _CurrentValue.value?.minus(Value)
        }
    }
}