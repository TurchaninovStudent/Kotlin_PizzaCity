package contracts

/**
 * Напиток
 */
interface Drink {
    /**
     * Продажа напитков
     */
    fun drinkSale()

    /**
     * Количество напитков
     */
    var drinkCount: Int

    /**
     * Цена напитков
     */
    var drinkPrice: Double
}