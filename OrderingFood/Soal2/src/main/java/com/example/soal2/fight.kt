package com.example.soal2

class fight (
    var player: Player,
    var enemy: Enemy,
    var wDamage: Int = 10,
    var eDamage: Int = 10,
    var noHP: Boolean = false,
    var noMana: Boolean = false,
    var noEnemy: Boolean = false,
    var isEvolve: Boolean = false
) {
    fun fireAttack(enemy: Enemy, wizard: Player) {
        wHP()
        if (!noHP) {
            mana()
            if (!noMana) {
                if (enemy.type == "Grass") {
                    val damage = wDamage * 2
                    wizard.mana -= 10
                    enemy.HP -= damage
                    eHP()
                    println("${enemy.type} Mon takes $damage damages")

                    wizard.useLifesteal()
                    enemyDead()
                } else {
                    wizard.mana -= 10
                    enemy.HP -= wDamage
                    eHP()
                    println("${enemy.type} Mon takes $wDamage damages")

                    wizard.useLifesteal()
                    enemyDead()
                }
            }
        }
    }

    fun waterAttack(enemy: Enemy, wizard: Player) {
        wHP()
        if (!noHP) {
            mana()
            if (!noMana) {
                if (enemy.type == "Fire") {
                    val damage = wDamage * 2
                    wizard.mana -= 10
                    enemy.HP -= damage
                    eHP()
                    println("${enemy.type} Mon takes $damage damages")

                    wizard.useLifesteal()
                    enemyDead()
                } else {
                    wizard.mana -= 10
                    enemy.HP -= wDamage
                    eHP()
                    println("${enemy.type} Mon takes $wDamage damages")

                    wizard.useLifesteal()
                    enemyDead()
                }
            }
        }
    }

    fun grassAttack(enemy: Enemy, wizard: Player) {
        wHP()
        if (!noHP) {
            mana()
            if (!noMana) {
                if (enemy.type == "Water") {
                    val damage = wDamage * 2
                    wizard.mana -= 10
                    enemy.HP -= damage
                    eHP()
                    println("${enemy.type} Mon takes $damage damages")

                    wizard.useLifesteal()
                    enemyDead()
                } else {
                    wizard.mana -= 10
                    enemy.HP -= wDamage
                    eHP()
                    println("${enemy.type} Mon takes $wDamage damages")

                    wizard.useLifesteal()
                    enemyDead()
                }
            }
        }
    }

    fun wHP(): Boolean {
        if (player.hp <= 0) {
            noHP = true
            println("HP depleted, you're dead")
            return false
        }
        noHP = false
        return true
    }

    fun eHP() {
        if (enemy.HP < 0) {
            enemy.HP = 0
        }
    }

    fun mana(): Boolean {
        if (player.mana < 10) {
            noMana = true
            println("Mana depleted, you can drink a potion")
            return false
        }
        noMana = false
        return true
    }

    fun enemyDead() {
        if (enemy.HP > 0) {
            player.hp -= eDamage
            println("${player.name} takes $eDamage damages")
            wHP()
        } else if (enemy.HP <= 0) {
            noEnemy = true
            println("${enemy.type} Mon is down!")
            player.kill++
            evolve()
            println("A new monster encountered!")
            enemy.randomEnemy()
        }
    }

    fun evolve() {
        if (player.kill >= player.needKill && !player.isStrong) {
            isEvolve = true
            player.strong()
            wDamage = (wDamage * 1.5).toInt()
        } else if (player.isStrong) {
            player.lifesteal++
            println("Lifesteal increased! Current lifesteal ${player.lifesteal}")
        }
    }
}
