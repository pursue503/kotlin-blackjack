package blackjack

import blackjack.controller.Controller

fun main() {
    val controller = Controller()

    val gamePlayUsers = controller.gameStart()

    gamePlayUsers.fetchPlayer().forEach { controller.playing(it) }
    gamePlayUsers.fetchDealer()?.let { controller.dealerHits(it) }

    controller.gameEnd(gamePlayUsers)
}
