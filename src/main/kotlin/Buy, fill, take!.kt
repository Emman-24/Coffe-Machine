const val WATER = 400
const val MIlK = 540
const val COFFE_BEANS = 120
const val CUPS  = 9
const val MONEY = 550

fun main() {

    println("""The coffee machine has:
$WATER ml of water
$MIlK ml of milk
$COFFE_BEANS g of coffee beans
$CUPS disposable cups
$MONEY of money""".trimIndent())

    println("")
    println("Write Action(buy,fill,take)")

    when(readLine().toString()){
        "buy" -> buyMachine()
        "fill"-> fillMachine()
        "take"-> takeMachine()
    }

}

fun buyMachine() {
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
    when(readLine()?.toInt()){
        1 -> espresso()
        2 -> latte()
        3 -> cappuccino()
    }
}

fun takeMachine() {
    println("I gave you $$MONEY")
    machineResult(moneyUser = MONEY- MONEY)
}

fun fillMachine() {
    println("Write how many ml of water you want to add:")
    var wateUser = readln().toInt()
    wateUser += WATER
    println("Write how many ml of milk you want to add:")
    var milkUser = readln().toInt()
    milkUser+= MIlK
    println("Write how many grams of coffee beans you want to add:")
    var coffeBeansUser = readln().toInt()
    coffeBeansUser+= COFFE_BEANS
    println("Write how many disposable cups you want to add: ")
    var cupsUser = readln().toInt()
    cupsUser+= CUPS

    machineResult(wateUser,milkUser,coffeBeansUser,cupsUser)

}

fun machineResult(wateUser: Int = WATER, milkUser: Int = MIlK, coffeBeansUser: Int = COFFE_BEANS, cupsUser: Int = CUPS,moneyUser: Int = MONEY) {

    println("""
    The coffee machine has:
    $wateUser ml of water
    $milkUser ml of milk
    $coffeBeansUser g of coffee beans
    $cupsUser disposable cups
    $$moneyUser of money""".trimIndent())

}

fun cappuccino() {

    var waterCappuccino = 200
    var milkCappuccino = 100
    var coffeBeansCappuccino = 12
    var priceCappuccino = 6
    var cupsCappuccino = 1

    waterCappuccino = WATER - waterCappuccino
    milkCappuccino = MIlK - milkCappuccino
    coffeBeansCappuccino = COFFE_BEANS - coffeBeansCappuccino
    cupsCappuccino = CUPS - cupsCappuccino

    priceCappuccino += MONEY

    machineResult(wateUser = waterCappuccino, milkUser = milkCappuccino, coffeBeansUser = coffeBeansCappuccino, cupsUser = cupsCappuccino, moneyUser = priceCappuccino)

}

fun latte() {

    var waterLatte = 350
    var milkLatte = 75
    var coffeBeansLatter = 20
    var priceLatte = 7
    var cupsLatte = 1

    waterLatte = WATER - waterLatte
    milkLatte = MIlK - milkLatte
    coffeBeansLatter = COFFE_BEANS - coffeBeansLatter
    cupsLatte = CUPS - cupsLatte

    priceLatte += MONEY

    machineResult(wateUser = waterLatte, milkUser = milkLatte, coffeBeansUser = coffeBeansLatter, cupsUser = cupsLatte, moneyUser = priceLatte)


}

fun espresso() {

    var waterEspresso = 250
    var coffeBeansEspresso = 16
    var priceEspresso = 4
    var cupsEspresso = 1

    waterEspresso = WATER - waterEspresso
    coffeBeansEspresso = COFFE_BEANS - coffeBeansEspresso
    cupsEspresso = CUPS - cupsEspresso

    priceEspresso += MONEY

    machineResult(wateUser = waterEspresso, coffeBeansUser = coffeBeansEspresso, cupsUser = cupsEspresso, moneyUser = priceEspresso)


}