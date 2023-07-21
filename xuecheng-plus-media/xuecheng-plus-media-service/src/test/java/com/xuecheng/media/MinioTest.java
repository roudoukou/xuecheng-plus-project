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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    // 将分块文件上传到minio
    @Test
    public void uploadChunk() throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {


        for (int i = 0; i < 15; i++) {

            File file = new File("E:\\Video\\这么可爱真实抱歉\\chunk\\" + i);
            // 上传文件的参数信息
            UploadObjectArgs uploadObjectArgs = UploadObjectArgs
                    .builder()
                    .bucket("testbucket")
                    .filename(file.getPath())
                    .object("chunk/" + i)
                    .build();
            minioClient.uploadObject(uploadObjectArgs);
            System.out.println("文件分块" + i + "上传成功! ");
        }
    }

    // 调用minio接口合并分块
    @Test
    public void Merge() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        List<ComposeSource> sources = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            // 指定分块文件的信息
            ComposeSource composeSource = ComposeSource
                    .builder()
                    .bucket("testbucket")
                    .object("chunk/" + i)
                    .build();
            sources.add(composeSource);
        }

        /*List<ComposeSource> sources = Stream.iterate(0, i -> ++i).limit(15).map(
                i -> ComposeSource
                        .builder()
                        .bucket("testbucket")
                        .object("chunk/" + i)
                        .build()
        ).collect(Collectors.toList());*/

        ComposeObjectArgs composeObjectArgs = ComposeObjectArgs
                .builder()
                .bucket("testbucket")
                .object("这么可爱真是抱歉.mp4")
                .sources(sources)
                .build();
        // 合并文件, minio默认的分块文件大小是5M
        minioClient.composeObject(composeObjectArgs);
    }

    // 批量清理分块文件

}
