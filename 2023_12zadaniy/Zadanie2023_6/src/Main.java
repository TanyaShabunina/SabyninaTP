import AuthenticationMethods.Fingerprint;
import AuthenticationMethods.OAuth;
import AuthenticationMethods.Password;
import Obstruction.Template;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Template fingerprint = new Fingerprint();
        Template oAuth = new OAuth();
        Template password = new Password();
        fingerprint.print();
        oAuth.print();
        password.print();
    }
}