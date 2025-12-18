import java.util.logging.Logger;

public class TestGlobal {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Spy.class.getName());
        Spy spy = new Spy(logger);
        Thief thief = new Thief(1000);
        Inspector inspector = new Inspector();
        MailService[] handler = {spy, thief, inspector};
        UntrustworthyMailWorker untrustworthyMailWorker = new UntrustworthyMailWorker(handler);

        MailMessage mailMessage = new MailMessage("Austin Powers", "Friend", "Secret message");
        MailPackage mailPackage = new MailPackage("Austin Powers", "Friend",
                new Package("Gold", 7000));
        untrustworthyMailWorker.processMail(mailMessage);
        try {
            untrustworthyMailWorker.processMail(mailPackage);
        } catch (IllegalPackageException | StolenPackageException exception) {
            System.out.println(exception.getMessage());
        }
        try {
            untrustworthyMailWorker.processMail(new MailPackage("Austin Powers", "Friend",
                    new Package("weapons", 7000)));
        } catch (IllegalPackageException | StolenPackageException e) {
            System.out.println(e.getMessage());
        }
    }
}
