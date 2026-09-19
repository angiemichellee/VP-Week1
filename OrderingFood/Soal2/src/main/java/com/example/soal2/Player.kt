package com.example.soal2

class Player (
    var name: String = "",
    var hp: Int = 50,
    var maxHp: Int = 50,
    var mana: Int = 30,
    var maxMana: Int = 30,
    var manaPotion: Int = 5,
    var healthPotion: Int = 5,
    var kill: Int = 0,
    var needKill: Int = 0,
    var lifesteal: Int = 0,
    var isStrong: Boolean = false,
) {
    fun healthPotionUse(){
        if (healthPotion>0){
            hp += 25
            healthPotion -=1
            if (hp>maxHp){
                hp= maxHp
            }
            println("Your current HP is $hp")
        } else {
            println("Not enough potion!")
        }
    }

    fun manaPotionUse(){
        if (manaPotion>0){
            mana += 15
            manaPotion -=1
            if (mana>maxMana){
                mana= maxMana
            }
            println("Your current HP is $mana")
        } else {
            println("Not enough potion!")
        }
    }

    fun strong(){
        if (!isStrong) {
            isStrong = true

            maxHp = (maxHp * 1.5).toInt()
            hp = maxHp
            maxMana = (maxMana * 1.5).toInt()
            mana = maxMana

            lifesteal += 1
            kill = 0

            println()
            println("NOW YOU ARE A STRONG WIZARD!")
            println("Lifesteal increased! Current lifesteal is $lifesteal")
        }
    }

    fun useLifesteal() {
        if (isStrong && lifesteal > 0) {
            hp += lifesteal
            if (hp > maxHp) {
                hp = maxHp
            }
            println("Lifesteal triggered! Healed $lifesteal HP")
        }
    }
}
