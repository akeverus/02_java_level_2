package lesson_2;

public class Main {
    public static void main(String[] args) {

        String[][] nums = new String[][] {{"1","2","3","4"},{"5","6","7","8"},{"9","10","11","12"},{"13","14","15","16"}};

        try {
            System.out.println(workWithMassive(nums));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

    }

    public static int workWithMassive(String[][] array) throws MyArraySizeException, MyArrayDataException {

        int sum = 0;

        if (array.length != 4) {
            throw new MyArraySizeException("В массиве не 4 строки. Количество строк: " + array.length);
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i].length != 4) {
                    throw new MyArraySizeException("В строке " + i + " не 4 элемента. Количество элементов в строке: " + array[i].length);
                }
                try {
                    sum = sum + Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Элемент массива " + i + "," + j + " не является числом");
                }
            }
        }

        return sum;
    }
}

class MyArraySizeException extends Exception {

    public MyArraySizeException(String message) {
        super(message);
    }

}

class MyArrayDataException extends Exception {

    public MyArrayDataException(String string) {
        super(string);
    }
}

