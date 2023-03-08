import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;

public class wordle {
    static Scanner inp = new Scanner(System.in);
    static Random rand = new Random();

    public static void incrementIntMap(char key, HashMap<Character, Integer> map) {
        if (!map.containsKey(key))
            map.put(key, 1);
        else {
            map.put(key, map.get(key) + 1);
        }
        return;
    }

    public static void wordling(ArrayList<String> words) {
        String pSegreta = words.get(rand.nextInt(words.size()));
        System.out.println("Inserisci una parola inglese di 5 lettere");
        String input;
        HashMap<Character, Integer> pMap = new HashMap<Character, Integer>();
        for (int i = 0; i < pSegreta.length(); i++)
            incrementIntMap(pSegreta.charAt(i), pMap);
        HashMap<Character, Integer> iMap = new HashMap<Character, Integer>();
        char curChar;
        do {
            do
                input = inp.next();
            while (input.length() != pSegreta.length());
            iMap.clear();
            for (int i = 0; i < input.length(); i++) {
                if (!words.contains(input)) {
                    System.out.print("Parola non valida");
                    break;
                }
                curChar = input.charAt(i);
                incrementIntMap(curChar, iMap);
                if (!pMap.containsKey(input.charAt(i)) || iMap.get(curChar) > pMap.get(curChar))
                    System.out.print("X ");
                else if (curChar == pSegreta.charAt(i))
                    System.out.print("O ");
                else
                    System.out.print("/ ");
            }
            System.out.println("");
        } while (!input.equals(pSegreta));
    }

    public static void main(String arg[]) {
        ArrayList<String> words = new ArrayList<>();
        try {
            File parole = new File("3A/word.txt");
            Scanner scanner = new Scanner(parole);
            while (scanner.hasNextLine())
                words.add(scanner.nextLine().trim());
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File delle parole non trovato");
            return;
        }
        wordling(words);
        System.out.println("Hai indovinato la parola segreta!");
        inp.close();
    }
}