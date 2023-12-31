package com.ssoaharison.memorygame.models

enum class BoardSize(val numCards: Int) {
    EASY(8),
    MEDIUM(18),
    HARD(24);

    companion object {
        fun getByValue(value: Int) = values().first {it.numCards == value}
    }

    fun getWidth(): Int {
        return when (this) {
            EASY -> 2
            MEDIUM -> 3
            HARD -> 4
        }
    }

    fun getHeight() = numCards / getWidth()

    fun getNumPairs() = numCards / 2
}