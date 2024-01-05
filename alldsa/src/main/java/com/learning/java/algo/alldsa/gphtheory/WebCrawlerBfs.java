package com.learning.java.algo.alldsa.gphtheory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawlerBfs {

    private Queue<String> queue;
    private List<String> discoveredWebsiteList;

    public WebCrawlerBfs(){
        this.queue = new LinkedList<>();
        this.discoveredWebsiteList = new ArrayList<>();
    }

    //root is starting web url
    public void discoverWeb(String root){
        this.queue.add(root);
        this.discoveredWebsiteList.add(root);
        while (!queue.isEmpty()){
            String current = this.queue.remove();
            String rawHtml = readUrl(current);

            // Regex to check valid URL
            String regexhttps = "https://(\\w+\\.)*(\\w+)";
            String regex = "((http|https)://)(www.)?"
                    + "[a-zA-Z0-9@:%._\\+~#?&//=]"
                    + "{2,256}\\.[a-z]"
                    + "{2,6}\\b([-a-zA-Z0-9@:%"
                    + "._\\+~#?&//=]*)";

            // Compile the ReGex
            Pattern pattern = Pattern.compile(regexhttps);
            Matcher matcher = pattern.matcher(rawHtml);
            while (matcher.find()){
                String matchedWeb = matcher.group();
                if(!discoveredWebsiteList.contains(matchedWeb)){
                    discoveredWebsiteList.add(matchedWeb);
                    System.out.println("website found::: " + matchedWeb);
                    queue.add(matchedWeb);
                }
            }

        }
    }

    private String readUrl(String currentUrl){
        StringBuilder rawHtml = new StringBuilder();
        try{
            URL url = new URL(currentUrl);
            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream()));
            String inLine;
            while((inLine = bf.readLine()) != null){
                rawHtml.append(inLine);
            }
            bf.close();
        }catch(Exception ex){
            System.out.println("not able to crawl website::::"+currentUrl);
        }
        return rawHtml.toString();
    }

    public static void main(String[] args) {
        WebCrawlerBfs webCrawlerBfs = new WebCrawlerBfs();
        webCrawlerBfs.discoverWeb("https://www.bbc.com");
    }

}
