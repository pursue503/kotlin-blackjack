package blackjack.domain.entity

class Dealer(
    override val cards: MutableList<Card>
) : Gamer {

    override val name: String = "딜러"

    override fun hits(callback: () -> Card) {
        cards.add(callback())
    }

    override fun isHits(): Boolean {
        return scoreCalculation() <= DEALER_HITS_SCORE
    }

    override fun toString(): String {
        return name
    }

    companion object {
        private const val DEALER_HITS_SCORE = 16
    }
}
