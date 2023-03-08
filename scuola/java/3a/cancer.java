public class cancer {
    public static void main (String arg[]) {
        int[] array = new int[ 20 ];
        for (int i=0; i<=19;i++) {
            array[i] = (int)Math.floor(Math.random() *100);
            System.out.println(array[i]);
        }
        mergeSort(array);
        for (int i=0; i<=19;i++) {
            System.out.println(array[i]);
        }
    }
    static void mergeSort(int[] array) {
        int lun, lun2;
        boolean isSorted = false;
        lun = 1;
        lun2= 2;
        while (!isSorted) {
            if (lun2 > array.length) {
                isSorted = true;
            }
            else {
                for (int i = 0;i <= ((array.length/lun2)-1);i++) {
                    if (((array.length-((i+1)*lun2)) < 0) && ((array.length-((i+1)*lun2)) > 0)) {
                        merge(array, i, lun);
                        mergeToEnd(array, i, lun);
                    }
                    else {
                        merge(array, i, lun);
                    }
                }
            }
        }
    }
    static void merge(int[] array, int i, int lun) {
        int [] temp = new int[ array.length ];
        int L0 = i*2*lun;
        int R0 = L0+lun-1;
        int L1 = R0+1;
        int R1 = L1+lun-1;
        i = 0;
        while ((L0<=R0) && (L1<=R1)) {
            if (array[L0] < array[L1]) {
                temp[i] = array[L0];
                L0++;
            }
            else {
                temp[i] = array[L1];
                L1++;
            }
            i++;
        }
        while (L0<=R0) {
            temp[i] = array[L0];
            i++;
            L0++;
        }
        while (L1<=R1) {
            temp[i] = array[L1];
            i++;
            L1++;
        }
        int k = 0;
        for (int j = i*2*lun;((i*2+2)*lun-1)<=j;j++) {
            array[j] = temp[k];
            k++;
        }
    }
    static void mergeToEnd(int[] array, int i, int lun) {
        int [] temp = new int[ array.length ];
        int L0 = i*2*lun;
        int R0 = L0+2*lun-1;
        int L1 = R0+1;
        int R1 = array.length-1;
        i = 0;
        while ((L0<=R0) && (L1<=R1)) {
            if (array[L0] < array[L1]) {
                temp[i] = array[L0];
                L0++;
            }
            else {
                temp[i] = array[L1];
                L1++;
            }
            i++;
        }
        while (L0<=R0) {
            temp[i] = array[L0];
            i++;
            L0++;
        }
        while (L1<=R1) {
            temp[i] = array[L1];
            i++;
            L1++;
        }
        int k = 0;
        for (int j = i*2*lun;((i*2+2)*lun-1)<=j;j++) {
            array[j] = temp[k];
            k++;
        }
    }
}