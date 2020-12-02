public class Main {
    public static void main(String[] args) throws MyArraySizeException {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "a"},
                {"13", "b", "15", "16"}
        };
        someMethod(arr);
    }

    public static void someMethod(String[][] arr) throws MyArraySizeException {
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (String[] i : arr) {
            if (i.length != 4) {
                throw new MyArraySizeException();
            }
        }
        int arrSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[i].length; k++) {
                try {
                    arrSum += Integer.parseInt(arr[i][k]);
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка типа переменной в элементе [" + (i + 1) + "] [" + (k + 1) + "]");
                }

            }
        }
        System.out.println("Сумма элементов массива: " + arrSum);
    }
}

class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("Некорректный размер массива!");
    }
}