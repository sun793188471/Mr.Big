import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sunyukun on 2017/8/29.
 */
public class Test {
    public static void main(String[] args) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateNowStr = sdf.format(d);
        System.out.println(dateNowStr);

        Format f = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        String currentDate = f.format(c.getTime());
        System.out.println("之前:" + f.format(c.getTime()));
        c.add(Calendar.YEAR, -5);
        String currentDate1 = f.format(c.getTime());
        System.out.println("之后:" + f.format(c.getTime()));

        System.out.println(currentDate);
        System.out.println(currentDate1);

        String s = String.format("APD_YEARMONTHDAY:[%s TO %s]","20120901","20170901");
        System.out.println(s);
    }
}
