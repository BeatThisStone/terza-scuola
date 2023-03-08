import java.util.*;

public class primo {
    public static void main(String arg[]) {
        int max = 10;
        int min = 0;
        int[] VET = new int[20];
        for (int i = 0; i < VET.length; i++) {
            VET[i] = (int) (Math.random() * (max - min + 1) + min);
        }
        double somma = 0;
        double media;
        for (int i = 0; i < VET.length; i++) {
            somma = somma + VET[i];
        }
        media = somma / VET.length;
        System.out.println(media);
    }
}
