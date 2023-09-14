package com.wazwazz.doadandzikirapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.wazwazz.doadandzikirapp.databinding.ActivityDzikirSetiapSaatBinding

class DzikirSetiapSaatActivity : AppCompatActivity() {
    private var _binding: ActivityDzikirSetiapSaatBinding? = null
    private val binding get() = _binding as ActivityDzikirSetiapSaatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDzikirSetiapSaatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mAdapter = DoaDzikirAdapter(DataDoaDzikir.listDzikir())
        mAdapter.setData(DataDoaDzikir.listDzikir())
        binding.rvDzikir.adapter = mAdapter
        binding.rvDzikir.layoutManager = LinearLayoutManager(this)
    }

}