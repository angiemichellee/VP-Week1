package com.example.soal2

class Enemy (
    var type: String = "",
    var HP: Int = 0,
    var maxHP: Int = 0
) {
    fun randomEnemy() {
        val types = listOf("Fire", "Water", "Grass")
        type = types.random()
        maxHP = (20..60).random()
        HP = maxHP
    }
}
