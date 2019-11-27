package com.example.viewmodelrepomemoryleak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewmodelrepomemoryleak.ui.main.MainFragment
import com.example.viewmodelrepomemoryleak.ui.main.NextFragment

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
