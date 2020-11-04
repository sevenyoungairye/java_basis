package demo02;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * 线程实现方式3 实现callable接口
 * @author echo lovely
 * @date 2020/11/3 17:32
 */
public class TestCallable implements Callable<Boolean> {

    private String url;
    private String fileName;

    public TestCallable(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownloader downloader = new WebDownloader();
        downloader.downloader(this.url, this.fileName);
        System.out.println("下载了" + fileName);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://cdn.cai-cai.me/x/851B1C9F-31E7-4B4C-B61B-E5348E06D9C1.jpg", "1.jpg");
        TestCallable t2 = new TestCallable("https://cdn.cai-cai.me/x/25BCB4F7-B969-48A6-9D95-0B5C4E2E3C5B.jpg", "2.jpg");
        TestCallable t3 = new TestCallable("https://cdn.cai-cai.me/x/15DF6B53-573B-4BF2-86E4-1C76119CF804.jpg", "3.jpg");

        // 1. 开启服务
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 2. 提交执行
        Future<Boolean> r1 = executorService.submit(t1);
        Future<Boolean> r2 = executorService.submit(t2);
        Future<Boolean> r3 = executorService.submit(t3);

        // 3. 获取执行
        Boolean rs1 = r1.get();
        Boolean rs2 = r2.get();
        Boolean rs3 = r3.get();

        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);

        // 4. 关闭服务
        executorService.shutdownNow();
    }

}

class WebDownloader {
    /**
     * 下载文件 （歌曲，图片，视频）
     * @param url 文件的http路径
     * @param fileName 保存的文件路径
     */
    public void downloader(String url, String fileName) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
