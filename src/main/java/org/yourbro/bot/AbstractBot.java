package org.yourbro.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public abstract class AbstractBot extends TelegramLongPollingBot {
    private BotModel bot;

    AbstractBot(final BotModel bot) {
        this.bot = bot;
    }

    @Override
    public String getBotToken() {
        return bot.getToken();
    }

    public String getBotUsername() {
        return bot.getUserName();
    }

}
