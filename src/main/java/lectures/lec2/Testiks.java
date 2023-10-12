package lectures.lec2;

import java.util.Arrays;

public class Testiks {
    public static void main(String[] args) {

        int[] array = {5, 8, 1, 6, 3};

        int sum = 0;
        for ( int i1 =0; i1 < array.length; i1++){
            sum = sum + array[i1]*array[i1];
        }

        sum=0;
        for (int i : array) {
            sum = sum + i*i;
        }

        System.out.println(sum/ array.length);


        int[] array2 ={10,1,5,7,8,4,3};
        for(int i=0; i < array2.length; i++){
            for(int j=i+1; j < array2.length; j++){
                if (array2[i] > array2[j]){
                    int temp = array2[i];
                    array2[i] = array2[j];
                    array2[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(array2));

        int a = 10; int b = 20;
        int summa = sum(a, b);
        System.out.println(summa);


        }

    public static int sum(int a, int b) {
        int res = a+b;
        return res;
    }
}


