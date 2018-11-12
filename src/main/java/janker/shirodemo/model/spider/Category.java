package janker.shirodemo.model.spider;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author : WeiTong
 * @date :  2018/11/6 21:17
 */
@Setter
@Getter
public class Category implements Serializable {
    private String name;
    private String url;

    public Category(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Category() {
        super();
    }
}
