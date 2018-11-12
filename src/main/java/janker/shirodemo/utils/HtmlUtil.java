package janker.shirodemo.utils;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;

/**
 * @author : WeiTong
 * @date :  2018/11/6 21:20
 */
public class HtmlUtil {

    public static final Integer GET=0;

    public static final Integer POST=1;

    public static final Integer HTTP=0;

    public static final Integer HTTPS=1;

    public static CloseableHttpClient httpClient= HttpClients.createDefault();

    public static String getHtml(String url,Integer methodType,Integer httpType,Map<String,String> param) throws IOException {
        if(methodType.equals(GET)&&httpType.equals(HTTP)){
            HttpGet get=new HttpGet(url);
            get.setHeader("Connection", "keep-alive");
            get.setHeader("Upgrade-Insecure-Requests", "1");
            get.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36");
            HttpResponse response=httpClient.execute(get);
            if(response.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
                return EntityUtils.toString(response.getEntity(),"utf-8");
            }else{
                return null;
            }
        }else if(methodType.equals(POST)&&httpType.equals(HTTP)){
            HttpPost post=new HttpPost(url);
            post.setHeader("Connection", "keep-alive");
            post.setHeader("Upgrade-Insecure-Requests", "1");
            post.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36");
            post.setEntity(new StringEntity(new Gson().toJson(param)));
            HttpResponse response=httpClient.execute(post);
            if(response.getStatusLine().getStatusCode()!=HttpStatus.SC_OK){
                return EntityUtils.toString(response.getEntity(),"utf-8");
            }else{
                return null;
            }
        }
        return "";
    }

}
