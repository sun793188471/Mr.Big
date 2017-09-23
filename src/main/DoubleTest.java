package main;

import java.math.BigDecimal;

/**
 * Created by sunyukun on 2017/9/7.
 */
public class DoubleTest {
    public static void main(String[] args) {
        Double a = 2.25;
        Double b = 2.001;
        Double c = 2.04;
        Double d = 2.02;
        System.out.println(convertDoubleToString(a));
        System.out.println(convertDoubleToString(b));
        System.out.println(convertDoubleToString(c));
        System.out.println(convertDoubleToString(d));

        System.out.println((float) Math.pow((double) 750/646, 1.0 / 5) - 1.0f);
    }

    /**
     * 对于double类型的数据进行小数点一位后的四舍五入的处理，当数据为整数时清除后面的0
     *
     * @param doubleNumber
     * @return result
     */
    private static String convertDoubleToString(Double doubleNumber) {
        BigDecimal bigDecimalTemp = new BigDecimal(doubleNumber);
        Double f1 = bigDecimalTemp.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        if (f1 == f1.intValue()) {
            return String.valueOf(f1.intValue());
        }
        return f1.toString();
    }
}
