package com.portfolio.rickantasticapp.ui.view.character

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.orhanobut.logger.Logger
import com.portfolio.rickantasticapp.data.model.character.CharacterModel
import com.portfolio.rickantasticapp.databinding.ActivityCharacterBinding
import com.portfolio.rickantasticapp.ui.view.character.adapter.CharacterAdapter
import com.portfolio.rickantasticapp.ui.view.character.adapter.OnItemClickListener
import com.portfolio.rickantasticapp.ui.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint//<- esto prepara a la clase para ser inyectada
class CharacterActivity : AppCompatActivity(),OnItemClickListener {

    private lateinit var binding: ActivityCharacterBinding
    private val characterViewModel: CharacterViewModel by viewModels()
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var characterAdapter: CharacterAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val chatacterList = mutableListOf<CharacterModel>()
        chatacterList.add(CharacterModel())
        layoutManager = LinearLayoutManager(this)
        binding.recyclerCharacter.layoutManager = layoutManager
        characterAdapter = CharacterAdapter(this)
        characterAdapter.setCharacterList(chatacterList)
        binding.recyclerCharacter.adapter = characterAdapter
        characterViewModel.onCreate()


        characterViewModel.listCharacterModel.observe(this, Observer { characterList->
            Logger.d(Gson().toJson(characterList[1]))
            characterAdapter.setCharacterList(characterList)
            characterAdapter.notifyDataSetChanged()
            binding.recyclerCharacter.adapter = characterAdapter

        })
    }

    override fun onCharacterClickListener(character: CharacterModel) {

    }
}


