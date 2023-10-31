package com.example.pizzarestaurant

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val frameLayout = findViewById<FrameLayout>(R.id.fragment_container)
        val seeMenusBtn = findViewById<Button>(R.id.seeMenusBtn)
        val recyclerView = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recyclerView)

        seeMenusBtn.setOnClickListener {
            frameLayout.visibility = View.VISIBLE
            frameLayout.setBackgroundColor(Color.parseColor("#FFFFFF"))
            recyclerView.setBackgroundColor(Color.parseColor("#FFFFFF"))
            recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)

            val fabOrder = findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.fabOrder)
            fabOrder.setOnClickListener{
                val intent = Intent(this, MenuDetails::class.java)
                startActivity(intent)
            }

            val data = ArrayList<MenuCardView>(
                listOf(
                    MenuCardView(R.drawable._pepperoni, "Papperoni Pizza", "Cocok bagi anda yang ingin merasakan pizza original dengan taburan keju dan daging asap yang lezat"),
                    MenuCardView(R.drawable._spaghetti, "Spaghetti", "Cocok bagi anda yang ingin merasakan spaghetti original dengan bumbu yang oriental"),
                    MenuCardView(R.drawable._burger, "Burger", "Cocok bagi anda yang ingin merasakan kelembutan burger berlapiskan keju, sayuran dan daging yang tebal"),
                    MenuCardView(R.drawable._steak, "Steak", "Cocok bagi anda yang ingin merasakan lezatnya daging steak dipadukan dengan kentang yang lezat"),
                )
            )


            val adapter = AdapterRecyclerView(data)

            recyclerView.adapter = adapter
        }
    }
}