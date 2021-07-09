package com.ua

import io.github.butkoprojects.bots.api.annotation.BotController
import io.github.butkoprojects.bots.api.annotation.KeyBoardButton
import io.github.butkoprojects.bots.api.annotation.KeyBoardRow
import io.github.butkoprojects.bots.api.annotation.MessageRequest
import org.telegram.telegrambots.meta.api.objects.Update

@BotController
class Controller {

    @MessageRequest( "/hui" )
    @KeyBoardRow([@KeyBoardButton("button1"), @KeyBoardButton("button1")])
    @KeyBoardRow([@KeyBoardButton("button2"), @KeyBoardButton("button2")])
    @KeyBoardRow([@KeyBoardButton("button3"), @KeyBoardButton("button3")])
    String hui( Update update ) {
        "hhuuuuiii"
    }
}
