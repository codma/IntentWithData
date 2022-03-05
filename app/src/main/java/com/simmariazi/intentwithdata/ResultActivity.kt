package com.simmariazi.intentwithdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.simmariazi.intentwithdata.databinding.ActivityMainBinding
import com.simmariazi.intentwithdata.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onStart(){
        super.onStart()

        var i = intent ?:return
        val sID = i.getStringExtra(MainActivity.ID)
        val sPassdw = i.getStringExtra(MainActivity.PASSWD)
        binding.txtMessage.text = "아이디: ${sID} \n 패스워드: ${sPassdw}"
        i.putExtra(MainActivity.RESULT, binding.txtMessage.text.toString())
        setResult(MainActivity.REQUEST, i)

    }
}