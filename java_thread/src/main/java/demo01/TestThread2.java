package demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 线性thread，实现多线程同步下载图片
 * @author echo lovely
 * @date 2020/11/2 21:02
 */
public class TestThread2 extends Thread {

    private String url;
    private String fileName;

    public TestThread2(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
    }

    @Override
    public void run() {

        // 开启下载
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, fileName);
        System.out.println("下载了：" + fileName);

    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://cdn.cai-cai.me/x/851B1C9F-31E7-4B4C-B61B-E5348E06D9C1.jpg", "1.jpg");
        TestThread2 t2 = new TestThread2("https://cdn.cai-cai.me/x/25BCB4F7-B969-48A6-9D95-0B5C4E2E3C5B.jpg", "2.jpg");
        TestThread2 t3 = new TestThread2("https://cdn.cai-cai.me/x/15DF6B53-573B-4BF2-86E4-1C76119CF804.jpg", "3.jpg");

        // 三个线程同时下载
        t1.start();
        t2.start();
        t3.start();

        /**
         * 下载了：1.jpg
         * 下载了：3.jpg
         * 下载了：2.jpg
         * 可以看去，多线程的运行不是按顺序执行的，是cpu安排，随机调度实现的！
         */
    }
}

class WebDownloader {
    public void downloader(String url, String fileName) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
