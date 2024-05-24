package com.example.clase11

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var menu: TabLayout
    private lateinit var visor: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menu = findViewById(R.id.tabMenu)
        visor = findViewById(R.id.vpVisor)

        val viewpagerAdapter  = ControladorMenu(this)
        visor.adapter = viewpagerAdapter

        TabLayoutMediator(menu, visor) { tab, position ->
            tab.text = when (position) {
                0 -> "Principal"
                1 -> "Galeria"
                2 -> "Contactanos"
                else -> null
            }
            tab.icon = when (position) {
                0 -> getDrawable(R.drawable.baseline_account_balance_24)
                1 -> getDrawable(R.drawable.baseline_add_photo_alternate_24)
                2 -> getDrawable(R.drawable.baseline_email_24)
                else -> null
            }
        }.attach()
    }
}