/*
1) UntrustworthyMailWorker — класс, моделирующий ненадежного работника почты, который вместо того, чтобы передать
почтовый объект непосредственно в сервис почты, последовательно передает этот объект набору третьих лиц, а затем,
в конце концов, передает получившийся объект непосредственно экземпляру RealMailService. У UntrustworthyMailWorker
должен быть конструктор от массива MailService (результат вызова processMail первого элемента массива передается на вход
processMail второго элемента, и т. д.) и метод getRealMailService, который возвращает ссылку на внутренний экземпляр
RealMailService, он не приходит масивом в конструкторе и не настраивается извне класса.
 */

public class UntrustworthyMailWorker implements MailService {
    private final MailService[] handler;
    private final RealMailService realMailService = new RealMailService();

    public UntrustworthyMailWorker(MailService[] handler) {
        this.handler = handler;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        Sendable sendable = mail;
        for (MailService mailService : handler) {
            sendable = mailService.processMail(sendable);
        }
        return realMailService.processMail(sendable);
    }

    public RealMailService getRealMailService() {
        return realMailService;
    }
}
