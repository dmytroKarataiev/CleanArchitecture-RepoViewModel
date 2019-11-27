package com.example.viewmodelrepomemoryleak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.viewmodelrepomemoryleak.viewmodels.LiveDataMainFactory
import com.example.viewmodelrepomemoryleak.viewmodels.MainViewModel

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, NextFragment.newInstance())
                .commitNow()
        }
    }

}