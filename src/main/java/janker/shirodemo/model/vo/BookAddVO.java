package janker.shirodemo.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author : WeiTong
 * @date :  2018/11/5 16:42
 */
@Setter
@Getter
@ApiModel(value = "书本信息")
public class BookAddVO implements Serializable {
    @ApiModelProperty(value="书名",name="name",notes="namenotes",dataType = "string",example = "从入门到出家系列",required = true)
    private String name;
    @ApiModelProperty(value="价格",name="price",notes="pricenotes",dataType = "double",example = "88.8",required = true)
    private Double price;
    @ApiModelProperty(value="页数",name="pageNumber",notes="pageNumbernotes",dataType = "int",example = "1000",required = true)
    private Integer pageNumber;
    @ApiModelProperty(value="作者名",name="authorName",notes="authorNamenotes",dataType = "string",example = "大牛",required = true)
    private String authorName;
}
