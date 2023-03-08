import java.util.Scanner;
import java.util.Random;
public class indN
{
    public static void main (String arg[]) {
        System.out.println("Inserisci il tuo nome");
        Scanner inp = new Scanner(System.in);
        Random rand = new Random();
        String nome = inp.next();
        int x = 10;
        int tentativi = x-2;
        int nSecreto = rand.nextInt(x+1);
        int nIn;
        System.out.println("Inserisci un numero da 0 a " + x);
        do {
        if (tentativi < x-2) {
            System.out.println("Numero errato");
            System.out.println("Numero di tentativi rimasto:" + tentativi);
        }
        nIn = inp.nextInt();
        tentativi--;
        } while ((nSecreto != nIn) && (tentativi != 0));
        if (tentativi == 0) {
            System.out.println("Non hai indovinato, " + nome);
        }
        else {
            System.out.println("Hai indovinato, " + nome + "!");
            System.out.println("Il numero segreto era " + nSecreto + "!");
        }
    }
}