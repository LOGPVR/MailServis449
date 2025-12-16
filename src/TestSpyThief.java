import java.util.logging.Logger;

public class TestSpyThief {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Spy.class.getName());
        Spy spy = new Spy(logger);
        spy.processMail(new MailMessage("Austin Powers", "Получателю", "Секретное письмо"));
        spy.processMail(new MailMessage("Отправителя", "Получателю", "Обычное письмо"));
        spy.processMail(new MailPackage("Austin Powers", "Получатель",new Package("Золото", 10000)));
        spy.processMail(new MailPackage("Отправитель", "Получатель",new Package("Монеты", 20000)));

        Thief thief = new Thief(1000);
        MailPackage mailPackage1 = new MailPackage("Отправитель", "Получатель",
                new Package("Золото", 999));
        MailPackage mailPackage2 = new MailPackage("Отправитель", "Получатель",
                new Package("Золото", 5000));
        MailPackage mailPackage3 = new MailPackage("Отправитель", "Получатель",
                new Package("Игрушки", 4000));
        MailMessage mailMessage = new MailMessage("Отправитель", "Получатель", "Привет");

        thief.processMail(mailPackage1);
        System.out.println("своровал " + thief.getStolenValue());

        thief.processMail(mailPackage2);
        System.out.println("Второй раз обработал и своровал " + thief.getStolenValue());

        thief.processMail(mailPackage3);
        System.out.println("повторный тест сворованного " + thief.getStolenValue());

        Sendable result = thief.processMail(mailMessage);
        System.out.println("Обработка письма вернуло " + (result == mailMessage));
    }
}
