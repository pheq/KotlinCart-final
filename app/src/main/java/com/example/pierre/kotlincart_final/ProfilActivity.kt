package com.example.pierre.kotlincart_final

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ProfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        val nameTextView = findViewById(R.id.profil_nom) as TextView
        val prixTextView = findViewById(R.id.profil_prix) as TextView
        val imageView = findViewById(R.id.imageView) as ImageView

        val intent = intent
        val prix = intent.getIntExtra("prix", 0).toString()
        val type = intent.getStringExtra("type")

        prixTextView.text = "${prix} €"
        nameTextView.text = intent.getStringExtra("name")
        imageView.setImageResource(getImageOfType(Type.valueOf(type)))
    }


    fun getImageOfType(type: Type): Int{
        when (type){
            Type.Livre -> return R.drawable.livres
            Type.Dvd -> return R.drawable.dvd_img
        }
        return 0;
    }


}
