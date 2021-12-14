package blackjack.domain.entity

class Dealer(
    override val cards: MutableList<Card>
) : Gamer {

    override val name: String = "딜러"

    override fun hits(card: Card) {
        cards.add(card)
    }

    override fun toString(): String {
        return name
    }
}
