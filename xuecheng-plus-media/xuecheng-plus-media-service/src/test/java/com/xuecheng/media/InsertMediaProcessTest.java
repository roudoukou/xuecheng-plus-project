package com.xuecheng.media;

import com.xuecheng.media.mapper.MediaProcessMapper;
import com.xuecheng.media.model.po.MediaProcess;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class InsertMediaProcessTest {

    @Autowired
    MediaProcessMapper mediaProcessMapper;

    @Test
    public void selectList() {
        List<MediaProcess> mediaProcesses = mediaProcessMapper.selectList(null);
        mediaProcesses.forEach(System.out::println);
    }

    @Test
    public void insertMediaProcess() {
        MediaProcess mediaProcess = new MediaProcess();
        mediaProcess.setFileId("1234");
        mediaProcess.setFilename("123");
        mediaProcess.setBucket("123");
        mediaProcess.setStatus("123");
        mediaProcess.setCreateDate(LocalDateTime.now());
        mediaProcess.setFailCount(0);
        int insert = mediaProcessMapper.insert(mediaProcess);
        System.out.println("insert = " + insert);
    }
}
