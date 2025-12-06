package contracts

/**
 * Базовая пиццерия
 * @param neapolitanPizzaPrice цена неаполитанской пиццы
 * @param romanPizzaPrice цена римской пиццы
 * @param sicilianPizzaPrice цена сицилианской пиццы
 * @param tyroleanPizzaPrice цена тирольской пиццы
 */
abstract class PizzaCity(
    private val neapolitanPizzaPrice: Double,
    private val romanPizzaPrice: Double,
    private val sicilianPizzaPrice: Double,
    private val tyroleanPizzaPrice: Double
) {
    var customerCount = 0
    var neapolitanPizzaCount = 0
    var romanPizzaCount = 0
    var sicilianPizzaCount = 0
    var tyroleanPizzaCount = 0
    var additionalPrice = 0.0

    open fun neapolitanPizzaSale() {
        customerCount++
        neapolitanPizzaCount++
    }
    open fun romanPizzaSale() {
        customerCount++
        romanPizzaCount++
    }
    open fun sicilianPizzaSale() {
        customerCount++
        sicilianPizzaCount
    }
    open fun tyroleanPizzaSale() {
        customerCount++
        tyroleanPizzaCount++
    }

    fun showStatistics() {
        println("Продано сицилийскокй пиццы: $sicilianPizzaCount")
        println("Продано неаполитанской пиццы: $neapolitanPizzaCount")
        println("Продано римской пиццы: $romanPizzaCount")
        println("Продано тирольской пиццы: $tyroleanPizzaCount")

        when(this) {
            is Drink -> {
                println("Продано напитков $drinkCount")
                println("Соотношение людей, которых покупают напитков к тем, которые отказываются:" +
                        " ${(drinkCount.toDouble() / customerCount.toDouble()) * 100}%")
            }
            is CheckPhoto -> {
                println("Показано чеков $checkCount")
                println("Соотношение людей, которых показывают фотографию чека к тем, которые не показывают:" +
                        " ${(checkCount.toDouble() / customerCount.toDouble()) * 100}%")
            }
        }

        val money = neapolitanPizzaPrice * neapolitanPizzaCount +
                sicilianPizzaPrice * sicilianPizzaCount +
                romanPizzaPrice * romanPizzaCount +
                tyroleanPizzaPrice * tyroleanPizzaCount + additionalPrice

        println("Всего заработано денег: $money")
    }
}