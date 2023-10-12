package weeklyTasks.decorators;

/*
ДЗ: Разработать аннотацию @AutoCallable, которая применяется к методу класса, реализующего интерфейс Call (Runtime)
  внутрь метода передать параметр String из файла config.txt.
  Сделать два класса с методами @AutoCallable:
  1)Пишет в Std out
  2)Пишет в Std error
 */

public class Main {
    public static void main(String[] args) throws Exception {

        AutoCallableAnnotationPostProcessor.findAutoCallable();
    }
}
