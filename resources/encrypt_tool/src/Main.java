import javax.crypto.Cipher;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    private static void crypto(boolean encrypt, File inputFile, String key) {

    }

    public static void main(String[] args) {
        if (args.length == 3) {
            int encrypt = Integer.parseInt(args[0]);
            File inputFile = new File(args[1]);
            String key = args[2];

            if (encrypt == 1) {
                try {
                    CryptoUtils.encrypt(key, inputFile, inputFile);
                } catch (CryptoException ex) {
                    System.out.println(ex.getMessage());
                    ex.printStackTrace();
                }
            } else {
                try {
                    CryptoUtils.decrypt(key, inputFile, inputFile);
                } catch (CryptoException ex) {
                    System.out.println(ex.getMessage());
                    ex.printStackTrace();
                }
            }
        } else {
            // Help Menu
            System.out.println("\n[HELP]\n\t<0 - Decrypt>\n\t<1 - Encrypt>\n\t<filename>\n\t<16-bit key>");
        }
    }
}
