package com.wazwazz.doadandzikirapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.wazwazz.doadandzikirapp.DataDoaDzikir.listQauliyah
import com.wazwazz.doadandzikirapp.databinding.ActivityQauliyahShalatBinding

class QauliyahShalatActivity : AppCompatActivity() {
    // implement viewBinding feature
    // viewBinding is a feature that makes to write code that interacts with views
    // viewBinding comes to replace findViewById

    private var _binding:ActivityQauliyahShalatBinding? = null
    private val binding get() = _binding as ActivityQauliyahShalatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // initialize property of _binding with  layoutinFlater to get layout
        _binding = ActivityQauliyahShalatBinding.inflate(layoutInflater)
        // replace argument of setContentView using view binding
        // this is for connect the view
        setContentView(binding.root)

        // set recyclerView
        val mAdapter = DoaDzikirAdapter(DataDoaDzikir.listDzikir())
        mAdapter.setData(listQauliyah)
        binding.rvQauliyaShalat.adapter = mAdapter
        // layoutManager is a class to set our structure of recyclerView to display dataset
        binding.rvQauliyaShalat.layoutManager = LinearLayoutManager(this)
    }
}