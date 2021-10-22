package lesson1;


//1 Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
//2 Написать метод, который преобразует массив в ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class GenericSwap {
    public static void main(String[] args) {

        FruitBox<Orange> box = new FruitBox<>();
        box.add(new Orange());
        box.add(new Orange());
        box.add(new Orange());
        box.add(new Orange());

        FruitBox<Orange> box1 = new FruitBox<>();

        box.transfer(box1);

    }

    public static <T> void genericSwap(T[] array, int cell1, int cell2 ){
        T obj = array[cell1];
        array[cell1] = array[cell2];
        array[cell2] = obj;
    }

    public static <T> ArrayList<T> arrayToList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }


}
