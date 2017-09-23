package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sunyukun on 2017/9/13.
 */
public class WordFilterTest {
    public final static String REGX_A_Z_ONLY = "^[a-zA-Z]+$";
    // whole word matcher
    private static final List<String> KEYWORD_CLOUD_FREQUENT_WORD_LIST = Arrays.asList(("现有技术|技术领域|有益效果|省略视图|仰视图|更优选|相连接|图示简单说明|配制成|前述权利|即可制|任意一项|计算出|发送给|范围内|进一步|重要性|請求項|其特征在于|其特征是|其包括|其特征在|第二步|其制备方法是|图式简单说明|包括如下步骤|包括以下步骤|使用时|该方法包括|所述方法包括|系包含|采用本发明|通过本发明|方法包括|本发明的有益效果是|本实用新型的有益效果是|本实用新型的优点在于|通过上述方式|与现有技术相比|点的图片或照片|group consisting|mg/mL|group consisting|w/v|subject|thereof").split("\\|"));
    // contain word matcher
    private static final List<String> KEYWORD_CLOUD_FREQUENT_WORD_CONTAIN_LIST = Arrays.asList(("申请专利范围|请求项|权利要求|claim").split("\\|"));

    public static void main(String[] args) {

        List<String> blackWords = new ArrayList<String>();
        blackWords.add("权利要求书");
        blackWords.add("权利要求书1");
        blackWords.add("权利要求1");
        blackWords.add("1权利要求");
        blackWords.add("claims");
        blackWords.add("sclaim");
        blackWords.add("claim aa");
        blackWords.add("请求项 aa");
        blackWords.add("现有技术");
        blackWords.add("技术领域");
        blackWords.add("技术领");

        for (String s : blackWords) {
            filterFrequentWord(s);
        }
    }

    /**
     * filter Frequent words for more precise word cloud
     *
     * @param phrase
     * @return
     */
    private static boolean filterFrequentWord(String phrase) {
        boolean result = true;
        for (String wholeKey : KEYWORD_CLOUD_FREQUENT_WORD_LIST) {
            if (wholeKey.equalsIgnoreCase(phrase)) {
                System.out.println(wholeKey + " has fucked the:" + phrase);
                result = false;
            }
        }
        for (String containKey : KEYWORD_CLOUD_FREQUENT_WORD_CONTAIN_LIST) {
            if (phrase.toLowerCase().contains(containKey.toLowerCase())) {
                System.out.println(containKey + " has fucked the:" + phrase);
                result = false;
            }
        }
        return result;
    }
}