package com.example.twoactivities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.twoactivities.Utils.Utils.extraMessage
import com.example.twoactivities.Utils.Utils.extraReply
import com.example.twoactivities.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val resultLauncher = registerForActivityResult(StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.getStringExtra(extraReply).let { reply ->
                with(binding) {
                    titleTextView.isVisible = true
                    replyTextView.text = reply
                    replyTextView.isVisible = true
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mainButton.setOnClickListener(){
            launchSecondActivity()
        }
    }

    private fun launchSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        val message = binding.mainEditText.text.toString()
        intent.putExtra(extraMessage, message)
        resultLauncher.launch(intent)
    }
}