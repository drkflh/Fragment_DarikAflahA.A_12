package com.fragment_darikaflahaa_12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.fragment_darikaflahaa_12.AplikasiFragment.BerandaFragment
import com.fragment_darikaflahaa_12.AplikasiFragment.NotifikasiFragment
import com.fragment_darikaflahaa_12.AplikasiFragment.PengaturanFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val berandaFragment = BerandaFragment()
        val notifikasiFragment = NotifikasiFragment()
        val pengaturanFragment = PengaturanFragment()

        makeCurrentFragment (berandaFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_beranda -> makeCurrentFragment(berandaFragment)
                R.id.menu_notifikasi -> makeCurrentFragment(notifikasiFragment)
                R.id.menu_pengaturan -> makeCurrentFragment(pengaturanFragment)
            }

            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framenavigation, fragment)
            commit()
        }
    }
}