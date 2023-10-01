package com.example.welcome.ui.viewpager

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

internal class RecyclerViewAdapter(
	private val slides: Array<Slide>
) : RecyclerView.Adapter<SlideViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SlideViewHolder.from(parent)

	override fun onBindViewHolder(holder: SlideViewHolder, position: Int) = holder.bind(slides[position])

	override fun getItemCount() = slides.size
}