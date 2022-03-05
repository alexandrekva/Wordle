package com.example.wordle.feature_game.data.local

class WordsHardCodedData : WordsDAO {
    private val wordsList = mutableListOf(
        "doido", "horda", "carma", "linda", "marco", "jovem", "inata", "xeque", "capaz", "fonte",
        "relva", "ajuda", "tenra", "algum", "anuir", "velar", "ficar", "noite", "apoio", "dorso",
        "vimos", "rigor", "verso", "botar", "vazio", "tanto", "prece", "cruel", "morar", "terra",
        "ambas", "frase", "peste"
    )

    override suspend fun getRandomWord(): String {
            val randomWordPosition = wordsList.indices.random()
            return wordsList[randomWordPosition]
    }
}