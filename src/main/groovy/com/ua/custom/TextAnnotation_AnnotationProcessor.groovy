package com.ua.custom

import io.github.butkoprojects.bots.preprocess.controller.builder.ControllerBuilder
import io.github.butkoprojects.bots.preprocess.factory.annotation.AnnotationProcessor
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.methods.BotApiMethod
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import java.util.function.Function

@Component
class TextAnnotation_AnnotationProcessor implements AnnotationProcessor<TestAnnotation> {

    @Override
    Class<TestAnnotation> getAnnotationClass() {
        TestAnnotation
    }

    @Override
    void process( TestAnnotation annotation, ControllerBuilder builder ) {
        builder.setProcessFunction( new Function<Update, List<BotApiMethod>>() {
            @Override
            List<BotApiMethod> apply( Update update ) {
                [SendMessage.builder()
                         .chatId(update.getMessage().getChatId().toString())
                         .text(annotation.textToSend())
                         .build()]
            }
        })
    }
}
