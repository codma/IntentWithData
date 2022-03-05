package com.simmariazi.intentwithdata

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.simmariazi.intentwithdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        val REQUEST = 0
        val ID = "ID"
        val PASSWD = "PASSWD"
        val RESULT = "RESULT"
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode != REQUEST) return
        data?.getStringExtra(RESULT).let {
            binding.txtMessage.text = it
        }
        super.onActivityResult(requestCode, resultCode, data)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.edtId.setOnFocusChangeListener(){
            v, hasFocus ->
            val edt = v as EditText
            val color = if(hasFocus){
                Color.TRANSPARENT
        }else{
            Color.LTGRAY
        }
            edt.setBackgroundColor(color)
        }
        binding.edtPassWD.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.txtMessage.text = s
            }
        })

        binding.btnLogin.setOnClickListener{
            val i = Intent(this, ResultActivity::class.java)
            i.putExtra(ID, binding.edtId.text.toString())
            i.putExtra(PASSWD, binding.edtPassWD.text.toString())
            startActivityForResult(i, REQUEST)
        }
    }
}