package janker.shirodemo.idal;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import janker.shirodemo.service.BookService;
import janker.shirodemo.model.vo.BookAddVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author : WeiTong
 * @date :  2018/11/5 16:23
 */
@RestController
@Api(description = "图书")
@RequestMapping("book_manage")
public class BookIdal {

    @Resource
    private BookService bookService;
     @GetMapping("book")
     @ApiOperation(value = "查询图书")
    public ResponseEntity<Object> queryBook(@RequestParam String uuid){
        return bookService.queryBook(uuid);
    }
    @PostMapping("book")
    @ApiOperation(value = "添加图书")
    public ResponseEntity<Object> addBook(@RequestBody BookAddVO book){
        return bookService.addBook(book);
    }
}
