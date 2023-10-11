package com.csgm.cryptoprueba.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.csgm.cryptoprueba.R
import com.csgm.cryptoprueba.databinding.ItemAssetBinding
import com.csgm.cryptoprueba.model.Asset
import com.squareup.picasso.Picasso
import java.util.*

class AssetAdapter: RecyclerView.Adapter<AssetVH>() {

    private val assetList = mutableListOf<Asset>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetVH {
        val binding = ItemAssetBinding.inflate(LayoutInflater.from(parent.context))
        val rootView = binding.root
        return AssetVH(rootView)
        //return AssetVH.create(parent)
    }

    override fun getItemCount(): Int {
        return assetList.size
    }

    override fun onBindViewHolder(holder: AssetVH, position: Int) {
        holder.bind(assetList[position])
    }

    fun update (list: List<Asset>){
        assetList.clear()
        assetList.addAll(list)
        notifyDataSetChanged()
    }
}

class AssetVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(asset: Asset) {
        // Aquí puedes realizar la lógica para mostrar los datos del asset en el ViewHolder.

        val assetNameTextView = itemView.findViewById<TextView>(R.id.tvName)
        val assetPriceTextView = itemView.findViewById<TextView>(R.id.tvPrice)
        val assetImageImageView = itemView.findViewById<ImageView>(R.id.ivAssetDetail)
        R.id.tvMarketCap
        R.id.tvSymbol

        // Ahora puedes establecer los valores de las vistas con los datos del Asset
        assetNameTextView.text = asset.name
        Log.i("AssetVH",asset.name)
        assetPriceTextView.text = asset.priceUsd

        // Si tienes una imagen, puedes cargarla usando una biblioteca de imágenes como Glide o Picasso
        // Glide.with(itemView.context).load(asset.imageUrl).into(assetImageImageView)

        Picasso.get().load("https://static.coincap.io/assets/icons/${asset.symbol.lowercase(Locale.ROOT)}@2x.png").into(assetImageImageView)

    }

}