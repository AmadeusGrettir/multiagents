package weeklyTasks.decorators;

import weeklyTasks.decorators.Calls.Call;

import java.util.Set;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.lang.annotation.Annotation;

import java.io.File;
import java.util.Scanner;

public class AutoCallableAnnotationPostProcessor {

    public static void findAutoCallable() throws Exception{

        Reflections r = new Reflections(Call.class);
        Set<Class<? extends Call>> typesImplementCall = r.getSubTypesOf(Call.class);

        File file = new File("C:\\Users\\Андрей\\IdeaProjects\\multiagents\\src\\main\\java\\weeklyTasks\\decorators\\config.txt");
        Scanner scanner = new Scanner(file);

        for (Class<?> clazz : typesImplementCall) {

            //if (!Call.class.isAssignableFrom(clazz)) continue;

            for (Method method : clazz.getDeclaredMethods()) {

                Annotation annotation = method.getAnnotation(AutoCallable.class);
                AutoCallable test = (AutoCallable) annotation;

                if (test != null) {
                    try {
                        String text = scanner.nextLine();
                         method.invoke(clazz
                                .getDeclaredConstructor()
                                .newInstance(), text);
                    } catch (Throwable ex) {
                        System.out.println(ex.getCause());
                    }

                }
            }
        }
        scanner.close();
    }
}
