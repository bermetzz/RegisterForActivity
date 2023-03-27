package com.example.registerforactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.registerforactivity.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    companion object {
        const val masaEditText = "bzz"
        const val samaEditText = "bz"
    }

    private lateinit var binding: ActivityMainBinding
    private val activityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            val text = result.data!!.getStringExtra(samaEditText)
            binding.firstEt.setText(text)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            submitBtn.setOnClickListener {
                val text = firstEt.text.toString().trim()
                if (text.isEmpty()) {
                    Toast.makeText(
                        applicationContext,
                        getString(R.string.toast),
                        Toast.LENGTH_SHORT
                    )
                        .show()
                } else {
                    val intent = Intent(this@MainActivity, MainActivity2::class.java)
                    intent.putExtra(masaEditText, text)
                    activityLauncher.launch(intent)
                }
            }
        }
    }
}