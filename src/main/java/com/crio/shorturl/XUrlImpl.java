package com.crio.shorturl;

import java.util.*;

public class XUrlImpl implements XUrl {

    private HashMap<String, String> longUrlToShortUrlMap = new HashMap<>();
    private HashMap<String, Integer> longUrlVisitCount = new HashMap<>();
    private HashMap<String, String> shortUrlToLongUrlMap = new HashMap<>();

    private char[] choices = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public XUrlImpl() {
        System.out.println("URL shortner system activated");
    }

    @Override
    public String registerNewUrl(String longUrl) {
        // TODO Auto-generated method stub

        if (longUrlToShortUrlMap.containsKey(longUrl)) longUrlToShortUrlMap.get(longUrl);

        String shortUrl = "http://short.url/" + generateUniqueString();

        longUrlToShortUrlMap.put(longUrl, shortUrl);
        shortUrlToLongUrlMap.put(shortUrl, longUrl);

        return shortUrl;
    }

    @Override
    public String registerNewUrl(String longUrl, String shortUrl) {
        // TODO Auto-generated method stub

        if (shortUrlToLongUrlMap.containsKey(shortUrl)) return null;
        shortUrlToLongUrlMap.put(shortUrl, longUrl);
        longUrlToShortUrlMap.put(longUrl, shortUrl);

        return shortUrl;
    }

    @Override
    public String getUrl(String shortUrl) {
        // TODO Auto-generated method stub

        String url = null;

        if (shortUrlToLongUrlMap.containsKey(shortUrl)) {
            url = shortUrlToLongUrlMap.get(shortUrl); 
            longUrlVisitCount.put(url, longUrlVisitCount.getOrDefault(url, 0) + 1);
        }

        return url;
    }

    @Override
    public Integer getHitCount(String longUrl) {
        // TODO Auto-generated method stub
        return longUrlVisitCount.getOrDefault(longUrl, 0);
    }

    @Override
    public String delete(String longUrl) {
        // TODO Auto-generated method stub
        String shortUrl = longUrlToShortUrlMap.get(longUrl);
        longUrlToShortUrlMap.remove(longUrl);
        shortUrlToLongUrlMap.remove(shortUrl);
        return null;
    }

    private String generateUniqueString() {
        String result = "";

        for (int i = 0; i < 9; i++) result += choices[(int) (Math.random() * 100) % 52];

        return result;

    }
    
}