package com.portfolio.rickantasticapp.ui.view.character.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.portfolio.rickantasticapp.R
import com.portfolio.rickantasticapp.data.model.character.CharacterModel
import com.portfolio.rickantasticapp.extension.load
import kotlinx.android.synthetic.main.item_row_character.view.*

class CharacterAdapter(
    val itemClickListener: OnItemClickListener

) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    private lateinit var listCharacter: MutableList<CharacterModel>

    fun setCharacterList(characterLst: MutableList<CharacterModel>) {
        listCharacter = characterLst
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            0 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_row_character_placeholder, parent, false)
                CharacterPlaceholder(view)
            }

            1 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_row_character_empty, parent, false)
                CharacterEmpty(view)
            }
            2 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_row_character, parent, false)
                CharacterData(view)
            }
            else -> throw IllegalArgumentException("error view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        val characterModel: CharacterModel = listCharacter[position]
        return when (characterModel.id) {
            -1 -> 0
            -2 -> 1
            else -> 2
        }

    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is CharacterPlaceholder -> holder.bind()
            is CharacterEmpty -> holder.bind()
            is CharacterData -> holder.bind(listCharacter[position], itemClickListener)
        }
    }

    override fun getItemCount(): Int {
        return listCharacter.size
    }

    inner class CharacterPlaceholder(itemView: View) : BaseViewHolder<Any>(itemView) {
        override fun bind() {
            super.bind()
        }
    }

    inner class CharacterEmpty(itemView: View) : BaseViewHolder<Any>(itemView) {
        override fun bind() {
            super.bind()
        }
    }

    inner class CharacterData(itemView: View) : BaseViewHolder<CharacterModel>(itemView) {
        override fun bind(item: CharacterModel, itemClickListener: OnItemClickListener) {
            super.bind(item, itemClickListener)
            itemView.characterImage.load(item.image!!)
            itemView.characterName.text = item.name
            itemView.characterGender.text = item.gender
            itemView.characterSpecie.text = item.species
            itemView.characterStatus.text = item.status

        }
    }

}

interface OnItemClickListener {
    fun onCharacterClickListener(character: CharacterModel)
}