/*
3) Thief — вор, который ворует самые ценные посылки и игнорирует все остальное. Вор принимает в конструкторе переменную
int – минимальную стоимость посылки, которую он будет воровать. Также, в данном классе должен присутствовать метод
getStolenValue, который возвращает суммарную стоимость всех посылок, которые он своровал. Воровство происходит следующим
образом: вместо посылки, которая пришла вору, он отдает новую, такую же, только с нулевой ценностью и содержимым посылки
"stones instead of {content}".
 */

public class Thief implements MailService{
    private final int minBorder;
    private int stolenCounter = 0;

    public Thief (int minBorder) {
        this.minBorder = minBorder;
    }

    int getStolenValue() {
        return stolenCounter;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            MailPackage mailPackage = (MailPackage) mail;//кастим потому что у Sendable нет метода getContent,потому что mail extends AbstractSendable
            Package content = mailPackage.getContent();
            if (content.getPrice() >= minBorder) {
                stolenCounter += content.getPrice();
                Package stolenContent = new Package("stones instead of " +
                        content.getContent(), 0);
                MailPackage stolenPackage = new MailPackage(mailPackage.getFrom(), mailPackage.getTo(), stolenContent);
                return stolenPackage;
            }
        }
        return mail;
    }
}
