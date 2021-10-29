package lesson6;
//1. Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
// Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после последней четверки.
// Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
//        Написать набор тестов для этого метода (по 3-4 варианта входных данных).
//        Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
//        Вх: [ 1 2 4 4 2 3 4 ] -> вых: [ ].
//        Вх: [ 1 2 ] -> RuntimeException
//        Вх: [ 1 2 4 4 2 3 1 7 ] -> вых: [ 2 3 1 7 ].
//
//        2. Написать метод, который проверяет состав массива из чисел 1 и 4. Если в нем нет хоть одной четверки или единицы,
//        то метод вернет false; Если есть что то кроме 1 или 4 то вернется false; Написать набор тестов для этого метода (по 3-4 варианта входных данных).
//        [ 1 1 1 4 4 1 4 4 ] -> true
//        [ 1 1 1 1 1 1 ] -> false
//        [ 4 4 4 4 ] -> false
//        [ 1 4 4 1 1 4 3 ] -> false

import java.util.Arrays;

public class Main {

    public int[] afterFour(int[] array){
        for (int i = array.length-1; i >= 0; i--) {
            if (array[i] == 4) {
                return Arrays.copyOfRange(array, i+1, array.length);
            }
        }
        throw new RuntimeException("no 4");
    }

    public boolean onesAndFours(int[] array){
        boolean got1 = false;
        boolean got4 = false;
        boolean gotOther = false;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == 1){
                got1 = true;
                continue;
            }if(array[i] == 4){
                got4 = true;
                continue;
            }else{gotOther = true;}
        }
        if (got1&&got4&&!gotOther){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int array[] = {3,2,1,5,6,4,2,2,8,6,4,1,2,3};
        int array1[] = {3,2,1,5,6,2,2,8,6,1,2,3};
        Main main = new Main();
        System.out.println(Arrays.toString(main.afterFour(array)));
        System.out.println(main.onesAndFours(array));
    }
}
