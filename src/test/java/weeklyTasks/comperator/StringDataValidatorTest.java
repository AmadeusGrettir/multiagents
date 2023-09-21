package weeklyTasks.comperator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringDataValidatorTest {

    StringDataValidator sdv = new StringDataValidator();

    @Test
    @DisplayName("1. Две одинаковых строки (true)")
    void validate1() {
        String first = "Hi niGGa";
        String second = "Hi niGGa";

        boolean answer = sdv.validate(first, second);

        Assertions.assertTrue(answer);
    }

    @Test
    @DisplayName("2. Две разных строки (false)")
    void validate2() {
        String first = "Hi niGGa";
        String second = "Bye niGGa";

        boolean answer = sdv.validate(first, second);

        Assertions.assertFalse(answer);
    }

    @Test
    @DisplayName("3. Две одинаковых строки на русском языке (исключение)")
    void validate3() {
        String first = "Я люблю морКровь";
        String second = "Я люблю морКровь";

        Assertions.assertThrows(UnknownCharacterException.class, () -> {
            boolean answer = sdv.validate(first, second);;
        });
    }
    @Test
    @DisplayName("4. Одна пустая строка и одна произвольная (исключение)")
    void validate4() {
        String first = "";
        String second = "Я люблю морКровь";

        Assertions.assertThrows(EmptyDataException.class, () -> {
            boolean answer = sdv.validate(first, second);;
        });
    }
}