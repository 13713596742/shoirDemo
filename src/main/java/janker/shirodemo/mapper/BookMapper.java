package janker.shirodemo.mapper;

import janker.shirodemo.model.vo.BookVO;
import janker.shirodemo.model.po.AddBookPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import springfox.documentation.annotations.Cacheable;


/**
 * @author : WeiTong
 * @date :  2018/11/5 16:36
 */
@Mapper
public interface BookMapper {
    BookVO queryBook(@Param("uuid") String uuid) ;

    void addBook(AddBookPO addBookPO);
}
