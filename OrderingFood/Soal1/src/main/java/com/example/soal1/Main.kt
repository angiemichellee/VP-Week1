package com.example.soal1

class Main {

    val MenuList: ArrayList<menu> = ArrayList<menu>()
    val OrderList: ArrayList<Order> = ArrayList<Order>()
    var inpName= ""

    init{
        val data = DummyData()

        MenuList.add(data.m1)
        MenuList.add(data.m2)
        MenuList.add(data.m3)
        MenuList.add(data.m4)
        MenuList.add(data.m5)
    }

    fun start() {
        println("ORDER SYSTEM")
        println("1. Make Order")
        println("2. View Orders")
        println("3. View Menu")
        println("4. Add Menu")
        println("5. Edit Menu")
        println("6. Delete Menu")
        println("7. Exit")
        print("Choose: ")
        val inp = readLine()!!.toInt()

        if (inp == 1) {
            MakeOrder()
        } else if (inp == 2) {
            viewOrders()
        } else if (inp == 3) {
            viewMenu()
        } else if (inp == 4) {
            addMenu()
        } else if (inp == 5) {
            editMenu()
        } else if (inp == 6) {
            deleteMenu()
        } else if (inp == 7) {
            exit()
        } else {
            println("Incorrect Number")
        }
    }

    fun viewListMenu() {
        println("Menu List")
        println()
        var no: Int = 1
        for (Menu: menu in MenuList) {
            println("$no. ${Menu.name}")
            println("Description: ${Menu.description}")
            println("price: ${Menu.price}")
            no++
        }
        println()
    }

    fun MakeOrder() {
        print("Name: ")
        val newOrder= Order(inpName)
        inpName = readLine()!!
        val name = Order(inpName)
        println()
        do {
            viewListMenu()
            print("Select: ")
            val inp = readLine()!!.toInt()
            print("Qty: ")
            val qty = readLine()!!.toInt()
            println("Order done")
            print("Add more menu (y/n)? ")
            val inp1 = readLine()!!
            val selectedMenu = MenuList[inp - 1]
            val item = OrderItem(selectedMenu, qty)
            newOrder.items.add(item)
        }while(inp1.equals("y"))
        OrderList.add(newOrder)
        println()
        start()
    }

    fun viewOrders() {
        for (OList: Order in OrderList) {
            OList.viewOrder()
            println()
        }
        start()
    }

    fun viewMenu() {
        viewListMenu()
        start()
    }

    fun addMenu() {
        print("Menu's Name: ")
        val name = readLine()!!
        print("Price: ")
        val price = readLine()!!.toInt()
        print("Description: ")
        val des = readLine()!!
        val id = MenuList.size
        val newMenu = menu(id, name, des, price)
        MenuList.add(newMenu)
        println("Menu added")
        start()
    }

    fun editMenu() {
            println("Edit Menu")
            viewListMenu()
            print("Secelt: ")
            val inp = readLine()!!.toInt()
            println()
            println("1. Menu's Name")
            println("2. Menu's Description")
            println("3. Menu's Price")
            print("Choose:")
            val choose = readLine()!!.toInt()
            if (choose == 1) {
                print("Enter New Name: ")
                val inp1 = readLine()!!
                MenuList[inp-1].name = inp1
                start()
            } else if (choose == 2) {
                print("Enter New Description: ")
                val inp2 = readLine()!!
                MenuList[inp-1].description = inp2
                start()
            } else if (choose == 3) {
                print("Enter New price: ")
                val inp3 = readLine()!!.toInt()
                MenuList[inp - 1].price = inp3
                start()
            } else {
                println("Enter Invalid")
                start()
            }
    }

    fun deleteMenu() {
        do {
            println("Delete Menu")
            viewListMenu()
            print("select: ")
            val inp = readLine()!!.toInt()
            val selectedMenu = MenuList[inp-1]
            MenuList.removeAt(inp-1)
            println("Menu deleted")
            print("delete another menu (y/n)? ")
            val inpp= readLine()!!
        } while(inpp == "y")
        start()
    }

    fun exit() {
        println("Thank You")
    }
}