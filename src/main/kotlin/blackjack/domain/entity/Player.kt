package blackjack.domain.entity

class Player(
    override val name: String,
    override val cards: MutableList<Card> = mutableListOf(),
) : Gamer {

    override fun hits(callback: () -> Card) {
        cards.add(callback())
    }

    override fun isHits(): Boolean {
        return scoreCalculation() <= BLACK_JACK_SCORE
    }

    override fun toString(): String {
        return name
    }

    companion object {
        private const val BLACK_JACK_SCORE = 21
    }
}
