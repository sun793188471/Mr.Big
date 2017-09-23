package main.java.invoke;

/**
 * Created by sunyukun on 2017/9/20.
 */
public class InvokeTest {

    /**
     * 测试反射调用
     *
     * @param args
     */
    public static void main(String[] args) {
        InvokeUtils.invoke(new A(), "printA", new Class[]{String.class},
                new Object[]{"test"});

        InvokeUtils.invoke(new A(), "printB");
    }
}

