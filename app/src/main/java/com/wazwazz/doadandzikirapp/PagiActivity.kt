package com.wazwazz.doadandzikirapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.wazwazz.doadandzikirapp.databinding.ActivityPagiBinding

class PagiActivity : AppCompatActivity() {
    private var _binding: ActivityPagiBinding? = null
    private val binding get() = _binding as ActivityPagiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = resources.getString(R.string.dzikir_pagi)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityPagiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDzikirPagi.apply {
            val mAdapter = DoaDzikirAdapter(DataDoaDzikir.listDzikir())
            mAdapter.setData(DataDoaDzikir.PagiActivity)
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@PagiActivity)
        }


    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}