package ru.stas.mylab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.stas.mylab.databinding.ListItemBinding

class CryptocurrencyAdapter(private val cryptocurrency: List<Cryptocurrency>):RecyclerView.Adapter<CryptocurrencyAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(index: Cryptocurrency){
            Glide.with(binding.root)
                .load(index.image)
                .into(binding.image)
            binding.cryptocurrency.text = index.name.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cryptocurrency[position])
    }

    override fun getItemCount() = cryptocurrency.size
}