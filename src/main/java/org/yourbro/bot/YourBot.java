package org.yourbro.bot;

import org.apache.log4j.Logger;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Document;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.yourbro.communication.MessageType;
import org.yourbro.services.botservice.BotService;

/**
 * This class represents the main bot's logic.
 *
 * The method {@link YourBot#onUpdateReceived(Update)} is used for
 * communication between users and bot.
 */
public final class YourBot extends AbstractBot {
    private static Logger LOG = Logger.getLogger(YourBot.class);

    public YourBot(final BotModel bot, final BotService botService) {
        super(bot, botService);
    }

    @Override
    public void onUpdateReceived(final Update update) {
        final Message receivedMessage = update.getMessage();
        MessageType messageType = botService.defineMessageType(receivedMessage);


    }

    @Override
    public String getBotUsername() {
        return super.getBotUsername();
    }

    @Override
    public String getBotToken() {
        return super.getBotToken();
    }
}
