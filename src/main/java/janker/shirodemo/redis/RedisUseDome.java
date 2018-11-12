package janker.shirodemo.redis;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : WeiTong
 * @date :  2018/10/31 16:52
 */
@Slf4j
public class RedisUseDome {

    private static final String ip = "111.230.157.165";
    private static final int port = 6379;
    private static final String password = "951207";
    private static Jedis jedis;
    private static int timeOut = 2000;

    private static JedisPool jedisPool;


    public static void init() throws Exception {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(1024);
        config.setMaxIdle(10);
        config.setMaxWaitMillis(1000);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        jedisPool = new JedisPool(config, ip, port, timeOut, password);
        jedis = jedisPool.getResource();


    }

    public static void main(String[] args) {
        try {
            init();
//            log.info("清空数据："+jedis.flushDB());

//            log.info("插入字符 ：{}",jedis.set("janker","剑客"));
//            log.info("获取字符：{}",jedis.get("janker"));

//            log.info("插入有效期为2秒的字符串", jedis.set("dream", "a coder"));
//            jedis.expire("dream", 2);
//            log.info("dream is : {}", jedis.get("dream"));
//            Thread.sleep(2000L);
//            log.info("dream is : {}", jedis.get("dream"));

//            log.info("修改janker的值",jedis.set("janker","jianke"));
//            log.info("修改后的值 {}",jedis.get("janker"));
//            log.info("在jianke后面添加值：{}",jedis.append("janker","剑客"));
//            log.info("添加后的值：{}",jedis.get("janker"));

//            log.info("添加多个键值 :{}",jedis.mset("myDream","to be a great coder","myLove","chengYue","myHome","mianCheng","myFamily","forever"));
//            log.info("获取多个值 :{}",jedis.mget("myDream","myLove","myHome","myFamily"));
//            jedis.mset("myWay","never know","myWay","never saw","myHistory","let it go");
//            log.info("删除键:{}",jedis.del(new String[]{"myWay","myWay"}));
//            log.info("删除结果：{}",jedis.mget("myWay","myFuture","myHistory"));

//            log.info("新增长字段并设置过期时间：{}", jedis.setex("longText", 2, "Spring Cloud Bus将分布式系统的节点与轻量级消息代理链接。这可以用于广播状态更改（例如配置更改）或其他管理指令。一个关键的想法是，Bus就像一个扩展的Spring Boot应用程序的分布式执行器，但也可以用作应用程序之间的通信渠道。当前唯一的实现是使用AMQP代理作为传输，但是相同的基本功能集（还有一些取决于传输）在其他传输的路线图上"));
//            log.info("获取新增字段：{}", jedis.get("longText"));
//            Thread.sleep(2000L);
//            log.info("获取过期字段：{}", jedis.get("longText"));

//            log.info("添加年龄:{}",jedis.set("myAge","23"));
//            log.info("添加工龄:{}",jedis.set("workYear","0.5"));
//            log.info("年龄加1:{}",jedis.incrByFloat("workYear",1.0));
//            log.info("时间穿越10年:{}",jedis.incrBy("myAge",10));
//            log.info("一年后的工龄:{}",jedis.get("workYear"));
//            log.info("十年后的我:{}",jedis.get("myAge"));
//            log.info("时间在倒退回10年前：{}",jedis.decrBy("myAge",20));
//            log.info("十年前的我：{}",jedis.get("myAge"));
//            /* Add the string value to the head (LPUSH) or tail (RPUSH) of the list stored at key.*/
//            log.info("插入一个数列：{}", jedis.lpush("myLanguage", "java", "c", "python", "javaScript"));
//            log.info("数组全部元素：{}", jedis.lrange("myLanguage", 0, -1));
//            log.info("插入数组元素：{}", jedis.lpush("myLanguage", "sql"));
//            log.info("数组全部元素：{}", jedis.lrange("myLanguage", 0, -1));
//             /* count ：1 指删除重复个数*/
//            log.info("删除数组指定元素：{}", jedis.lrem("myLanguage", 1, "sql"));
//            log.info("数组全部元素：{}", jedis.lrange("myLanguage", 0, -1));
//            log.info("修改指定下标：{}", jedis.lset("myLanguage", 2, "C"));
//            log.info("数组左出列：{}", jedis.lpop("myLanguage"));
//            log.info("数组全部元素：{}", jedis.lrange("myLanguage", 0, -1));
//            log.info("数组右出列：{}", jedis.rpop("myLanguage"));
//            log.info("数组全部元素：{}", jedis.lrange("myLanguage", 0, -1));
//            log.info("数组排序：{}", jedis.sort("myLanguage"));
//            log.info("数组全部元素：{}", jedis.lrange("myLanguage", 0, -1));

//            log.info("添加集合:{}",jedis.sadd("frame","spring","springMvc","myBatis","springBoot","hibernate","jedis","spring"));
//            log.info("集合所有元素：{}",jedis.smembers("frame"));
//            log.info("删除两个元素：{}",jedis.srem("frame","hibernate","jedis"));
//            log.info("随机移除一个元素：{}",jedis.spop("frame"));
//            log.info("集合所有元素：{}",jedis.smembers("frame"));
//            log.info("集合中元素的个数：{}",jedis.scard("frame"));
//            log.info("判断是否在集合中：{}",jedis.sismember("frame","docker"));
//            jedis.sadd("history","struts","hibernate","servlet","spring");
//            log.info("集合中的交集：{}",jedis.sinter("frame","history"));
//            log.info("集合中的并集：{}",jedis.sunion("frame","history"));
//            log.info("集合中的差集：{}",jedis.sdiff("frame","history"));
//            log.info("移除一个元素到另外一个集合",jedis.smove("frame","history","myBatis"));
//            log.info("集合所有元素：{}",jedis.smembers("frame"));
//            log.info("集合所有元素：{}",jedis.smembers("history"));

//            Map<String,String> map=new HashMap<String,String>(16);
//            map.put("myName","janker");
//            map.put("myCnName","剑客");
//            map.put("myHome","mianCity");
//            map.put("myAge","23");
//            map.put("myLove","chengyue");
//            map.put("myDream","a greate coder");
//            map.put("myFamily","forever");
//
//            log.info("添加map：{}",jedis.hmset("zwt",map));
//            log.info("添加map键值对：{}",jedis.hset("zwt","myMind","universe"));
//            log.info("所有键值对：{}",jedis.hgetAll("zwt"));
//            log.info("所有键：{}",jedis.hkeys("zwt"));
//            log.info("所有值：{}",jedis.hvals("zwt"));
//            log.info("增加不存在键值：{}",jedis.hincrBy("zwt","myWorkYear",1));
//            log.info("所有键值对：{}",jedis.hgetAll("zwt"));
//            log.info("散列键值对个数：{}",jedis.hlen("zwt"));
//            log.info("是否存在值myFuture：{}",jedis.hexists("zwt","myFuture"));
//            log.info("获取多个值:{}",jedis.hmget("zwt","myLove","myDream"));

            jedis.rpush("myLife","nursery school","primary school","junior school","senior school","university","work","marry","give birth to a child","older","sleep forever");
            SortingParams sortingParams=new SortingParams();
            log.info("对数列中的字符串排序：{}",jedis.sort("myLife",sortingParams.alpha()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
            jedisPool.close();
        }

    }


}
