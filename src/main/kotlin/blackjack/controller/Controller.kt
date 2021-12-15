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
        while (InputView.hitsOrStay(player.name) && player.isHits()) { // y card < 21
            player.hits(cardDeck::draw)
            OutputView.printPlayCard(player)
        }
    }

    fun dealerHits(dealer: Gamer) {
        while (dealer.isHits()) {
            dealer.hits(cardDeck::draw)
            OutputView.dealerDrawMessage()
        }
    }

    fun gameEnd(gamePlayUsers: GamePlayUsers) {
        OutputView.gameEnd(gamePlayUsers.playGamers)
    }
}
