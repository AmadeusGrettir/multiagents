package weeklyTasks.decorators.Calls;

import weeklyTasks.decorators.AutoCallable;

public class CallMeMine {
    @AutoCallable(name = "Err")
    public void call(String str) {
        System.err.println(str);
    }
}
