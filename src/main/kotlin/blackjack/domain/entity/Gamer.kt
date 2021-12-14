package blackjack.domain.entity

import blackjack.domain.entity.enums.Denomination

interface Gamer {

    val name: String
    val cards: MutableList<Card>

    fun hits(card: Card)

    fun scoreCalculation(): Int {

        var score = this
            .cards
            .sumOf { it.denomination.cardNumber }

        if (score > BLACK_JACK) {
            val aceCount = this
                .cards
                .count { it.denomination == Denomination.ACE }

            score = score - (Denomination.ACE.cardNumber * aceCount) + (1 * aceCount)
        }

        return score
    }

    companion object {
        private const val BLACK_JACK = 21
    }
}
