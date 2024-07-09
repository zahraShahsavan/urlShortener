package com.url.shortener.provider;

import com.url.shortener.service.UrlShortenerServiceImpl;

public class UrlShortenerProviderImpl implements UrlShortenerProvider {


    @Override
    public String urlshortener(String url){

        if (url == null || url.length() ==0)
            return null;

        return UrlShortenerServiceImpl.getInstance().urlshortener(url);

    }

    @Override
    public String getOriginUrl(String shortenUrl){

        if (shortenUrl == null || shortenUrl.length() ==0)
            return null;

        return UrlShortenerServiceImpl.getInstance().getOriginUrl(shortenUrl);

    }

}
