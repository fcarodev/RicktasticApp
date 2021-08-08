package com.portfolio.rickantasticapp.ui.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.portfolio.rickantasticapp.databinding.ActivityMainBinding
import com.portfolio.rickantasticapp.extension.load
import com.portfolio.rickantasticapp.ui.viewmodel.CharacterViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val characterViewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewContainer.setOnClickListener {
            characterViewModel.randomCharacter((1..100).random())
        }

        characterViewModel.onCreate()

        characterViewModel.characterModel.observe(this, Observer { character ->
            binding.name.text = character.name
            binding.avatar.load(character.image!!)
        })
    }
}


