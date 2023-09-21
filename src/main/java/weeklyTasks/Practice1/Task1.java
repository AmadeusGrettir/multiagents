package weeklyTasks.Practice1;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] array = {5, 1, 9, 8, 11, 3};
        System.out.printf("Массив: %s %n %n", Arrays.toString(array));
        сombSort(array);
        System.out.printf("%s %n", Arrays.toString(array));
        double midscore;
        if (array.length%2==0){
            midscore = (double) (array[array.length / 2] + array[array.length / 2 - 1]) /2;
        } else {
            midscore = array[array.length/2];
        }
        System.out.printf("Медиана: %5.2f %n", midscore);
    }

    private static void bubbleSort(int[] array) {
        boolean flag = false;
        while (!flag) {
            flag = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    flag = false;
                }
            }
        }
    }

    private static void shakeSort(int[] array) {
        boolean end = false;
        while (!end) {
            end = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }

            for (int i = array.length - 1; i > 0; i--) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    end = false;
                }
            }
        }
    }

    public static void сombSort(int[] array) {
        int step = array.length;
        boolean end = false;

        while (!end) {
            end = true;
            step = (int) (step / 1.247);

            int i = 0;
            while (((i + step) < array.length) && (i < array.length - 1) && (step!=0)) {
                if (array[i] > array[i + step]) {
                    int temp = array[i];
                    array[i] = array[i + step];
                    array[i + step] = temp;
                }
                end = false;
                i++;

            }
        }
    }
}