package ad_hoc;

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
            print(firstAndLastValOfArray(divideArrayByTwo(array,arraylength,p)));


        }
        scanner.close();

    }
    public static void print(String args){
        System.out.println(args);
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
    public static boolean isInArray(int[] array,int val) {
        for (int element : array) {
            if (val == element) {
                return true;
            }
        }
        return false;
    }
    public static int[] divideArrayByTwo(int[] array,int length,int value) {
        if (array.length > 1) {
            int middle = (array.length / 2);
            int[] first = new int[array.length / 2];
            int[] second = new int[array.length / 2];
            System.arraycopy(array, 0, first, 0, array.length / 2);
            System.arraycopy(array, middle, second, 0, array.length / 2);
            if (first.length == length) {
                if (isInArray(first, value)) {
                    return second;
                } else {
                    return first;
                }
            } else {
                if (isInArray(first, value)) {
                    return divideArrayByTwo(first, length, value);
                } else {
                    return divideArrayByTwo(second, length, value);
                }
            }
        } else {
            return array;
        }
    }
}