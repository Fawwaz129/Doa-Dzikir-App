package com.wazwazz.doadandzikirapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class PagiPetangActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagi_petang)

        val btnPagi: ImageButton = findViewById(R.id.img_btn_dzikir_pagi)
        val btnPetang: ImageButton = findViewById(R.id.img_btn_petang)

        btnPagi.setOnClickListener(this)
        btnPetang.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.img_btn_dzikir_pagi -> startActivity(Intent(this, PagiActivity::class.java))
            R.id.img_btn_petang -> startActivity(Intent(this, PetangActivity::class.java))
        }
    }

}