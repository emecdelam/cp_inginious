package ad_hoc;
import java.util.Arrays;
import java.util.Scanner;
public class AdHoc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int q = Integer.parseInt(scanner.nextLine());

        int[] array = generateArray(n);
        for (int i = 2; i < q+2; i++){
            String[] line = scanner.nextLine().split(" ");
            int p = Integer.parseInt(line[0]);
            int r = Integer.parseInt(line[1]);
            int arraylength = (int) Math.pow(2,r-1);
            System.out.println(firstAndLastValOfArray(divideArrayByTwo(array,arraylength,p)));
        }
        scanner.close();

    }
    public static int[] generateArray(int n) {
        int[] numberArray = new int[n];

        for (int i = 1; i <= n; i++) {
            numberArray[i - 1] = i;
        }

        return numberArray;
    }
    public static String firstAndLastValOfArray(int[] array){
        return String.valueOf(array[0]) + " " + String.valueOf(array[array.length-1]);
    }
    public static boolean isInArraySlice(int[] array, int start, int end, int val){
        return array[start] <= val && array[end] >= val;
    }
    public static int[] divideArrayByTwo(int[] array,int length,int value) {
        if (array.length > 1) {
            int middle = (array.length / 2);
            int middleIndex = middle -1;
            if (array.length/2 == length) {
                int[] res = new int[array.length/2];
                if (isInArraySlice(array,0,middleIndex,value)){
                    System.arraycopy(array, middle, res, 0, array.length / 2);
                } else {
                    System.arraycopy(array, 0, res, 0, array.length / 2);
                }
                return res;
            } else {
            int[] newArray = new int[array.length/2];
            if (isInArraySlice(array,0,middleIndex,value)){
                System.arraycopy(array, 0, newArray, 0, array.length / 2);
            } else {
                System.arraycopy(array, middle, newArray, 0, array.length / 2);
                }
                return divideArrayByTwo(newArray,length,value);
            }
        } else {
            return array;
        }
    }

}
