package janker.shirodemo.service;

import janker.shirodemo.model.vo.BookAddVO;
import org.springframework.http.ResponseEntity;



/**
 * @author : WeiTong
 * @date :  2018/11/5 16:33
 */
public interface BookService  {

    ResponseEntity<Object> queryBook(String uuid);

    ResponseEntity<Object> addBook(BookAddVO book);
}
