import com.url.shortener.provider.UrlShortenerProvider;
import com.url.shortener.service.UrlShortenerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;


public class UrlShortenerTest {


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Mock
    UrlShortenerProvider urlshortenerProvider;


    @Test
    public void successfulUrlShorten_providerTest(){

        when(urlshortenerProvider.urlshortener("testurl.com/test-test")).thenReturn("testurl.com/test-test/1");
        Assertions.assertEquals(urlshortenerProvider.urlshortener("testurl.com/test-test"),"testurl.com/test-test/1");

    }

    @Test
    public void successfulUrlShorten_ServiceTest(){

        UrlShortenerServiceImpl instance = UrlShortenerServiceImpl.getInstance();
        String originUrl = "testurl.com/test-test";
        String urlshortener = instance.urlshortener(originUrl);
        Assertions.assertEquals(instance.getOriginUrl(urlshortener),originUrl);

    }

    @Test
    public void nullUrlShorten(){

        String urlshortener = urlshortenerProvider.urlshortener("");
        Assertions.assertEquals(urlshortener,null);

    }

    @Test
    public void successfulGetUrlOrigin_providerTest(){
        when(urlshortenerProvider.getOriginUrl("testurl.com/test-test/1")).thenReturn("testurl.com/test-test");
        Assertions.assertEquals(urlshortenerProvider.getOriginUrl("testurl.com/test-test/1"),"testurl.com/test-test");

    }


    @Test
    public void failedGetUrlOrigin(){

        String originUrl = urlshortenerProvider.getOriginUrl("");
        Assertions.assertEquals(originUrl,null);

    }
}
