import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;

public class wordles {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    static void countGreens(HashMap<Character, Integer> map, String input, String base) {
        for (int i = 0; i < base.length(); i++) {
            if (input.charAt(i) == base.charAt(i))
                incrementIntMap(input.charAt(i), map);
        }
    }

    static void incrementIntMap(char key, HashMap<Character, Integer> map) {
        if (!map.containsKey(key))
            map.put(key, 1);
        else {
            map.put(key, map.get(key) + 1);
        }
        return;
    }

    static void wordling(ArrayList<String> wordDatabase) {
        Scanner inp = new Scanner(System.in);
        Random rand = new Random();
        String secretWord = wordDatabase.get(rand.nextInt(wordDatabase.size()));
        // String secretWord = "vrows";
        System.out.println("Inserisci una parola inglese di 5 lettere");
        String input;
        HashMap<Character, Integer> secretMap = new HashMap<Character, Integer>();
        for (int i = 0; i < secretWord.length(); i++)
            incrementIntMap(secretWord.charAt(i), secretMap);
        HashMap<Character, Integer> inputMap = new HashMap<Character, Integer>();
        char currentChar;
        HashMap<Character, Integer> greenMap = new HashMap<Character, Integer>();
        do {
            do
                input = inp.next();
            while (input.length() != secretWord.length());
            inputMap.clear();
            countGreens(greenMap, input, secretWord);
            for (int i = 0; i < input.length(); i++) {
                if (!wordDatabase.contains(input)) {
                    System.out.print("Parola non valida");
                    break;
                }
                currentChar = input.charAt(i);
                incrementIntMap(currentChar, inputMap);
                if (currentChar == secretWord.charAt(i))
                    System.out.print(ANSI_GREEN + currentChar + ANSI_RESET);

                else if (!secretMap.containsKey(input.charAt(i))
                        ||
                        (inputMap.get(currentChar) > secretMap
                                .get(currentChar) - greenMap.getOrDefault(currentChar, 0)))
                    System.out.print(ANSI_RED + currentChar + ANSI_RESET);
                else
                    System.out.print(ANSI_YELLOW + currentChar + ANSI_RESET);
            }
            System.out.println("");
        } while (!input.equals(secretWord));
        inp.close();
    }

    public static void main(String arg[]) {
        ArrayList<String> wordDatabase = new ArrayList<>();
        try {
            File words = new File("3A/word.txt");
            // System.out.println(words.getAbsolutePath());
            Scanner scanner = new Scanner(words);
            while (scanner.hasNextLine())
                wordDatabase.add(scanner.nextLine().trim());
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File delle parole non trovato");
            return;
        }
        wordling(wordDatabase);
        System.out.println("Hai indovinato la parola segreta!");
    }
}