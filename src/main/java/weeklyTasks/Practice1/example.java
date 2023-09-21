package weeklyTasks.Practice1;

import java.util.Random;

public class example {

    public static void main(String[] args) {
        int size = 30000000;
        Random r = new Random();
        int[] v = new int[size];
        for (int i = 0; i < size; v[i++] = r.nextInt(10000)) ;
        long time = System.currentTimeMillis();
        newCombSort(v);
        long endTime = System.currentTimeMillis();
        System.out.println("Time is " + (endTime - time));

//		 for(int i = 0; i < size; i++) {
//		 System.out.print(v[i] + " ");
//		 }
    }


    private static void stupidSort(int[] v) {
        boolean end = false;
        while (!end) {
            end = true;
            for (int i = 0; i < v.length - 1; i++) {
                if (v[i] > v[i + 1]) {
                    int t = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = t;
                    end = false;
                    break;
                }
            }
        }
    }

    private static void bulbSort(int[] v) {
        boolean end = false;
        while (!end) {
            end = true;
            for (int i = 0; i < v.length - 1; i++) {
                if (v[i] > v[i + 1]) {
                    int t = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = t;
                    end = false;
                }
            }
        }
    }

    private static void shakeSort(int[] v) {
        boolean end = false;
        while (!end) {
            end = true;
            for (int i = 0; i < v.length - 1; i++) {
                if (v[i] > v[i + 1]) {
                    int t = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = t;
                    end = false;
                }
            }

            for (int i = v.length - 1; i > 0; i--) {
                if (v[i] < v[i - 1]) {
                    int t = v[i];
                    v[i] = v[i - 1];
                    v[i - 1] = t;
                    end = false;
                }
            }
        }
    }


    public static void coolSort(int[] v) {
        float loadFactor = 1.247f;
        int step = v.length;
        boolean end = false;
        int t;
        while (!end) {
            end = true;
            step /= loadFactor;
            if (step < 1) {
                step = 1;
            }
            for (int i = 0; i < v.length - 1; i++) {
                if ((i + step) < v.length) {
                    if (v[i] > v[i + step]) {
                        t = v[i];
                        v[i] = v[i + step];
                        v[i + step] = t;
                        end = false;
                    }
                } else {
                    end = false;
                }

            }

        }
    }


    public static void newCombSort(int[] array) {
        int step = array.length;
        boolean end = false;

        while (!end) {
            end = true;
            step = (int) (step / 1.247);

            int i = 0;
            while ((i + step) < array.length && i < array.length - 1 && step != 0) {
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