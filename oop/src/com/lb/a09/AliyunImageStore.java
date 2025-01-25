package com.lb.a09;

public class AliyunImageStore implements ImageStore {

    private String accessKeyId;
    private String secretAccessKey;

    // 构造函数：传入 AccessKey 和 SecretKey
    public AliyunImageStore(String accessKeyId, String secretAccessKey) {
        this.accessKeyId = accessKeyId;
        this.secretAccessKey = secretAccessKey;
    }

    @Override
    public String upload(Image image, String bucketName) {
        createBucketIfNotExisting(bucketName);
        String accessToken = generateAccessToken();
        // 模拟上传图片到阿里云
        System.out.println("Uploading image to Aliyun: " + image.getName() + " in bucket: " + bucketName);
        return "https://aliyun.com/" + bucketName + "/" + image.getName(); // 返回上传后的图片 URL
    }

    @Override
    public Image download(String url) {
        String accessToken = generateAccessToken();
        // 模拟从阿里云下载图片
        System.out.println("Downloading image from Aliyun: " + url);
        return new Image("downloaded_image.jpg", 1024, 768); // 返回下载的图片对象
    }

    // 创建 Bucket（如果不存在）
    private void createBucketIfNotExisting(String bucketName) {
        // 模拟创建 bucket 的逻辑
        System.out.println("Creating bucket: " + bucketName);
    }

    // 生成访问 Token
    private String generateAccessToken() {
        return accessKeyId + ":" + secretAccessKey + ":accessToken"; // 返回模拟的访问令牌
    }
}
