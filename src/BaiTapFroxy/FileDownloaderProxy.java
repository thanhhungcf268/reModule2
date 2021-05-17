package BaiTapFroxy;

public class FileDownloaderProxy implements Downloader{
    @Override
    public void downloader() {
        FileDownloader fileDownloader = new FileDownloader();
        fileDownloader.downloader();
    }
}
