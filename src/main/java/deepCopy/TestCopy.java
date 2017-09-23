package deepCopy;

import org.springframework.beans.BeanUtils;

/**
 * Created by sunyukun on 2017/9/22.
 */
public class TestCopy implements Cloneable {
    private String stringA;

    private ForCopy toCopy;

    public String getStringA() {
        return stringA;
    }

    public void setStringA(String stringA) {
        this.stringA = stringA;
    }

    public ForCopy getToCopy() {
        return toCopy;
    }

    public void setToCopy(ForCopy toCopy) {
        this.toCopy = toCopy;
    }

    public TestCopy copy() {
        TestCopy target = new TestCopy();
        BeanUtils.copyProperties(this, target);

        ForCopy tarGetSettings = new ForCopy();
        BeanUtils.copyProperties(this.getToCopy(), tarGetSettings);
        target.setToCopy(tarGetSettings);
        return target;
    }

    @Override
    public Object clone() {
        TestCopy sc = null;
        try {
            sc = (TestCopy) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return sc;
    }
}
