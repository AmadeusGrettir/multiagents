package weeklyTasks.comperator;

import java.util.regex.Pattern;

public class StringDataValidator {
    //производит проверку на идентичность двух передаваемых строк
    boolean validate (String first, String second) throws EmptyDataException, UnknownCharacterException{

        //проверка на то, что обе строки не пустные и не null
        if ((first == null || first.isEmpty()) || (second == null || second.isEmpty())) {
            throw new EmptyDataException();
        }

        //проверка, что обе строки не содержат никаких символов кроме английского алфавита и цифр
        if (!Pattern.matches("[a-zA-Z0-9\\s]+", first) || !Pattern.matches("[a-zA-Z0-9\\s]+", second)) {
            throw new UnknownCharacterException();
        }
        //сравнение строк
        if (Pattern.matches(second, first) ) {
            return true;
        } else {
            return false;
        }


    }
}
