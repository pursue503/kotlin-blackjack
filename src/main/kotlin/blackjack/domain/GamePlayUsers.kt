package blackjack.domain

import blackjack.domain.entity.Dealer
import blackjack.domain.entity.Gamer

class GamePlayUsers(
    gamers: List<Gamer>
) {

    private val _playGamers = gamers
    val playGamers get() = _playGamers.toList()

    fun fetchPlayer(): List<Gamer> = _playGamers
        .filter { it.name != "딜러" }
        .toList()

    fun fetchDealer(): Gamer? = _playGamers
        .find { it is Dealer }

    override fun toString(): String {
        return "$playGamers"
    }
}
