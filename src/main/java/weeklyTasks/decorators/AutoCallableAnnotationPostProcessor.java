package weeklyTasks.decorators;

import weeklyTasks.decorators.Calls.Call;

import weeklyTasks.decorators.Calls.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.reflections.Reflections;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;

import java.io.File;
import java.util.Scanner;

public class AutoCallableAnnotationPostProcessor {

    public static void findAutoCallable() throws Exception{

        Reflections r = new Reflections(Call.class);
        Set<Class<?>> typesAnnotatedWith = r.getTypesAnnotatedWith(Bean.class);

        File file = new File("C:\\Users\\Андрей\\IdeaProjects\\multiagents\\src\\main\\java\\weeklyTasks\\decorators\\config.txt");
        Scanner scanner = new Scanner(file);

        for (Class<?> clazz : typesAnnotatedWith) {

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
