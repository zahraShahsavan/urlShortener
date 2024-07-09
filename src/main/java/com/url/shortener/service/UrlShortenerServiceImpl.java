package com.url.shortener.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


public class UrlShortenerServiceImpl implements UrlShortenerService {

    private static UrlShortenerServiceImpl instance;

    private static final String URL_STATIC_PART = "http://test.test/";

    private static final ConcurrentHashMap<String,String> urls = new ConcurrentHashMap<>();


    private AtomicLong identifier = new AtomicLong();


    public static synchronized UrlShortenerServiceImpl getInstance(){

        if (instance == null)
            instance = new UrlShortenerServiceImpl();

        return instance;
    }

    @Override
    public String urlshortener(String originUrl) {

        String shortenUrl = URL_STATIC_PART+generateIdentifier();

        urls.put(shortenUrl,originUrl);

        return shortenUrl;
    }

    @Override
    public String getOriginUrl(String shortenUrl) {

        return urls.get(shortenUrl);

    }

    private String generateIdentifier(){
        return String.valueOf(identifier.getAndIncrement());
    }
}
