package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    var isText:Boolean = false
    var moreoneoperator:Boolean = false
    var dott:Boolean = false
    var rez = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
    }

    fun botton(view: View){

        if( binding.textView.text.contains("/0") ||
            binding.textView.text.contains("+0") ||
            binding.textView.text.contains("-0") ||
            binding.textView.text.contains("*0")) {
            binding.textView.text=binding.textView.text.dropLast(1)
        }

        if( binding.textView.text.toString().equals("0") ){
            binding.textView.setText("")
            isText = false
            moreoneoperator = false
        }

        val text = view as Button

        if(dott && text.text.equals(".") ){
            return
        }

        if(text.text.equals(".")){
            dott = true
        }
        if(rez){
            return
        }

        binding.textView.append(text.text)
        isText = true
    }

    fun elements(view:View){
        if(isText && !moreoneoperator){
            val text = view as Button
            binding.textView.append(text.text)
            isText = false
            moreoneoperator = true
            dott = false
            rez = false
        }
    }

    fun clear(view:View){
        binding.textView.setText("")
        isText = false
        moreoneoperator = false
        dott = false
        rez = false
    }

    fun eqals(view:View){

        var aaa = binding.textView.text.toString()

        if(binding.textView.text.contains("+")){
           var index = aaa.split("+")
            var firstNumber = index[0]
            var lastNumber = index[1]
            var rez = index[0].toDouble() + index[1].toDouble()
            binding.textView.setText("${rez}")
        }

        if(binding.textView.text.contains("-")){
            var index = aaa.split("-")
            var firstNumber = index[0]
            var lastNumber = index[1]
            var rez = index[0].toDouble() - index[1].toDouble()
            binding.textView.setText("${rez}")
        }

        if(binding.textView.text.contains("/")){
            var index = aaa.split("/")
            var firstNumber = index[0]
            var lastNumber = index[1]
            var rez = index[0].toDouble() / index[1].toDouble()
            binding.textView.setText("${rez}")
        }

        if(binding.textView.text.contains("*")){
            var index = aaa.split("*")
            var firstNumber = index[0]
            var lastNumber = index[1]
            var rez = index[0].toDouble() * index[1].toDouble()
            binding.textView.setText("${rez}")
        }

        moreoneoperator = false
        dott = false
        rez = true
    }
}