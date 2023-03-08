import java.util.*;

public class wat {
    public static int mySqrt(int x) {
        int[] a = new int[10];
        Arrays.fill(a, 0);
        for (int i = 2; i <= x; i++) {
            System.out.println(i * i);
            if ((i * i) > x) {
                return i - 1;
            }
        }
        if (x == 1)
            return 1;
        else
            return 0;

    }

    public static void main(String arg[]) {
        System.out.println(mySqrt(2147395600));

    }
}
