package com.example.registerforactivity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.registerforactivity.MainActivity.Companion.masaEditText
import com.example.registerforactivity.MainActivity.Companion.samaEditText
import com.example.registerforactivity.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            secondEt.setText(intent.getStringExtra(masaEditText))
            returnBtn.setOnClickListener {
                val text = secondEt.text.toString().trim()
                if (text.isNotEmpty()){
                    val intent = Intent()
                    intent.putExtra(samaEditText, text)
                    setResult(RESULT_OK, intent)
                    finish()
                }
            }
        }
    }
}