package org.yourbro.bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.Properties;

public class YourBot extends TelegramLongPollingBot{

    public void onUpdateReceived(final Update update) {

    }

    public String getBotUsername() {
        return null;
    }

    public String getBotToken() {
        return null;
    }
}
