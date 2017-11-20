package org.yourbro.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
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

    @Override
    public String getBotToken() {
        return bot.getToken();
    }

    public String getBotUsername() {
        return bot.getUserName();
    }

}
