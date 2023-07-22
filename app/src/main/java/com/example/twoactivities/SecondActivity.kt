package com.example.twoactivities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.twoactivities.Utils.Utils.extraMessage
import com.example.twoactivities.Utils.Utils.extraReply
import com.example.twoactivities.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        with(binding) {
            setContentView(root)
            messageTextView.text = intent.getStringExtra(extraMessage)
            buttonSecond.setOnClickListener() {
                returnReply()
            }
        }
    }

    private fun returnReply() {
        var replyIntent = intent
        var reply = binding.editTextSecond.text.toString()
        replyIntent.putExtra(extraReply, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
