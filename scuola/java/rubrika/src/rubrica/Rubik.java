package rubrica;

import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Rubik {
    static Scanner inpt = new Scanner(System.in);
    static final String NOME = "Nome = ";
    static final String TELEFONO = "; Telefono = ";
    static final String ETA = "; Età = ";

    static void createFile() {

        try {
            File myObj = new File("rubrica.txt");
            if (myObj.createNewFile()) {
                System.out.println("File creato: " + myObj.getName());
            } else {
                System.out.println("File esiste già.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    static void saveAndQuit(HashMap<String, Details> map) {
        createFile();
        try {
            FileWriter myWriter = new FileWriter("rubrica.txt");
            SortedSet<String> keys = new TreeSet<>(map.keySet());
            for (String key : keys) {
                myWriter.write(key + " " + map.get(key).phone + " " + map.get(key).age + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    static void addContact(HashMap<String, Details> map) {
        System.out.println("Inserisci il nome del nuovo contatto");
        String key = inpt.next();
        if (map.containsKey(key)) {
            System.out.println("Hai già un contatto con il stesso nome");
            return;
        }
        map.put(key, new Details());
        System.out.println("Inserisci il numero di telefono");
        map.get(key).phone = inpt.next();
        System.out.println("Inserisci l'età");
        map.get(key).age = inpt.nextInt();
    }

    static void listContact(HashMap<String, Details> map) {
        System.out.println("Lista dei contatti:");
        SortedSet<String> keys = new TreeSet<>(map.keySet());
        for (String key : keys) {
            System.out.println(NOME + key + TELEFONO + map.get(key).phone + ETA + map.get(key).age);
        }
    }

    static void deleteContact(HashMap<String, Details> map) {
        System.out.println("Inserisci il nome del contatto da eliminare");
        String key = inpt.next();
        if (map.containsKey(key)) {
            map.remove(key);
            System.out.println("Il contatto " + key + " è stato cancellato");
        } else
            System.out.println("Non esiste un contatto con il nome " + key);
    }

    static void listOf16(HashMap<String, Details> map) {
        System.out.println("Lista dei contatti sopra i 16 anni:");
        SortedSet<String> keys = new TreeSet<>(map.keySet());
        for (String key : keys) {
            if (map.get(key).age > 16)
                System.out.println(
                        NOME + key + TELEFONO + map.get(key).phone + ETA + map.get(key).age);
        }

    }

    static void searchContact(HashMap<String, Details> map) {
        System.out.println("Cerca un nome");
        String key = inpt.next();
        if (map.containsKey(key))
            System.out.println(NOME + key + TELEFONO + map.get(key).phone + ETA + map.get(key).age);
        else
            System.out.println("Non hai un contatto con quel nome");
    }

    static void searchGeneralContact(HashMap<String, Details> map) {
        System.out.println("Cerca un nome");
        String subname = inpt.next();
        SortedSet<String> keys = new TreeSet<>(map.keySet());
        for (String key : keys) {
            if (key.contains(subname))
                System.out.println(
                        NOME + key + TELEFONO + map.get(key).phone + ETA + map.get(key).age);
        }
    }

    static void modifyContact(HashMap<String, Details> map) {
        System.out.println("Cerca un nome da modificare");
        String key = inpt.next();
        if (map.containsKey(key))
            System.out.println(NOME + key + TELEFONO + map.get(key).phone + ETA + map.get(key).age);
        else {
            System.out.println("Non hai un contatto con quel nome");
            return;
        }
        System.out.println("Inserisci un nuovo nome");
        String newKey = inpt.next();
        map.put(newKey, map.get(key));
        map.remove(key);
        System.out.println("Inserisci un nuovo numero di telefono");
        map.get(newKey).phone = inpt.next();
        System.out.println("Inserisci una nuova età");
        map.get(newKey).age = inpt.nextInt();
        System.out.println("Il nuovo contatto modificato è:");
        System.out.println(
                NOME + newKey + TELEFONO + map.get(newKey).phone + ETA + map.get(newKey).age);
    }

    static void deleteContactList(HashMap<String, Details> map) {
        map.clear();
    }

    public static void main(String[] arg) {
        HashMap<String, Details> contacts = new HashMap<>();
        boolean isExiting = false;
        while (!isExiting) {
            System.out.println(
                    "1. aggiungi un contatto \n2. visualizza tutti i Contatti\n3. visualizza tutti i Contatti sopra i 16 anni\n4. modifica un Contatto\n5. cerca un Contatto \n6. cancella un Contatto\n7. cancella la rubrica\n8. cerca Contatti contenenti un input\n9. Esci e salva");
            switch (inpt.nextInt()) {
                case 1:
                    addContact(contacts);
                    break;
                case 2:
                    listContact(contacts);
                    break;
                case 3:
                    listOf16(contacts);
                    break;
                case 4:
                    modifyContact(contacts);
                    break;
                case 5:
                    searchContact(contacts);
                    break;
                case 6:
                    deleteContact(contacts);
                    break;
                case 7:
                    deleteContactList(contacts);
                    break;
                case 8:
                    searchGeneralContact(contacts);
                    break;
                case 9:
                    isExiting = true;
                    break;
                default:
                    System.out.println("Inserisci un valore valido");
                    break;
            }
        }
        saveAndQuit(contacts);
    }
}
