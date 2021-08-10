package com.portfolio.rickantasticapp.ui.view.character.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    open fun bind(item: T, itemClickListener: OnItemClickListener){}
    open fun bind(){}
}