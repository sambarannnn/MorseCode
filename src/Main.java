import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("--> Enter 1 for English to Morse conversion.\n--> Enter 2 for Morse to English Conversion.");
        int choice1 = s.nextInt();

        System.out.println("Alright! Now,\n-->Enter 1 to convert from CLI.\n-->Enter 2 to convert from .txt file");
        int choice2 = s.nextInt();

        Morse converter = new Morse(choice1, choice2);
        converter.convert();
    }
}
