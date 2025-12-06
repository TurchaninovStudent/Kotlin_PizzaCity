import contracts.CheckPhoto
import contracts.Drink
import contracts.PizzaCity
import models.PizzaCityMoscow
import models.PizzaCityPeter
import kotlin.system.exitProcess

fun main() {
    val pizzaPeter = PizzaCityPeter(
        175.0, 241.5,
        167.5, 215.0
    )

    val pizzaMoscow = PizzaCityMoscow(
        215.0, 250.0,
        180.5, 240.0
    )
    while (true) {
        println("Добрый день! Выберите город")
        println("1. Москва \n2. Санкт-Петербург \n3. Выход из программы")

        val currentPizzaCity: PizzaCity = when (readln()) {
            "1" -> pizzaMoscow
            "2" -> pizzaPeter
            "3" -> break
            else -> {
                println("Неправильный ввод данных")
                continue
            }
        }

        println("Выберите пиццу:")
        println("1. Неполитанская пицца \n2. Римская пицца \n3. Сицилийская пицца \n4. Тирольская пицца \n0. Показать статистику")

        selectPizza(currentPizzaCity)
    }
}

fun selectAddditionalService(currentPizzaCity: PizzaCity) {
    when (currentPizzaCity) {
        is CheckPhoto -> currentPizzaCity.showCheckPhoto()
        is Drink -> currentPizzaCity.drinkSale()
    }
}

fun selectPizza(currentPizzaCity: PizzaCity) {
    val choice = readln()

    when (choice) {
        "1" -> currentPizzaCity.neapolitanPizzaSale()
        "2" -> currentPizzaCity.romanPizzaSale()
        "3" -> currentPizzaCity.sicilianPizzaSale()
        "4" -> currentPizzaCity.tyroleanPizzaSale()
        "0" -> currentPizzaCity.showStatistics()
        else -> {
            println("Неправильный ввод данных")
            exitProcess(1)
        }
    }
    if (choice != "0") {
        selectAddditionalService(currentPizzaCity)
    }
}