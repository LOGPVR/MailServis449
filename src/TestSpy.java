import java.util.logging.Logger;

public class TestSpy {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Spy.class.getName());
        Spy spy = new Spy(logger);
        spy.processMail(new MailMessage("Austin Powers", "Получателю", "Секретное письмо"));
        spy.processMail(new MailMessage("Отправителя", "Получателю", "Обычное письмо"));
        spy.processMail(new MailPackage("Austin Powers", "Получатель",new Package("Золото", 10000)));
        spy.processMail(new MailPackage("Отправитель", "Получатель",new Package("Монеты", 20000)));
    }
}
