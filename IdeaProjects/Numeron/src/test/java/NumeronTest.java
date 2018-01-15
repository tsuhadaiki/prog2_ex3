import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumeronTest {
    @Test
    void Testjudge() {
        int[] answer = {1,2,3};
        int[] input = {1,2,3};
        int eat = Numeron.judge(answer,input);
        assertEquals(3,eat);
    }

}