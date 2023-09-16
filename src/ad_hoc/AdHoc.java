package ad_hoc;

import java.util.Scanner;
public class AdHoc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int q = Integer.parseInt(scanner.nextLine());
        int[] array = generateArray(n);
        for (int i = 2; i < q+2; i++){
            String lineString = scanner.nextLine();
            String[] line = lineString.split(" ");
            int p = Integer.parseInt(line[0]);
            int r = Integer.parseInt(line[1]);
            int arraylength = (int) Math.pow(2,r);
            int subArrayIndex = p / arraylength;
            // edge cases for 2 1, 4 1, 4 2, 6 1, 8 1, 8 2 etc basically the right part on every r
            if (p%2 == 0){
                float res = p;
                for (int j = 0; j < r; j++){
                    res /= 2;
                }
                if (Math.floor(res) == res){
                    subArrayIndex -= 1;
                }
            }
            String res = firstAndLastValOfArray(generateSubSetNotIncluded(generateOverSet(array,arraylength,subArrayIndex),p));
            System.out.println(res);
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
        return (array[0]) + " " +(array[array.length-1]);
    }
    public static boolean isInArraySlice(int[] array, int start, int end, int val){
        return array[start] <= val && array[end] >= val;
    }
    public static int[] generateOverSet(int[] array, int length, int index){
        int[] res = new int[length];
        System.arraycopy(array,index*length,res,0,length);
        return res;
    }
    public static int[] generateSubSetNotIncluded(int[] array,int value){
        if (array.length > 1){
        int[] res = new int[array.length/2];
        if (isInArraySlice(array,0,array.length/2-1,value)){
            System.arraycopy(array,array.length/2,res,0,array.length/2);

        } else {
            System.arraycopy(array,0,res,0,array.length/2);
        }
        return res;
        } else {
            return array;
        }
    }

}
