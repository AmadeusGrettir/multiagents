package weeklyTasks.decorators.Calls;

import weeklyTasks.decorators.AutoCallable;

@Bean
public class CallErr implements Call{
    @AutoCallable(name = "Err")
    @Override
    public void call(String str) {
        System.err.println(str);
    }

    public void railgun(String str) {
        System.out.println(str);
    }
}
