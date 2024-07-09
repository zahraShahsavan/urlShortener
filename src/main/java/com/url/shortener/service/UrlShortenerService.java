package com.url.shortener.service;

public interface UrlShortenerService {
    String urlshortener(String originUrl);
    String getOriginUrl(String shortenUrl);

}
