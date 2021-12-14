package blackjack.controller

import blackjack.domain.GamePlayUsers
import blackjack.domain.deck.CardDeck
import blackjack.domain.entity.Gamer
import blackjack.domain.setup.GameStartSetting
import blackjack.view.InputView
import blackjack.view.OutputView

class Controller(
    private val cardDeck: CardDeck = CardDeck()
) {

    fun gameStart(): GamePlayUsers {

        val players = InputView.setPlayer()

        val gamePlayUsers = GamePlayUsers(GameStartSetting.setGame(players, cardDeck))

        OutputView.printSettingPlayer(gamePlayUsers.playGamers)

        return gamePlayUsers
    }

    fun playing(player: Gamer) {
        while (InputView.hitsAndStay(player.name) && player.scoreCalculation() < BLACK_JACK_SCORE) {
            player.hits(cardDeck.draw())
            OutputView.printPlayCard(player)
        }
    }

    fun dealerHits(dealer: Gamer) {
        while (dealer.scoreCalculation() <= 16) {
            println("딜러는 16 이하라 카드를 한장 더받았습니다")
            dealer.hits(cardDeck.draw())
        }
    }

    fun gameEnd(gamePlayUsers: GamePlayUsers) {
        OutputView.gameEnd(gamePlayUsers.playGamers)
    }

    companion object {
        private const val BLACK_JACK_SCORE = 21
    }
}
