package lesson_5;

import java.util.Arrays;

public class Main {

    static int size = 10000000;
    static int h = size / 2;


    public static void main(String[] args) {
        oneMassive();
        twoMassive();
    }

    public static void oneMassive() {

        int size = 10000000;

        double[] arr = new double[size];

        Arrays.fill(arr, 1);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (double) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long finishTime = System.currentTimeMillis();

        System.out.println("Один поток: " + (finishTime - startTime) + " милисекунд");
    }


    public static void twoMassive() {

        int size = 10000000;

        double[] arr = new double[size];
        double[] arr1 = new double[size / 2];
        double[] arr2 = new double[size / 2];

        Arrays.fill(arr, 1);

        long startTime = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        Runnable r1 = ()->{
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        };

        Runnable r2 = ()->{
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = (float) (arr2[i] * Math.sin(0.2f + (i + h) / 5) * Math.cos(0.2f + (i + h) / 5) * Math.cos(0.4f + (i + h) / 2));
            }
        };

        Thread myThread1 = new Thread(r1,"MyThread1");
        Thread myThread2 = new Thread(r2,"MyThread2");

        myThread1.start();
        myThread2.start();

        try {
            myThread1.join();
            myThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);

        long finishTime = System.currentTimeMillis();

        System.out.println("Два потока: " + (finishTime - startTime) + " милисекунд");
    }
}
