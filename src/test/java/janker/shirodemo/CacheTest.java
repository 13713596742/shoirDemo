package janker.shirodemo;

import janker.shirodemo.model.Goods;
import janker.shirodemo.model.spider.Category;
import janker.shirodemo.utils.QuShiGongSpider;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author : WeiTong
 * @date :  2018/11/5 15:19
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class CacheTest {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Test
    public void RedisTests() {
        JSONObject date = new JSONObject();
        JSONArray array = new JSONArray();
        array.put("janker");
        try {
            date.put("array", array);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            Goods goods = new Goods();
            goods.setUuid("sfiaenojnsaoidfnoea");
            goods.setName("mac");
            goods.setPrice(100.00);
            goods.setStock(1000000);
            List<String> image = new ArrayList<String>();
            image.add("www.image.demo.com");
            image.add("www.image.demo.com");
            image.add("www.image.demo.com");
            image.add("www.image.demo.com");
            goods.setImages(image);
//            redisTemplate.opsForValue().set("goods",goods);
            Goods reciver = (Goods) redisTemplate.opsForValue().get("goods");
            log.info("缓存信息：{}", reciver.getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addCategory() {
        try {
            List<Category> cateList = new QuShiGongSpider().getCategoryUrl();
            String key = "qushigong:category";
            for (Category c:cateList) {
                redisTemplate.opsForSet().add(key,c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void listGet(){
        String key = "qushigong:category";
        Set<Object> cateList=redisTemplate.opsForSet().members(key);
        for( Object o: cateList){
            Category c=(Category)o;
            log.info("分类- name:{} url:{}",c.getName(),c.getUrl());
        }
    }
}
