package ru.stas.mylab

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.stas.mylab.databinding.ItemCarouselBinding

class CarouselRVAdapter(private val carouselDataList: List<CarouselItem>):RecyclerView.Adapter<CarouselRVAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemCarouselBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(carouselItem: CarouselItem) {
                binding.textview.text = carouselItem.toString()
            }
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCarouselBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(carouselDataList[position % carouselDataList.size])
    }

    override fun getItemCount() = carouselDataList.size
}
