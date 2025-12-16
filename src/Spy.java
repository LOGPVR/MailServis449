/*
2) Spy — шпион, который логгирует о всей почтовой переписке, которая проходит через его руки. Объект конструируется от
экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях. Он следит только за объектами класса
MailMessage и пишет в логгер следующие сообщения (в выражениях нужно заменить части в фигурных скобках на значения
полей почты):

2.1) Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать в лог сообщение с уровнем
WARN: Detected target mail correspondence: from {from} to {to} "{message}"

2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}
 */

import java.util.logging.Logger;

public class Spy implements MailService{
    private final Logger logger;

    public Spy (Logger logger) {
        this.logger = logger;
    }

    public static final String AUSTIN_POWERS = "Austin Powers";

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailMessage) {
            MailMessage message = (MailMessage) mail;
            if (AUSTIN_POWERS.equals(message.getFrom()) ||
                AUSTIN_POWERS.equals(message.getTo())) {
                logger.warning("Detected target mail correspondence: from " + message.getFrom() + " to " +
                                message.getTo() + " \"" +message.getMessage() + "\"");
            } else {
                logger.info("Usual correspondence: from " + message.getFrom() +
                                " to " + message.getTo());
            }
        }
        return mail;
    }
}
