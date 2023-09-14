package com.wazwazz.doadandzikirapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.wazwazz.doadandzikirapp.databinding.ActivityDzikirDoaHarianBinding

class DzikirDoaHarianActivity : AppCompatActivity() {
    private var _binding: ActivityDzikirDoaHarianBinding? = null
    private val binding get() = _binding as ActivityDzikirDoaHarianBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityDzikirDoaHarianBinding.inflate(layoutInflater)
        setContentView(binding.root)

        providingDzikirDatas()
        initView()
    }

    private fun initView() {
        binding.rvDzikirHarian.apply {
            val mAdapter = DoaDzikirAdapter(DataDoaDzikir.listDzikir())
            mAdapter.setData(providingDzikirDatas())
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@DzikirDoaHarianActivity)
        }
    }

    private fun providingDzikirDatas(): List<DoaDzikir> {
        val titleDzikir = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val arabicDzikir = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val translateDzikir = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        val listData = arrayListOf<DoaDzikir>()
        for (i in titleDzikir.indices) {
            val data = DoaDzikir(
                titleDzikir[i],
                arabicDzikir[i],
                translateDzikir[i]
            )
            listData.add(data)
        }
        return listData
    }
}