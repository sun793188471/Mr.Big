package deepCopy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunyukun on 2017/9/22.
 */
public class CopyTest {
    public static void main(String[] args) {
        TestCopy src = new TestCopy();


        src.setStringA("StringA");
        ForCopy srcInside = new ForCopy();
        srcInside.setToB("StringB");
        List<String> list = new ArrayList<String>();
        list.add("1");
        srcInside.setbList(list);
        src.setToCopy(srcInside);
        // clone
        TestCopy testCopy2 = src.copy();
        TestCopy testClone = (TestCopy) src.clone();

        src.getToCopy().setToB("fuck you!");
        src.getToCopy().getbList().set(0,"2");


        System.out.println("src:" + src.getToCopy().getToB()+" list:"+src.getToCopy().getbList().get(0));

        System.out.println("clone:" + testClone.getToCopy().getToB()+" list:"+testClone.getToCopy().getbList().get(0));

        System.out.println("testCopy2:" + testCopy2.getToCopy().getToB()+" list:"+testCopy2.getToCopy().getbList().get(0));


    }
}
