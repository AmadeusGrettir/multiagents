package weeklyTasks.comperator;


import java.util.Scanner;

/*
Разработать класс StringDataValidator,
который производит проверку на идентичность двух передаваемых строк.
Класс содержит один метод boolean validate (String first, String second).

В начале метода д.б. произведена проверка на то, что обе строки не пустные и не null,
иначе бросается EmptyDataException.
Потом идет проверка, что обе строки не содержат никаких символов кроме английского алфавита и цифр.
Потом идет сравнение строк.

Также необходимо разработать иерархию исключений:
- DataException - родительский Exception, наследуется от RuntimeException
- EmptyDataException - бросается, когда переданная строка null или пустая,
наследуется от DataException
- UnknownCharacterException  - бросается, когда строка содержит символы
кроме английского алфавита и цифр, наследуется от DataException

Провести проверку сценариев:
 1. Передать две одинаковых строки, должно вернуться true
 2. Передать две разных строки, должно вернуться false
 3. Передать две одинаковых строки на русском языке, должно вызваться исключение UnknownCharacterException
 4. Передать одну пустую строку и одну произвольную, должно вызваться исключение EmptyDataException

Отловить exceptions в блоке try catch, при возникновении EmptyDataException
вывести stack trace exception и в system error надпись о том, что сделано неправильно.
При UnknownCharacterException - сделать то же самое, но выводить в system out
*/
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String second = sc.nextLine();
        sc.close();

        StringDataValidator sdv = new StringDataValidator();

        try{
            System.out.println(sdv.validate(first, second));
        }catch (EmptyDataException exception){
            exception.printStackTrace();
            System.err.println("Cтроки пустные или null");

        }catch (UnknownCharacterException exception){
            exception.printStackTrace();
            System.out.println("Cтроки содержат иные символы кроме английского алфавита и цифр");
        }

    }
}
