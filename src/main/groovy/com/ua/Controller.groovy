package com.ua

import com.ua.custom.TestAnnotation
import io.github.butkoprojects.bots.preprocess.annotation.BotController
import io.github.butkoprojects.bots.preprocess.annotation.CallbackButton
import io.github.butkoprojects.bots.preprocess.annotation.CallbackRequest
import io.github.butkoprojects.bots.preprocess.annotation.KeyBoardButton
import io.github.butkoprojects.bots.preprocess.annotation.MessageRequest
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

@BotController
class Controller {

    @MessageRequest( '/test1' )
    SendMessage test1(final Update update ) {
        return SendMessage.builder()
                .chatId(String.valueOf(update.getMessage().getChatId()))
                .text("tests ability to use 'raw' SendMessage logic")
                .build();
    }

    @MessageRequest( '/test2' )
    String test2( final Update update ) {
        return 'tests ability to return String';
    }

    @MessageRequest( '/test3' )
    String test3() {
        return 'tests ability to have empty params for method';
    }

    @MessageRequest( '/test4' )
    @KeyBoardButton( 'test4' )
    SendMessage test4( final Update update ) {
        return SendMessage.builder()
                .chatId(String.valueOf(update.getMessage().getChatId()))
                .text("tests ability to use 'raw' SendMessage logic with keyboard annotation")
                .build();
    }

    @MessageRequest( '/test5' )
    @KeyBoardButton( 'test5' )
    String test5() {
        return 'tests ability to add keyboard and return string';
    }

    @MessageRequest( '/test6' )
    @CallbackButton( call = 'test7', name = 'test7' )
    @CallbackButton( call = 'test8', name = 'test8' )
    @CallbackButton( call = 'test9', name = 'test9' )
    @CallbackButton( call = 'test10', name = 'test10' )
    String test6() {
        return 'tests callback buttons';
    }

    @CallbackRequest( 'test7' )
    String test7() {
        return 'tests ability to answer callback';
    }

    @CallbackRequest( 'test8' )
    @CallbackButton( call = 'test7', name = 'test7edited' )
    @CallbackButton( call = 'test8', name = 'test8edited' )
    @CallbackButton( call = 'test9', name = 'test9edited' )
    @CallbackButton( call = 'test10', name = 'test10edited' )
    String test8() {
        return 'ability to edit callback keyboard';
    }

    @CallbackRequest( 'test9' )
    @CallbackButton( call = 'test7', name = '$test7' )
    @CallbackButton( call = 'test8', name = '$test8' )
    @CallbackButton( call = 'test9', name = '$test9' )
    @CallbackButton( call = 'test10', name = '$test10' )
    String test9( Map<String, String> params ) {
        params.put( 'test7', 'TEST7' );
        params.put( 'test8', 'TEST8' );
        params.put( 'test9', 'TEST9' );
        params.put( 'test10', 'TEST10' );
        return 'test ability to put params into callback buttons';
    }

    @CallbackRequest( 'test10' )
    @CallbackButton( call = 'test9', name = '$msg' )
    void test10( Map<String, String> params ) {
        params.put( 'msg', 'void method' );
    }

    @MessageRequest( '/test11' )
    @TestAnnotation( textToSend = 'tests custom annotation' )
    void test11() {}
}
