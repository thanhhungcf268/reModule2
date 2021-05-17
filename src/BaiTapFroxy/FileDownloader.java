package BaiTapFroxy;

import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Pattern;

public class FileDownloader implements Downloader{
    private final String url = URLConnection.guessContentTypeFromName("https://docs.oracle.com/javase/7/docs/api/java/net/URLConnection.html");
    @Override
    public void downloader() {
    }
}
