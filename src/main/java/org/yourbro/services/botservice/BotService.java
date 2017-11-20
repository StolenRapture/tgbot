package org.yourbro.services.botservice;

import org.telegram.telegrambots.api.objects.Message;
import org.yourbro.communication.MessageType;

public interface BotService {
    MessageType defineMessageType(Message message);

}
