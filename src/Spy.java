/*
2) Spy — шпион, который логгирует о всей почтовой переписке, которая проходит через его руки. Объект конструируется от
экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях. Он следит только за объектами класса
MailMessage и пишет в логгер следующие сообщения (в выражениях нужно заменить части в фигурных скобках на значения
полей почты):

2.1) Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать в лог сообщение с уровнем
WARN: Detected target mail correspondence: from {from} to {to} "{message}"

2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}
 */

public class Spy implements MailService{
    @Override
    public Sendable processMail(Sendable mail) {
        return null;
    }
}
