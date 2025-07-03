package com.example.kotlinbootcampday

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kotlinbootcampday1.R

class MainActivity : AppCompatActivity() {
    var str:String? = null
    lateinit var info:String//Daha sonra bu değişkene değere atayacapım demektir.
    //lateinit sadece var ile kullanılır , val kullanılmaz
    var x:Int = 0
    var y:Double = 0.0
    var kontrol:Boolean= false //bunlarla lateinit kullanılmaz
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}