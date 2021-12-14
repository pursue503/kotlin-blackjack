package blackjack.domain.setup

import blackjack.domain.deck.CardDeck
import blackjack.domain.entity.Dealer
import blackjack.domain.entity.Gamer
import blackjack.domain.entity.Player

object GameStartSetting {

    fun setGame(playerNames: List<String>, cardDeck: CardDeck = CardDeck()): List<Gamer> {

        val gamers = mutableListOf<Gamer>()

        for (name in playerNames) {

            val cards = mutableListOf(cardDeck.draw(), cardDeck.draw())

            gamers.add(Player(name, cards))
        }

        val dealerCard = mutableListOf(cardDeck.draw(), cardDeck.draw())

        gamers.add(Dealer(dealerCard))

        return gamers
    }
}
