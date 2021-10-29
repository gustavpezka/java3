import lesson6.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestAfterFour {
    private Main main;

    @BeforeEach
    public void initMain(){
        main = new Main();
    }

    @Test
    public void test1(){
        int[] array = {1,2,4,4,2,3,4,1,7};
        int[] newarray = {1,7};
        Assertions.assertArrayEquals(newarray, main.afterFour(array));
    }

    @Test
    public void test2(){
        int[] array = {1,2,4,4,2,3,4};
        int[] newarray = {};
        Assertions.assertArrayEquals(newarray, main.afterFour(array));
    }

    @Test
    public void test3(){
        int[] array = {1,2,2,3,6};
        Assertions.assertThrows(RuntimeException.class, ()-> main.afterFour(array));
    }

    @Test
    public void test4(){
        int[] array = {1,2,4,4,2,3,4,5,3,1,8,4,3,3,3,3};
        int[] newarray = {3,3,3,3};
        Assertions.assertArrayEquals(newarray, main.afterFour(array));
    }
}
