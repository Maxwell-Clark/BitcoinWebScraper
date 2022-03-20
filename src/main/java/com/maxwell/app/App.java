package com.maxwell.app;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        new App().scrape();
    }

    private void scrape() {
        final String httpsUrl = "https://www.reddit.com/r/Bitcoin/top/";

        try {
            final HttpClient client = new HttpClient();
            client.start();

            final ContentResponse res = client.GET(httpsUrl);

            final Document doc = Jsoup.parse(res.getContentAsString());

            final Elements topPost = doc.select("a[data-click-id]");
            Elements topPostBody = topPost.select("h3");


            System.out.println("****** Content of the URL ********");
            System.out.println(topPost.attr("href"));
            System.out.println(topPost.select("h3").first().text());

            //this is now pulling only the top post on the bitcoin subreddit.
            //next we need to pull the current bitcoin price.
            //then we need to store them both in a db. maybe as key-value pairs?
            //finally we need to build a UI that we can display the data on a plotted chart over time.
            client.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
