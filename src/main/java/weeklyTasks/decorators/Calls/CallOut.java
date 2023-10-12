package weeklyTasks.decorators.Calls;

import weeklyTasks.decorators.AutoCallable;

public class CallOut implements Call{
    @AutoCallable(name = "Out")
    @Override
    public void call(String str) {
        System.out.println(str);
    }

    public void terminator(String str) {
        System.out.println(str);
    }
}
