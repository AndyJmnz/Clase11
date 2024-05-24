package com.example.clase11

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ControladorMenu(fragment: Fragment): FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
       return when(position){
           0 ->  fragment_principal()
           1 -> fragment_galeria()
           2 -> fragment_formulario()
           else -> throw  IllegalArgumentException("Posicion invalida.")
       }
    }
}