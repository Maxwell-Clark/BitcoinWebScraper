package com.maxwell.app;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.maxwell.app.models.MessariResponse;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.ws.rs.core.Response;

public class App 
{
    public static void main( String[] args )
    {
        App app = new App();
        app.getTopBitcoinSubredditPost();
        app.getBitcoinPrice();
    }

    private void getTopBitcoinSubredditPost() {
        final String httpsUrl = "https://www.reddit.com/r/Bitcoin/top/";

        try {
            final HttpClient client = new HttpClient();
            client.start();

            final ContentResponse res = client.GET(httpsUrl);

            final Document doc = Jsoup.parse(res.getContentAsString());

            final Elements topPost = doc.select("a[data-click-id]");
            String topPostBody = topPost.select("h3").first().text();
            String topPostLink = topPost.attr("href");


            System.out.println("****** Content of the URL ********");
            System.out.println(topPostLink);
            System.out.println(topPostBody);

            //this is now pulling only the top post on the bitcoin subreddit.
            //next we need to pull the current bitcoin price.
            //then we need to store them both in a db. maybe as key-value pairs?
            //finally we need to build a UI that we can display the data on a plotted chart over time.
            client.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getBitcoinPrice() {
        Gson g = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("https://data.messari.io/api/v1/assets/bitcoin/metrics");
        Response response = target.request().get();
        String stringedResponse = response.readEntity(String.class);
        //This response is giving so much more than just the price of bitcoin. can definately look deeper into it.
        MessariResponse parsedResponse = g.fromJson(stringedResponse, MessariResponse.class);

        System.out.println("Current price of Bitcoin in US dollars: " + parsedResponse.getData().getMarketData().getPriceUsd());
    }
}
