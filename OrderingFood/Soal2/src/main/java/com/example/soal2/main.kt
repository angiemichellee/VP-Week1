package com.example.soal2

class Main() {

    fun Start() {
        print("What's your name? ")
        val name = readLine()!!
        val player = Player(name)
        println()
        if (name.isEmpty()) {
            println("Please Enter Your Name")
            Start()
        } else {
            println("Good luck ${player.name}! You're gonna need it!")
            menu(player)
        }
    }

    fun menu(player: Player){
        do {
            println()
            println("What’re you going to do?")
            println("1. View Stats")
            println("2. Enter battle")
            print("Select: ")
            val select = readLine()!!.toInt()
            println()

            if (select == 1) {

            } else if (select == 2) {

            }
        }while (true)
    }

    fun viewStats(player: Player){
        do {
            println("${player.name} STATS")
            println("HP                    : ${player.hp}/${player.maxHp}")
            println("Mana                  : ${player.mana}/${player.maxMana}")
            println("Kills need to evolve  : ${player.kill}/${player.needKill}")
            println("Health Potion Held    : ${player.healthPotion}")
            println("Mana Potion Held      : ${player.manaPotion}")

            println()
            println("a. Drink Mana Potion")
            println("b. Drink Health Potion")
            println("c. Rename Self")
            println("d. Back")
            print("Choose: ")
            val choose = readLine()!!

            if (choose == "a") {
                player.manaPotionUse()
            } else if (choose == "b") {
                player.healthPotionUse()
            } else if (choose == "c") {
                print("What's your name? ")
                val name = readLine()!!
                if (name.isEmpty()){
                    println("Name can't be empty")
                } else {
                    player.name = name
                    println("Name updated to ${name}")
                }
            } else if (choose == "d"){
                menu(player)
            } else {
                println("Invalid choice")
            }
        } while (true)
    }

    fun battle(player: Player) {
        val enemy = Enemy()
        enemy.randomEnemy()
        val battle = fight(player, enemy, 10, 10)

        do {
            if (player.hp <= 0) {
                println("YOU'RE DEAD! Restarting...")
                main()
            }

            println()
            println("BATTLE ")
            println(player.name)
            println("HP                    : ${player.hp}/${player.maxHp}")
            println("Mana                  : ${player.mana}/${player.maxMana}")
            println("Kills need to evolve  : ${player.kill}/${player.needKill}")
            println("Health Potion Held    : ${player.healthPotion}")
            println("Mana Potion Held      : ${player.manaPotion}")

            println("\n${enemy.type} MON")
            println("HP       : ${enemy.HP}/${enemy.maxHP}")
            println("Type     : ${enemy.type}")
            println("---------------------------------")
            println("1. Fire Attack")
            println("2. Water Attack")
            println("3. Grass Attack")
            println("4. Drink Potion")
            println("5. Run")
            print("Choose: ")
            val choose = readLine()!!

            if (choose == "1") {
                battle.fireAttack(enemy, player)

            } else if (choose == "2") {
                battle.waterAttack(enemy, player)

            } else if (choose == "3") {
                battle.grassAttack(enemy, player)

            } else if (choose == "4") {
                println("\n1. Health Potion")
                println("2. Mana Potion")
                print("Choose: ")
                val choose = readLine()!!
                if (choose == "1" && player.healthPotion > 0) {
                    player.healthPotionUse()
                } else if (choose == "1" && player.healthPotion <= 0) {
                    println("You don't have Health Potion")
                } else if (choose == "2" && player.manaPotion > 0) {
                    player.manaPotionUse()
                } else if (choose == "2" && player.manaPotion <= 0) {
                    println("You don't have enough Mana Potion")
                }

            } else if (choose == "5") {
                println("You run from ${enemy.type} Mon")
                println("Another monster encountered!")
                enemy.randomEnemy()

            } else {
                println("Invalid choice")
            }
        } while (true)
    }
}