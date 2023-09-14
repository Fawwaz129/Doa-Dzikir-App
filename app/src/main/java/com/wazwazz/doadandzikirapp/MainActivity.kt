package com.wazwazz.doadandzikirapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.card.MaterialCardView
import com.wazwazz.doadandzikirapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    private var dotSliderIndicator = arrayOf<ImageView?>()

    private val slidingCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            Toast.makeText(this@MainActivity, "Page $position", Toast.LENGTH_SHORT).show()
            for (i in initData().indices) {
                dotSliderIndicator[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.inactive_dot)
                )
            }
            dotSliderIndicator[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.active_dot)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        installSplashScreen()
        initView()

        setupViewPager()
        // declare variable to get in touch with view in layout activity_main
        // use findViewId to communicate with the view

    }

    private fun setupViewPager() {
        dotSliderIndicator = arrayOfNulls(initData().size)

        for (i in initData().indices){
            dotSliderIndicator[i] = ImageView(this)
            dotSliderIndicator[i]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.inactive_dot)
            )
            val params = LinearLayoutCompat.LayoutParams(35, 35)
            params.apply {
                marginStart = 8
                marginEnd = 8
            }
            binding.dots.addView(dotSliderIndicator[i], params)
        }
    }

    private fun initView() {
        // setContentView() is use to choose and display layout in activity
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cardQauliyahSholat = findViewById<MaterialCardView>(R.id.card_qauliyah_sholat)
        val cardDzikir = findViewById<MaterialCardView>(R.id.card_dzikir)
        val cardDzikirHarian = findViewById<MaterialCardView>(R.id.card_dzikir_harian)
        val cardDzikirPagiPetang = findViewById<MaterialCardView>(R.id.card_pagi_petang)
        // when cardview clicked it will navigate to other page
        // Intent is use for navigate to other activity by clicking cardview
        cardQauliyahSholat.setOnClickListener {
            // Intent(argument context, activity you want to go)
            val intent = Intent(this, QauliyahShalatActivity::class.java)
            // start to go to destination activity
            startActivity(intent)
        }

        cardDzikir.setOnClickListener(this)
        cardDzikirHarian.setOnClickListener(this)
        cardDzikirPagiPetang.setOnClickListener(this)

        val mAdapter = ArticleAdapter()
        mAdapter.setData(initData())
        binding.vpArticle.adapter = mAdapter
        binding.vpArticle.registerOnPageChangeCallback(slidingCallback)
    }

    private fun initData() : List<ArticleItem> {
        val titleArtikel = resources.getStringArray(R.array.arr_title_artikel)
        val imageArtikel = resources.obtainTypedArray(R.array.arr_img_artikel)
        val contentArtikel = resources.getStringArray(R.array.arr_desc_artikel)

        val listData = arrayListOf<ArticleItem>()
        for (i in titleArtikel.indices) {
            val data = ArticleItem(
                titleArtikel[i],
                imageArtikel.getResourceId(i, 0),
                contentArtikel[i]
            )
            listData.add(data)
        }
        imageArtikel.recycle()
        return listData
    }

    override fun onClick(view: View?) {
        when(view?. id) {
            R.id.card_dzikir -> startActivity(Intent(this, DzikirSetiapSaatActivity::class.java))
            R.id.card_dzikir_harian -> startActivity(Intent(this, DzikirDoaHarianActivity::class.java))
            R.id.card_pagi_petang -> startActivity(Intent(this, PagiPetangActivity::class.java))
        }
    }
}