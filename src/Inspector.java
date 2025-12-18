/*
4) Inspector — Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу в виде исключения,
если была обнаружена подобная посылка. Если он заметил запрещенную посылку с одним из запрещенных содержимым
("weapons" и "banned substance"), то он бросает IllegalPackageException. Если он находит посылку, состоящую из камней
(содержит слово "stones"), то тревога прозвучит в виде StolenPackageException. Оба исключения вы должны объявить
самостоятельно в виде непроверяемых исключений.
 */

public class Inspector implements MailService {
    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            MailPackage mailPackage = (MailPackage) mail;
            Package content = mailPackage.getContent();
            String contentStr = content.getContent();
            if (contentStr.contains("weapons")
                    || contentStr.contains("banned substance")) {
                throw new IllegalPackageException("Недопустимое содержание посылки");
            }
            if (contentStr.contains("stones")) {
                throw new StolenPackageException("Произошла подмена содержимого на Камни");
            }
        }
        return mail;
    }
}
