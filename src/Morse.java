import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Morse {
    private final String[] morsecode = { ".-", "-...", "-.-.", "-..",  ".",
                    "..-.", "--.", "....", "..", ".---",
                    "-.-", ".-..", "--", "-.",   "---",
                    ".--.", "--.-", ".-.",  "...",  "-",
                    "..-",  "...-", ".--",  "-..-", "-.--",
                    "--..", "|" };

    private final Map<String, String> Morse_English;
    private String EnglishText;
    private String MorseText;
    private final int choice1;
    private final int choice2;
    Morse(int choice1, int choice2) {
        Morse_English = new HashMap<>();
        //populates HashMap with key-vprivate alue pair as morse-english alphabet pair
        for (int i = 0; i < 26; i++) {
            Morse_English.put(morsecode[i], String.valueOf((char)('a' + i)));
        }
        this.choice1 = choice1;
        this.choice2 = choice2;
    }
    protected void convert() {
        Scanner s = new Scanner(System.in);
        String data;
        if(choice2 == 1) {
            System.out.println("Enter the text : ");
            data = s.nextLine();
        } else {
            System.out.println("Enter the filename : ");
            String infilename = s.nextLine();
            File file = new File(infilename);
            StringBuilder sb = new StringBuilder();
            try {
                Scanner f = new Scanner(file);
                while(f.hasNext()) {
                    sb.append(f.nextLine());
                }
            } catch(Exception e) {
                System.out.println("Error");
            }
            data = sb.toString();
        }

        if(choice1 == 1) {
            EnglishText = data;
            MorseText = English_to_Morse();
            if(choice2 == 1) {
                System.out.println("Morse Code : " + MorseText);
            } else {
                File file = new File("MorseOutput.txt");
                try {
                    FileWriter writer = new FileWriter(file);
                    writer.write(MorseText);
                } catch (IOException e) {
                    System.out.printf("An Error occurs %s", e.getMessage());
                }
            }
            EnglishText = EnglishText.replaceAll(" ", "");
        } else {
            MorseText = data;
            EnglishText = Morse_to_English();
            if(choice2 == 1) {
                System.out.println("English Text : " + EnglishText);
            } else {
                File file = new File("EnglishOutput.txt");
                try {
                    FileWriter writer = new FileWriter(file);
                    writer.write(EnglishText);
                } catch (IOException e) {
                    System.out.printf("An Error occurs %s", e.getMessage());
                }
            }
        }
    }

    private String Morse_to_English() {
        StringBuilder sb = new StringBuilder();
        String[] array = MorseText.split(" ");
        for (String s : array) {
            sb.append(Morse_English.get(s) + " ");
        }
        return sb.toString();
    }
    private String English_to_Morse() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < EnglishText.length(); i++) {
            sb.append(morsecode[EnglishText.charAt(i) - 'a'] + " ");
        }
        return sb.toString();
    }
}
