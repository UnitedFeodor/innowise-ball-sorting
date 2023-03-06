import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Tests {

    @BeforeAll
    static void before() {
        System.out.println("before ");
    }

    @Test
    void test1() {
        System.out.println("hi 1! ");
    }

    @Test
    void test2() {
        System.out.println("hi 2!");
    }
}
