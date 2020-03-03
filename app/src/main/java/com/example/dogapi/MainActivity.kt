package com.example.dogapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnBuscar.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (Network.hayRed(this)) {
            val intLista = Intent(this,ListDogs::class.java)
            intLista.putExtra("RAZA",edtRaza.text.toString())
            startActivity(intLista)
        }else{
            Toast.makeText(this, "No hay red", Toast.LENGTH_LONG).show()
        }
    }

}
