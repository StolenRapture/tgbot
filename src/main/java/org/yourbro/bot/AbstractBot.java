package org.yourbro.bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.yourbro.services.botservice.BotService;

/**
 *
 */
public abstract class AbstractBot extends TelegramLongPollingBot {
    protected BotModel bot;
    protected BotService botService;

    AbstractBot(final BotModel bot, final BotService botService) {
        this.bot = bot;
        this.botService = botService;
    }

    public void sendTextMessage(String chatID, String text) throws TelegramApiException {
        final SendMessage sendMessage = new SendMessage();
        sendMessage.setText(chatID);
        sendMessage.setText(text);
        execute(sendMessage);
    }

    @Override
    public String getBotToken() {
        return bot.getToken();
    }

    public String getBotUsername() {
        return bot.getUserName();
    }

}
