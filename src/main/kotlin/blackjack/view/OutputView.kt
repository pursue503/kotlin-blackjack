package blackjack.view

import blackjack.domain.entity.Gamer

object OutputView {

    private const val SET_PLAY_MESSAGE = "에게 2장의 카드를 나누었습니다."
    private const val CARD = "카드"
    private const val RESULT = "결과"

    fun printSettingPlayer(players: List<Gamer>) {
        println("$players $SET_PLAY_MESSAGE")
        println()
        players.forEach { println("${it.name} $CARD : ${it.cards}") }
    }

    fun printPlayCard(player: Gamer) {
        println("${player.name} $CARD : ${player.cards}")
    }

    fun gameEnd(players: List<Gamer>) {
        players.forEach { println("${it.name} $CARD: ${it.cards} - $RESULT: ${it.scoreCalculation()}") }
    }
}
