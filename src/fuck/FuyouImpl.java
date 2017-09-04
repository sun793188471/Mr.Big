package fuck;

import java.util.Map;

/**
 * Created by sunyukun on 2017/8/30.
 */
public class FuyouImpl implements Fuck {

    @Override
    public Map<String, ?> fuckyou(Map<String, ?> map) {
        for (String set : map.keySet()) {
            System.out.println(map.get(set));
        }
        return map;
    }
}
