package idv.jk.web.parser;
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
import java.io.IOException;
import java.util.Iterator;
 
/**
 * Created by Javakid on 2015/4/14.
 */
public class soup
{
    public static void main(String[] argv)
    {
        String url = "http://www.cc.ntut.edu.tw/~wwwoaa/oaa-nwww/oaa-cal/oaa-cal_105.html";
        try {
            Document doc = Jsoup.connect(url).get();
            //System.out.println(doc.title());
            Elements trs = doc.select("table").select("tr");
            
            for(int i = 0;i<trs.size();i++){
                Elements tds = trs.get(i).select("td");
                for(int j = 0;j<tds.size();j++){
                    String text = tds.get(j).text();
                    System.out.println(text);
                }
            }
            /*Element thisOne = null;
            for(Iterator it = h1s.iterator(); it.hasNext();)
            {
                thisOne = (Element)it.next();
                System.out.println(thisOne.html());
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}