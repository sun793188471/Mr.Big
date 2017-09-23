package geographicDiversity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sunyukun on 2017/9/13.
 */
public class GeographicDiversity {
    public static void main(String[] args) {
        List<Duixiang> duixiangs = new ArrayList<>();
        generateDuixiangs(duixiangs);


        geographicDiversity(duixiangs);
    }

    private static void generateDuixiangs(List<Duixiang> duixiangs) {
        duixiangs.add(new Duixiang("en", 1L));
        duixiangs.add(new Duixiang("cn", 1L));
        duixiangs.add(new Duixiang("us", 1L));
        duixiangs.add(new Duixiang("jp", 1L));
        duixiangs.add(new Duixiang("rs", 1L));
        duixiangs.add(new Duixiang("in", 1L));
        duixiangs.add(new Duixiang("bb", 1L));
        duixiangs.add(new Duixiang("cc", 1L));
        duixiangs.add(new Duixiang("aa", 1L));
        duixiangs.add(new Duixiang("as", 1L));
    }

    private static void geographicDiversity(List<Duixiang> duixiangList) {
        Long sum = 0L;
        //todo 判空处理

        Collections.sort(duixiangList, new Comparator<Duixiang>() {
            @Override
            public int compare(Duixiang o1, Duixiang o2) {
                if (o1.getCount() < o2.getCount()) {
                    return 1;
                } else if (o1.getCount() > o2.getCount()) {
                    return -1;
                }
                return 0;
            }
        });

        Long[] a = new Long[duixiangList.size()];
        int i = 0;
        for (Duixiang duixiang : duixiangList) {
            System.out.println(duixiang.getCount() + "=======" + duixiang.getCount());
            sum += duixiang.getCount();
            a[i++] = duixiang.getCount();
        }
        Long tempSum = 0L;
        int count = 0;
        while (tempSum <= sum * 0.8) {
            tempSum += a[count];
            count++;
        }
        System.out.println(count - 1);
        System.out.printf("the percenteage is: %f", Double.valueOf(Double.valueOf(count - 1) / a.length));
    }
}
