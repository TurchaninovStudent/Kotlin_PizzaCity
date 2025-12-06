package contracts

/**
 * Фотография чека
 */
interface CheckPhoto {
    /**
     * Предложить сфотографировать чек
     */
    fun showCheckPhoto()

    /**
     * Количество чеков
     */
    var checkCount: Int

    /**
     * Скидка от чеков
     */
    var checkSale: Double
}