package janker.shirodemo.service.impl;

import com.google.gson.Gson;
import janker.shirodemo.HttpResponseSupport;
import janker.shirodemo.service.BookService;
import janker.shirodemo.mapper.BookMapper;
import janker.shirodemo.model.vo.BookAddVO;
import janker.shirodemo.model.vo.BookVO;
import janker.shirodemo.model.po.AddBookPO;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.annotation.CacheConfig;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


/**
 * @author : WeiTong
 * @date :  2018/11/5 16:35
 */
@Service
@Slf4j
public class BookServiceImpl implements BookService {
    @Resource
    private BookMapper bookMapper;
    @Resource
    private RedisTemplate redisTemplate;


    @Override
//    @Cacheable(value = "book", keyGenerator = "wiselyKeyGenerator")
    public ResponseEntity<Object> queryBook(String uuid) {
        String key = "book:" + uuid;
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
//        BookVO book=getBook(key);
        BookVO book = (BookVO) operations.get(key);
        log.info("缓存返回数据：{}", new Gson().toJson(book));
        if (book == null) {
            log.info("查询数据库");
            book = bookMapper.queryBook(uuid);
            redisTemplate.opsForValue().set(key, book, 100, TimeUnit.SECONDS);
        }
        return HttpResponseSupport.success(book);
    }

    //    @Cacheable(value = "book", keyGenerator = "wiselyKeyGenerator")
    public BookVO getBook(String key) {
        BookVO book = null;
       /* String result=(String)redisTemplate.opsForValue().get(key);
        log.info("result:{}",result);
        if(StringUtils.isBlank(result)){
            return book;
        }
        book=new Gson().fromJson(result,BookVO.class);*/
        return book;
    }


    @Override
    public ResponseEntity<Object> addBook(BookAddVO book) {
        AddBookPO addBookPO = new AddBookPO();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        addBookPO.setUuid(uuid);
        addBookPO.setName(book.getName());
        addBookPO.setPrice(book.getPrice());
        addBookPO.setPageNumber(book.getPageNumber());
        addBookPO.setAuthorName(book.getAuthorName());
        bookMapper.addBook(addBookPO);
        return HttpResponseSupport.success("成功", "success");
    }
}
