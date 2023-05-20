package com.example.tp_room_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.tp_room_fragments.fragments.AgendaUsuarios
import com.example.tp_room_fragments.fragments.AgregarUsuario
import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity() {

    lateinit var navigation: NavigationBarView
    private val mOnNavMenu = NavigationBarView.OnItemSelectedListener { item ->
        when (item.itemId) {
            R.id.agregarUsuario -> {
                supportFragmentManager.commit {
                    replace<AgregarUsuario>(R.id.frameContainer)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnItemSelectedListener true
            }
            R.id.agenda -> {
                supportFragmentManager.commit {
                    replace<AgendaUsuarios>(R.id.frameContainer)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnItemSelectedListener true
            }
        }

        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation = findViewById(R.id.navMenu)
        navigation.setOnItemSelectedListener(mOnNavMenu)

        supportFragmentManager.commit {
            replace<AgregarUsuario>(R.id.frameContainer)
            setReorderingAllowed(true)
            addToBackStack("replacement")
        }
    }
}