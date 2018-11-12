package janker.shirodemo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

/**
 * @author : WeiTong
 * @date :  2018/11/5 15:44
 */
@Slf4j
@Getter
@Setter
public class Goods implements Serializable {
    private static final long serialVersionUID = 1L;
    private String uuid;
    private String name;
    private Double price;
    private int stock;
    private List<String> images;
}
