package com.lb.a09;

public class ImageProcessingJob {

    private static final String BUCKET_NAME = "ai_images_bucket";

    public void process() {
        // 创建一个示例图片对象
        Image image = new Image("ai_image.jpg", 800, 600);

        // 可以选择使用不同的存储方案
        ImageStore imageStore = new PrivateImageStore(); // 可以改为使用 AliyunImageStore

        // 上传图片到存储
        String imageUrl = imageStore.upload(image, BUCKET_NAME);
        System.out.println("Image uploaded to: " + imageUrl);

        // 下载图片（模拟）
        Image downloadedImage = imageStore.download(imageUrl);
        System.out.println("Downloaded image: " + downloadedImage.getName());
    }

    public static void main(String[] args) {
        // 执行处理任务
        ImageProcessingJob job = new ImageProcessingJob();
        job.process();
    }
}
