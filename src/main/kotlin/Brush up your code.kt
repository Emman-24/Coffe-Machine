enum class Drinks(val water: Int, val milk: Int, val beans: Int, val price: Int) {
    ESPRESSO( 250, 0, 16, 4),
    LATTE( 350, 75, 20, 7),
    CAPPUCCINO( 200, 100, 12, 6),

}

class CoffeeMachine(
    private var water: Int,
    private var milk: Int ,
    private var beans: Int ,
    private var cups: Int ,
    private var cash: Int
) {


    fun remaining() {
        println(
            """
    The coffee machine has:
    $water ml of water
    $milk ml of milk
    $beans g of coffee beans
    $cups disposable cups
    $${cash} of money
    """.trimIndent()
        )
    }

    fun chooseAction(): String {
        println("Write action (buy, fill, take, remaining, exit): ")
        return readln()
    }

    fun fill() {
        println("Write how many ml of water you want to add: ")
        water += readln().toInt()
        println("Write how many ml of milk you want to add: ")
        milk += readln().toInt()
        println("Write how many grams of coffee you want to add: ")
        beans += readln().toInt()
        println("Write how many disposable cups you want to add: ")
        cups += readln().toInt()
    }

    fun take() {
        println("I gave you $$cash")
        cash = 0
    }

    fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
        when (readln()) {
            "1" -> prepare(Drinks.ESPRESSO)
            "2" -> prepare(Drinks.LATTE)
            "3" -> prepare(Drinks.CAPPUCCINO)
        }
    }

    fun prepare(drink: Drinks) {
        if (isThereEnoughQuantityOf(drink)) {
            cash += drink.price
            water -= drink.water
            milk -= drink.milk
            beans -= drink.beans
            cups--
        }
    }

    fun isThereEnoughQuantityOf(drink: Drinks): Boolean {
        var enoughQuantity = false
        if (water - drink.water <= 0) {
            println("Sorry, not enough water!")
        } else if (milk - drink.milk <= 0) {
            println("Sorry, not enough milk!")
        } else if (beans - drink.beans <= 0) {
            println("Sorry, not enough beans!")
        } else {
            enoughQuantity = true
            println("I have enough resources, making you a coffee!")
        }
        return enoughQuantity

    }

    fun menu(){
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
}



fun main() {
    CoffeeMachine(400,540,120,9,550).menu()
}