import java.util.HashMap;
import java.util.Scanner;

public class rubrica {
    static Scanner inpt = new Scanner(System.in);

    static void addContact(HashMap<String, String> namePhone, HashMap<String, Integer> nameAge) {
        System.out.println("Inserisci il nome del nuovo contatto");
        String key = inpt.next();
        System.out.println("Inserisci il numero di telefono");
        namePhone.put(key, inpt.next());
        System.out.println("Inserisci l'età");
        nameAge.put(key, inpt.nextInt());
    }

    static void listContact(HashMap<String, String> namePhone, HashMap<String, Integer> nameAge) {
        namePhone.forEach((key, value) -> {
            System.out.println("Nome = " + key + "; Telefono = " + value + "; Età = " + nameAge.get(key));
        });
    }

    static void deleteContact(HashMap<String, String> namePhone, HashMap<String, Integer> nameAge) {
        System.out.println("Inserisci il nome del contatto da eliminare");
        String key = inpt.next();
        if (namePhone.containsKey(key)) {
            namePhone.remove(key);
            nameAge.remove(key);
        } else
            return;
    }

    static void listOf16(HashMap<String, String> namePhone, HashMap<String, Integer> nameAge) {
        namePhone.forEach((key, value) -> {
            if (nameAge.get(key) > 16)
                System.out.println("Nome = " + key + "; Telefono = " + value + "; Età = " + nameAge.get(key));
        });
    }

    static void searchContact(HashMap<String, String> namePhone, HashMap<String, Integer> nameAge) {
        System.out.println("Cerca un nome");
        String key = inpt.next();
        if (namePhone.containsKey(key))
            System.out.println("Nome = " + key + "; Telefono = " + namePhone.get(key) + "; Età = " + nameAge.get(key));
        else
            System.out.println("Non hai un contatto con quel nome");
    }

    static void modifyContact(HashMap<String, String> namePhone, HashMap<String, Integer> nameAge) {
        System.out.println("Cerca un nome da modificare");
        String key = inpt.next();
        if (namePhone.containsKey(key))
            System.out.println("Nome = " + key + "; Telefono = " + namePhone.get(key) + "; Età = " + nameAge.get(key));
        else {
            System.out.println("Non hai un contatto con quel nome");
            return;
        }
        System.out.println("Inserisci un nuovo nome");
        String new_key = inpt.next();
        namePhone.put(new_key, namePhone.get(key));
        namePhone.remove(key);
        nameAge.put(new_key, nameAge.get(key));
        nameAge.remove(key);
        System.out.println("Inserisci un nuovo numero di telefono");
        namePhone.put(new_key, inpt.next());
        System.out.println("Inserisci una nuova età");
        nameAge.put(new_key, inpt.nextInt());
        System.out.println("Il nuovo contatto modificato è:");
        System.out.println(
                "Nome = " + new_key + "; Telefono = " + namePhone.get(new_key) + "; Età = " + nameAge.get(new_key));
    }

    public static void main(String arg[]) {
        HashMap<String, String> namePhone = new HashMap<>();
        HashMap<String, Integer> nameAge = new HashMap<>();

        addContact(namePhone, nameAge);
        listContact(namePhone, nameAge);
        searchContact(namePhone, nameAge);
        modifyContact(namePhone, nameAge);
        listOf16(namePhone, nameAge);
    }
}
