package com.wazwazz.doadandzikirapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wazwazz.doadandzikirapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    var _binding : ActivityDetailBinding? = null
    val binding get() = _binding as ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataTitle = intent.getStringExtra("Title")
        val dataImage = intent.getIntExtra("Image", 0)
        val dataContent = intent.getStringExtra("Content")


        binding.apply {
            detailTittle.text = dataTitle
            detailImage.setImageResource(dataImage)
            detailContent.text = dataContent

        }

    }
}