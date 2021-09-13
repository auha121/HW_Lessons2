import java.util.Random;

public class Main {

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {

        String[][] strMass = new String[4][4];
        Random random = new Random();
        System.out.println("Массив");
        for (int i = 0; i < strMass.length; i++) {
            for (int j = 0; j < strMass[i].length; j++) {
                strMass[i][j] = Integer.toString(random.nextInt(101));
                System.out.print(strMass[i][j] + " ");
            }
            System.out.println();
        }

        String[][] strMassInvalid1 = {{"1", "2", "3", "4"},
                                     {"5", "6", "7", "8"},
                                     {"9", "10", "d", "12"},
                                     {"13", "14", "15", "16"}};
        String[][] strMassInvalid2 = {{"1", "2", "3", "4"},
                                     {"5", "6", "7", "8"},
                                     {"9", "10", "12"},
                                     {"13", "14", "15", "16"}};
        String[][] strMassInvalid3 = {{"1", "2", "3", "4"},
                                     {"5", "6", "7", "8"},
                                     {"9", "10", "11", "12"}};
        String[][] strMassInvalid4 = {{"1", "2", "3", "4"},
                                     {"5", "c", "7", "8"},
                                     {"9", "10", "11", "12"}};

        System.out.println("Сумма элементов массива  strMass  равна " + sumMass(strMass));
        System.out.println("Сумма элементов массива strMassInvalid1 равна " + sumMass(strMassInvalid1));
        System.out.println("Сумма элементов массива strMassInvalid2 равна " + sumMass(strMassInvalid2));
        System.out.println("Сумма элементов массива strMassInvalid3 равна " + sumMass(strMassInvalid3));
        System.out.println("Сумма элементов массива strMassInvalid4 равна " + sumMass(strMassInvalid4));
    }

    public static int sumMass(String[][] strMass) throws MyArraySizeException, MyArrayDataException {
        if (strMass.length != 4) {
            throw new MyArraySizeException("Количество строк в массиве не равно 4");
        }

        for (int i = 0; i < strMass.length; i++) {
            if (strMass[i].length != 4) {
                throw new MyArraySizeException("Количество столбцов в строке " + i + " не равно 4");
            }
        }
        int sum = 0;
        for (int i = 0; i < strMass.length; i++) {
            for (int j = 0; j < strMass[i].length; j++) {
                try {
                    sum += Integer.parseInt(strMass[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Элемент массива " + i  + ", " + j + " не является числом");
                }
            }
        }
        return sum;
    }
}
