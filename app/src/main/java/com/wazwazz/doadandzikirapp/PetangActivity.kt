package com.wazwazz.doadandzikirapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.wazwazz.doadandzikirapp.databinding.ActivityPetangBinding

class PetangActivity : AppCompatActivity() {
    private var _binding: ActivityPetangBinding? = null
    private val binding get() = _binding as ActivityPetangBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPetangBinding.inflate(layoutInflater)
        title = resources.getString(R.string.dzikir_petang)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(binding.root)

        binding.rvDzikirPetang.apply {
            val mAdapter = DoaDzikirAdapter(DataDoaDzikir.listDzikir())
            mAdapter.setData(DataDoaDzikir.PetangActivity)
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@PetangActivity)
        }


    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}