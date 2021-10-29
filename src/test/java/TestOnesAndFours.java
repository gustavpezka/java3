import lesson6.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestOnesAndFours {
    private Main main;

    @BeforeEach
    public void initMain(){
        main = new Main();
    }

    @Test
    public void test1(){
    int[] array = {1,1,1,1,1,1,1};
    Assertions.assertFalse(main.onesAndFours(array));
    }

    @Test
    public void test2(){
    int[] array = {4,4,4,4,4,4,4};
    Assertions.assertFalse(main.onesAndFours(array));
    }

    @Test
    public void test3(){
    int[] array = {1,2,3,4,5,6,7};
    Assertions.assertFalse(main.onesAndFours(array));
    }

    @Test
    public void test4(){
    int[] array = {1,4,1,4,1,4,1};
    Assertions.assertTrue(main.onesAndFours(array));
    }
}

