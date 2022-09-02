package com.example.architecturepatterns

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.architecturepatterns.mvc.MvcMainActivity
import com.example.architecturepatterns.mvp.MvpMainActivity
import com.example.architecturepatterns.mvvm.MvvmMainActivity
import com.google.android.material.button.MaterialButton

class HomeActivity : AppCompatActivity(){
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<MaterialButton>(R.id.btn_mvc).setOnClickListener {
            startActivity(Intent(this,MvcMainActivity::class.java))
        }

        findViewById<MaterialButton>(R.id.btn_mvp).setOnClickListener {
            startActivity(Intent(this,MvpMainActivity::class.java))
        }

        findViewById<MaterialButton>(R.id.btn_mvvm).setOnClickListener {
            startActivity(Intent(this,MvvmMainActivity::class.java))
        }

    }


}