package app.model;

import org.mindrot.jbcrypt.BCrypt;

public class Encryption {

    public static String encryptPssw(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean checkPassw(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

}
