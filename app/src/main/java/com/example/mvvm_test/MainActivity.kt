package com.example.mvvm_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var MynumberviewModel: NumberViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) 

        MynumberviewModel = ViewModelProvider(this).get(NumberViewModel::class.java)

        MynumberviewModel.CurrentValue.observe(
            this, Observer {
                Log.d("로그","값 변경")
                Current_number.text=it.toString()
            }
        )
        Btn_plus.setOnClickListener(this)
        Btn_minus.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var input = User_input.text.toString().toInt()
        when(v){
            Btn_plus -> MynumberviewModel.UpdateValue(ActionType.PLUS,input)
            Btn_minus -> MynumberviewModel.UpdateValue(ActionType.MINUS,input)
        }

    }
}