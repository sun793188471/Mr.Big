package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sunyukun on 2017/9/12.
 */
public class UnicodeTransfer {
    public final static String REGX_A_Z_ONLY = "^[a-zA-Z]+$";

    public static void main(String[] args) {
        Properties pro = new Properties();
        Reader in = null;
        try {
            in = new InputStreamReader(new FileInputStream("blackList.properties"), "UTF-8");
            pro.load(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Set<Object> set = pro.keySet();
        Iterator i = set.iterator();
        Object object = null;
        while (i.hasNext()) {
            object = i.next();
            System.out.println(gbEncoding(object.toString()));
        }
    }

    //中文转Unicode
    public static String gbEncoding(final String gbString) {
        Pattern p = Pattern.compile(REGX_A_Z_ONLY);
        Matcher m = p.matcher(gbString);
        if (m.matches()) {
            return gbString;
        }
        char[] utfBytes = gbString.toCharArray();   //utfBytes = [测, 试]
        String unicodeBytes = "";
        for (int byteIndex = 0; byteIndex < utfBytes.length; byteIndex++) {
            String hexB = Integer.toHexString(utfBytes[byteIndex]);   //转换为16进制整型字符串
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeBytes = unicodeBytes + "\\u" + hexB;
        }
        return unicodeBytes;
    }

    //Unicode转中文
    public static String decodeUnicode(final String dataStr) {
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2, dataStr.length());
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
            buffer.append(new Character(letter).toString());
            start = end;
        }
        return buffer.toString();

    }
}
