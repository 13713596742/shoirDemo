package janker.shirodemo.model.po;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : WeiTong
 * @date :  2018/11/5 16:56
 */
@Setter
@Getter
public class AddBookPO {
 private String uuid;
 private String name;
 private Double price;
 private Integer pageNumber;
 private String authorName;
}
