package com.xuecheng.media;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 测试大文件上传方法
 */
public class BigFileTest {

    // 分块测试
    @Test
    public void testChunk() throws IOException {
        // 源文件
        File sourFile = new File("E:\\Video\\这么可爱真实抱歉\\这么可爱真是抱歉 feat.ちゅーたん (CV_ 早見沙織)／HoneyWorks-niconico 1080P-1080P+ .mp4");
        // 分块文件存储路径
        String chunkFilePath = "E:\\Video\\这么可爱真实抱歉\\chunk\\";
        // 分块文件大小
        int chunkSize = 1024 * 1024 * 5; // 1 MB = 1024 KB = 1024 * 1024 字节 B
        // 分块文件个数
        int chunkNum = (int) Math.ceil(sourFile.length() * 1.0 / chunkSize);
        // 使用流从源文件读数据, 向分块文件中写数据
        RandomAccessFile raf_r = new RandomAccessFile(sourFile, "r");
        // 缓冲区
        byte[] bytes = new byte[1024];
        for (int i = 0; i < chunkNum; i++) {
            File chunkFile = new File(chunkFilePath + i);
            // 分块文件写入流
            RandomAccessFile raf_rw = new RandomAccessFile(chunkFile, "rw");
            int len = -1;
            while ((len = raf_r.read(bytes)) != -1) {
                raf_rw.write(bytes, 0, len);
                if (chunkFile.length() >= chunkSize) {
                    break;
                }
            }
            raf_rw.close();
        }
        raf_r.close();
    }

    @Test
    public void testMerge() throws IOException {
        // 快文件目录
        File chunkFolder = new File("E:\\Video\\这么可爱真实抱歉\\chunk");
        // 源文件
        File sourceFile = new File("E:\\Video\\这么可爱真实抱歉\\这么可爱真是抱歉 feat.ちゅーたん (CV_ 早見沙織)／HoneyWorks-niconico 1080P-1080P+ .mp4");
        // 合并后的文件
        File mergeFile = new File("E:\\Video\\这么可爱真实抱歉\\这么可爱真实抱歉_2.mp4");

        // 取出所有分块文件
        File[] files = chunkFolder.listFiles();

        // 将数组转成list
        List<File> fileList = Arrays.asList(files);

        // 对分块文件排序
        Collections.sort(fileList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return Integer.parseInt(o1.getName()) - Integer.parseInt(o2.getName());
            }
        });

        // 向合并文件写的流
        RandomAccessFile raf_rw = new RandomAccessFile(mergeFile, "rw");
        // 缓存区
        byte[] bytes = new byte[1024];
        // 遍历分块文件, 向合并的文件写
        for (File file : fileList) {
            // 读分块的流
            RandomAccessFile rad_r = new RandomAccessFile(file, "r");
            int len = -1;
            while ((len = rad_r.read(bytes)) != -1) {
                raf_rw.write(bytes, 0, len);
            }
            rad_r.close();
        }
        raf_rw.close();

        // 合并文件完成后对合并的文件校验
        FileInputStream fileInputStream_merge = new FileInputStream(mergeFile);
        FileInputStream fileInputStream_source = new FileInputStream(sourceFile);
        String md5_merge = DigestUtils.md5Hex(fileInputStream_merge);
        String md5_source = DigestUtils.md5Hex(fileInputStream_source);
        if (md5_merge.equals(md5_source)) {
            System.out.println("文件合并成功");
        }
    }

    // 这段是自己写的,上面那段才是跟着视频敲的
    // 将分块进行合并
    @Test
    public void testMergeByMySelf() throws IOException {
        // 分片路径
        String chunkFilePath = "E:\\Video\\这么可爱真实抱歉\\chunk\\";
        File sourceFilePath = new File(chunkFilePath);

        String targetFilePath = "E:\\Video\\这么可爱真实抱歉\\这么可爱真实抱歉_2.mp4";
        File targetFile = new File(targetFilePath);

        // 获取文件名, 此时是乱序的
        String[] chunkStringList = sourceFilePath.list();
        List<String> chunkList = Arrays.asList(chunkStringList);

        /*Collections.sort(chunkList, (o1, o2) -> {
            return Integer.valueOf(o1) - Integer.valueOf(o2);
        });*/
        Collections.sort(chunkList, Comparator.comparingInt(Integer::valueOf));

        RandomAccessFile rw_randomAccessFile = new RandomAccessFile(targetFile, "rw");
        for (String chunk : chunkList) {
            // System.out.println(chunk);
            String chunkPath = chunkFilePath + chunk;
            File file = new File(chunkPath);
            // 先读后写
            RandomAccessFile r_randomAccessFile = new RandomAccessFile(file, "r");
            int len = -1;
            byte[] bytes = new byte[1024];

            while ((len = r_randomAccessFile.read(bytes)) != -1) {
                rw_randomAccessFile.write(bytes, 0, len);
            }
            r_randomAccessFile.close();
        }
        rw_randomAccessFile.close();

        // 这不轻轻松松
        File thisFile = new File("E:\\Video\\这么可爱真实抱歉\\这么可爱真是抱歉 feat.ちゅーたん (CV_ 早見沙織)／HoneyWorks-niconico 1080P-1080P+ .mp4");
        InputStream inputStream1 = new FileInputStream(thisFile);
        InputStream inputStream2 = new FileInputStream(targetFile);
        String md5Hex1 = DigestUtils.md5Hex(inputStream1);
        String md5Hex2 = DigestUtils.md5Hex(inputStream2);
        if (md5Hex1.equals(md5Hex2)) {
            System.out.println("文件合并成功");
        }
    }
}
