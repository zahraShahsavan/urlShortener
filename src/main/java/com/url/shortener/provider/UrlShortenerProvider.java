package com.url.shortener.provider;

public interface UrlShortenerProvider {

    String urlshortener(String url);

    String getOriginUrl(String shortenUrl);

}
