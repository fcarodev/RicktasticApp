package com.portfolio.rickantasticapp.data.model.character

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterProvider @Inject constructor() {
        var characterModel = CharacterModel()
}