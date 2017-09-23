package geographicDiversity;

/**
 * Created by sunyukun on 2017/9/13.
 */
public class Duixiang {
    private String country;
    private Long count;

    public String getCountry() {
        return country;
    }

    public Duixiang(String country, Long count) {
        this.country = country;
        this.count = count;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
