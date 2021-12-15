package blackjack.view

import blackjack.domain.entity.Gamer

object OutputView {

    private const val SET_PLAY_MESSAGE = "에게 2장의 카드를 나누었습니다."
    private const val CARD = "카드"
    private const val RESULT = "결과"
    private const val GAME_END_MESSAGE = "## 최종 승패"
    private const val DEALER_DRAW_MESSAGE = "딜러는 16 이하라 카드를 한장 더받았습니다"

    fun printSettingPlayer(players: List<Gamer>) {
        println("$players $SET_PLAY_MESSAGE")
        println()
        players.forEach { println("${it.name} $CARD : ${it.cards}") }
    }

    fun printPlayCard(player: Gamer) {
        println("${player.name} $CARD : ${player.cards}")
    }

    fun dealerDrawMessage() {
        println(DEALER_DRAW_MESSAGE)
    }

    fun gameEnd(players: List<Gamer>) {
        players.forEach { println("${it.name} $CARD: ${it.cards} - $RESULT: ${it.scoreCalculation()}") }
        println(GAME_END_MESSAGE)
    }
}
