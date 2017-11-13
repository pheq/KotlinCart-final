package com.example.pierre.kotlincart_final

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //ETAPE 1
        val articles = arrayOf(Article(3, "Harry Potter", Type.Livre), Article(4, "Lucky luke", Type.Livre), Article(10, "Star Wars", Type.Dvd),
                Article(6,"Le seigneur des anneaux", Type.Dvd),
                Article(7,"Pulp Fiction", Type.Dvd),
                Article(18, "Dictionnaire Larousse", Type.Livre))

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ///ETAPE 2
        val lv = findViewById(R.id.listView) as ListView
         val adapter = BasicAdapter(this,articles)
         lv.adapter = adapter

        //ETAPE 3
        //Extension function
        fun Article.appliquerReduction(s: Int){
            this.prix-= s;
        }
         val button = findViewById(R.id.btnfilter) as Button
        button.setOnClickListener( {
            for (article in articles){
                when (article.prix) {
                    in 5..50 -> article.appliquerReduction(5)
                }
            }
            adapter.notifyDataSetChanged()
        })


        //ETAPE 4
        lv.onItemClickListener = AdapterView.OnItemClickListener{ parent, view, i, l ->
            val intent = Intent(this, ProfilActivity::class.java)
            intent.putExtra("prix", articles.get(i).prix)
            intent.putExtra("name", articles.get(i).name)
            intent.putExtra("type", articles.get(i).type.toString())
            startActivity(intent)
        }
    }

    private class BasicAdapter(val myContext: Context, val articles: Array<Article>) : BaseAdapter() {

        override fun getCount(): Int {
            return articles.size
        }

        override fun getItem(i: Int): Any? {
            return articles[i]
        }

        override fun getItemId(i: Int): Long {
            return i.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
            val view = TextView(myContext)
            val mInflator = LayoutInflater.from(myContext)

            val row = mInflator.inflate(R.layout.row, parent, false)
            val nameTextView = row.findViewById<TextView>(R.id.textView_name)
            nameTextView.text = articles.get(position).name

            val prixTextView = row.findViewById<TextView>(R.id.textView_prix)
            prixTextView.text = "Prix : ${articles.get(position).prix.toString()} €"

            return row
        }


    }
}