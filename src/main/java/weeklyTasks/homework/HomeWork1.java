import java.util.Scanner;
import java.util.regex.Pattern;

public class HomeWork1 {
    public static void main(String[] args) {

        /*ЛК ДЗ (БЕЗ ТЕСТОВ):
        - Задано число int. Вывести в консоль "четное!", если число четное.
          Вывести в консоль "нечетное.", если число нечетное.
          В конце записи вывести само число*/

        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = in.nextInt();
        String answer;

        if (num%2==0) {
            answer = "четное!";
        } else {
            answer ="нечетное.";
        }
        System.out.println(answer);
        System.out.println("Само число: " + num);


        /*Задано слово String. Вывести каждую букву этого слова с новой строки.
          Если в слове есть буква "а" - прекратить вывод букв,
          "а" не должно быть выведено.*/
        System.out.print("Введите слово: ");
        String word = in.next();
        
        if (Pattern.matches("[а-яА-Я]+", word)){
            String[] wordArray = word.split("");
            for (String symbol : wordArray) {
                if (symbol.equals("а")) {
                    break;
                } else {
                    System.out.println(symbol);
                }
            }
        } else {
            System.out.println("Некорректный ввод");
            }


    }
}