package com.example.wordle.feature_game.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WordsRepository {
    private val wordsList = mutableListOf(
        "doido", "horda", "carma", "linda", "marco", "jovem", "inata", "xeque", "capaz", "fonte",
        "relva", "ajuda", "tenra", "algum", "anuir", "velar", "ficar", "noite", "apoio", "dorso",
        "vimos", "rigor", "verso", "botar", "vazio", "tanto", "prece", "cruel", "morar", "terra",
        "ambas", "frase", "peste"
    )

    fun getRandomWord(): Flow<String?> = flow {
        if (wordsList.size > 0) {
            val randomWordPosition = wordsList.indices.random()
            emit(wordsList.removeAt(randomWordPosition))
        } else {
            emit(null)
        }
    }
}