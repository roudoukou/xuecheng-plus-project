package com.xuecheng.media;

import com.j256.simplemagic.ContentInfo;
import com.j256.simplemagic.ContentInfoUtil;
import com.j256.simplemagic.entries.MagicType;
import io.minio.*;
import io.minio.errors.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 测试minio的sdk
 */
public class MinioTest {
    // 客户端
    MinioClient minioClient =
            MinioClient.builder()
                    .endpoint("http://192.168.101.65:9000")
                    .credentials("minioadmin", "minioadmin")
                    .build();

    // 上传文件
    @Test
    public void test_upload() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

        // 通过拓展名得到媒资资源类型 mimeType
        // 根据拓展名去除mimeType
        ContentInfo extensionMatch = ContentInfoUtil.findExtensionMatch(".jpeg");
        String mimeType = MediaType.APPLICATION_OCTET_STREAM_VALUE; // 通用mimeType, 字节流
        if (extensionMatch != null) {
            mimeType = extensionMatch.getMimeType();
        }

        // 上传文件的参数信息
        UploadObjectArgs uploadObjectArgs = UploadObjectArgs.builder()
                .bucket("testbucket") // 桶
                .filename("E:\\Image\\1670049709213.jpg") // 指定本地文件路径
                .object("1670049709213.jpg") // 对象名
                .contentType(mimeType) // 设置媒体文件类型
                .build();

        minioClient.uploadObject(uploadObjectArgs);

    }

    // 删除文件
    @Test
    public void test_delete() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        RemoveObjectArgs removeObjectArgs =
                RemoveObjectArgs.builder()
                        .bucket("testbucket")
                        .object("1670049709213.jpg")
                        .build();

        // 删除文件
        minioClient.removeObject(removeObjectArgs);
    }

    // 查询文件
    @Test
    public void getFile() {
        GetObjectArgs getObjectArgs =
                GetObjectArgs.builder()
                        .bucket("testbucket")
                        .object("1670049709213.jpg")
                        .build();

        try {
            FilterInputStream inputStream = minioClient.getObject(getObjectArgs);
            FileOutputStream outputStream = new FileOutputStream(new File("E:\\test\\1670049709213.jpg"));
            IOUtils.copy(inputStream, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 校验文件的完整性对文件内容进行md5
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("E:\\Image\\1670049709213.jpg"));
            String source_md5 = DigestUtils.md5Hex(fileInputStream);
            FileInputStream fileInputStream1 = new FileInputStream(new File("E:\\test\\1670049709213.jpg"));
            String local_md5 = DigestUtils.md5Hex(fileInputStream1);
            if (source_md5.equals(local_md5)) {
                System.out.println("下载成功");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
