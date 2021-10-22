package lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FruitBox <T extends  Fruit> {
    private List<T> container;

    public FruitBox() {
        this.container = new ArrayList<>();
    }

    public FruitBox(T... fruits) {
        this.container = new ArrayList(Arrays.asList(fruits));
    }

    public float getWeight() {

        float w = 0.0f;
        for (T fruit : container) {
            w += fruit.getWeight();
        }
        return w;
    }

    public boolean sameAvg(FruitBox<?> another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.001;
    }

    public void transfer(FruitBox<? super T> another) {
        if (another == this) {
            return;
        }
        another.container.addAll(this.container);
        this.container.clear();
    }

    public void add(T fruit) {
        container.add(fruit);
    }
}
