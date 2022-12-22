package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class GoogleDemo {

    private static Document document;
    private static final String url = "https://www.google.com/search?q=text&start=";
    private static final String selector = "div.TbwUpd";


    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {


        try {
            document = Jsoup.connect(url + i*10)
                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com")
                    .timeout(5000)
                    .get();
        } catch (IOException e) {
            System.err.println("Check HTTP connection to the url " + url);
        }
        Elements links = document.select(selector);

        for (Element link : links) {
            String s = link.text();
            if (s.contains("https://tei-c.org"))
            System.out.println(i);
        }
        }
    }
}
