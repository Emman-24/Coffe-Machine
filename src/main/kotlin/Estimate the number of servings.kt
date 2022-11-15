const val water = 200
const val milk = 50
const val coffeBeans = 15

fun main() {

    println("Write how many ml of water the coffee machine has:")
    var waterUser = readLine()?.toInt()
    println("Write how many ml of milk the coffee machine has:")
    var milkUser = readLine()?.toInt()
    println("Write how many grams of coffee beans the coffee machine has:")
    var coffeBeansUser = readLine()?.toInt()
    println("Write how many cups of coffee you will need:")
    val userCups = readLine()?.toInt()

    var cupsCoffe = 0

    if (waterUser != null && milkUser != null && coffeBeansUser != null) {
        while (waterUser >= water && milkUser >= milk && coffeBeansUser >= coffeBeans){
            waterUser -= water
            milkUser -= milk
            coffeBeansUser -= coffeBeans
            cupsCoffe++
        }

    }
    if (userCups != null) {
        if(userCups == cupsCoffe) println("Yes, I can make that amount of coffee ")
        if (userCups > cupsCoffe) println("No, I can make only $cupsCoffe cups of coffee")
        if(userCups < cupsCoffe) println("Yes, I can make that amount of coffee (and even ${cupsCoffe - userCups} more than that)")
    }


}