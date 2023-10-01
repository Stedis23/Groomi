package com.example.welcome.ui.viewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.welcome.databinding.SlideBinding

internal class SlideViewHolder(
	private val binding: SlideBinding
) : RecyclerView.ViewHolder(binding.root) {

	companion object {
		fun from(parent: ViewGroup): SlideViewHolder {
			val inflater = LayoutInflater.from(parent.context)
			val binding = SlideBinding.inflate(inflater, parent, false)
			return SlideViewHolder(binding)
		}
	}

	fun bind(slide: Slide) {
		with(binding) {
			image.setImageResource(slide.image)
			title.setText(slide.title)
			description.setText(slide.description)
		}
	}
}