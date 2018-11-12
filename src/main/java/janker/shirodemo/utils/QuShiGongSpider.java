package janker.shirodemo.utils;

import janker.shirodemo.model.spider.Category;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : WeiTong
 * @date :  2018/11/6 21:14
 */
@Slf4j
public class QuShiGongSpider {

    //hostUrl
    public static String hostUrl = "http://www.qushigong.com/";

    public List<Category> getCategoryUrl() throws IOException {
        List<Category> result = new ArrayList<>();
        String homePage = HtmlUtil.getHtml(hostUrl, HtmlUtil.GET, HtmlUtil.HTTP, null);
        Document page = Jsoup.parse(homePage);
        Element optionList = page.select("div.commonOption").first();
        if (optionList == null) {
            log.info("获取首页信息失败");
            log.info("获取的页面内容：{}", homePage);
            return result;
        } else {
            List<Element> categoryList = optionList.select("div.ins").first().select("a");
            if (categoryList.size() > 1) {
                for (int i = 1; i < categoryList.size(); i++) {
                    Element cateElement = categoryList.get(i);
                    String name = cateElement.text();
                    String url = cateElement.attr("href");
                    Category category = new Category(name, url);
                    result.add(category);
                }
            }
            return result;
        }

    }

    public static void main(String[] args) {
        try {
            List<Category> cateList=new QuShiGongSpider().getCategoryUrl();
            for(Category category:cateList){
                log.info("分类- name :{}  ,url :{}",category.getName(),category.getUrl());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
