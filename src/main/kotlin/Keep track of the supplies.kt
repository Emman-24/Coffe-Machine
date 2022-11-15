var totalMoney = 550
var totalWater = 400
var totalMilk = 540
var totalBeans = 120
var totalCups = 9

fun main() {
    do {
        val action = chooseAction()
        when (action) {
            "buy" -> buy()
            "take" -> take()
            "fill" -> fill()
            "remaining" -> remaining()
        }
    } while (action != "exit")
}

fun remaining() {
    println(
        """
    The coffee machine has:
    $totalWater ml of water
    $totalMilk ml of milk
    $totalBeans g of coffee beans
    $totalCups disposable cups
    $${totalMoney} of money
    """.trimIndent()
    )
}

fun chooseAction(): String {
    println("Write action (buy, fill, take, remaining, exit): ")
    return readln()
}

fun fill() {
    println("Write how many ml of water you want to add: ")
    totalWater += readln().toInt()
    println("Write how many ml of milk you want to add: ")
    totalMilk += readln().toInt()
    println("Write how many grams of coffee you want to add: ")
    totalBeans += readln().toInt()
    println("Write how many disposable cups you want to add: ")
    totalCups += readln().toInt()
}

fun take() {
    println("I gave you $$totalMoney")
    totalMoney = 0
}

fun buy() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
    when (readln()) {
        "1" -> buy(250, 0, 16, 4)
        "2" -> buy(350, 75, 20, 7)
        "3" -> buy(200, 100, 12, 6)
    }
}

fun buy(water: Int, milk: Int, beans: Int, money: Int) {
    if (isThereEnoughQuantityOf(water, milk, beans)) {
        totalMoney += money
        totalWater -= water
        totalMilk -= milk
        totalBeans -= beans
        totalCups--
    }
}

fun isThereEnoughQuantityOf(water: Int, milk: Int, beans: Int): Boolean {
    var enoughQuantity = false
    if (totalWater - water <= 0) {
        println("Sorry, not enough water!")
    } else if (totalMilk - milk <= 0) {
        println("Sorry, not enough milk!")
    } else if (totalBeans - beans <= 0) {
        println("Sorry, not enough beans!")
    } else {
        enoughQuantity = true
        println("I have enough resources, making you a coffee!")
    }
    return enoughQuantity

}