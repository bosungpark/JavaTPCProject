import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Project02_A {
    public static void main(String[] args) {
        String url="https://sports.news.naver.com/index";
        Document doc=null;
        try{
            doc= Jsoup.connect(url).get();
        }catch (Exception e){
                e.printStackTrace();
        }
        Elements element = doc.select("div.main_wrap");
        System.out.println(element);
        String title= element.select("h3.blind").text();
        System.out.println("=================");
        System.out.println(title);
        System.out.println("=================");
        for(Element el: element.select("li.today_item")){
            System.out.println(el.text());
            System.out.println("=================");
        }
    }
}
