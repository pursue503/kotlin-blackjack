package blackjack.domain.entity

class Player(
    override val name: String,
    override val cards: MutableList<Card> = mutableListOf(),
) : Gamer {

    override fun hits(card: Card) {
        cards.add(card)
    }

    override fun toString(): String {
        return name
    }
}
