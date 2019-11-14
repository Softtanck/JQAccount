package com.openkotlin.jqacoount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.openkotlin.jqacoount.viewmodels.UserViewModel
import com.openkotlin.jqacoount.viewmodels.UserViewModel2

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // If we want to the parameters, This line should be added factor.
        ViewModelProviders.of(this@MainActivity).get(UserViewModel::class.java)
        ViewModelProviders.of(this@MainActivity).get(UserViewModel2::class.java)
    }
}
