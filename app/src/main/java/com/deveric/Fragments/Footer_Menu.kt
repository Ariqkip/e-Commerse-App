package com.deveric.esales.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.deveric.esales.Cart
import com.deveric.esales.Products_Home
import com.deveric.esales.R

class Footer_Menu : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.footer__menu, container, false)
        var footer_menu_home: ImageView = view.findViewById(R.id.footer_menu_home)
        var footer_menu_cart: ImageView = view.findViewById(R.id.footer_menu_cart)
        var footer_menu_account: ImageView = view.findViewById(R.id.footer_menu_account)

        footer_menu_home.setOnClickListener(View.OnClickListener {
            val intent = Intent(getActivity(), Products_Home::class.java)
            getActivity()?.startActivity(intent)
        })
        footer_menu_cart.setOnClickListener(View.OnClickListener {
            val intent = Intent(getActivity(), Cart::class.java)
            getActivity()?.startActivity(intent)
        })

        return view
    }
}