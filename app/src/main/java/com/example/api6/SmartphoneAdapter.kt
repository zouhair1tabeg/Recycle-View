package com.example.api6

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class SmartphoneAdapter(private val smartphoneList: List<Smartphone>) :
    RecyclerView.Adapter<SmartphoneAdapter.SmartphoneViewHolder>() {

    class SmartphoneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.img)
        val nameTextView: TextView = itemView.findViewById(R.id.name)
        val prixTextView: TextView = itemView.findViewById(R.id.prix) // Ensure this ID matches the XML
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmartphoneViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return SmartphoneViewHolder(view)
    }

    override fun onBindViewHolder(holder: SmartphoneViewHolder, position: Int) {
        val smartphone = smartphoneList[position]
        holder.nameTextView.text = smartphone.nom

        // Format the price to display
        holder.prixTextView.text = formatPrice(smartphone.prix)

        // Load the image using Picasso
        Picasso.get().load(smartphone.image).into(holder.imageView)
    }

    private fun formatPrice(prix: Double): String {
        return String.format("%.2f Dh", prix) // Format the price to two decimal places
    }

    override fun getItemCount(): Int {
        return smartphoneList.size
    }
}
