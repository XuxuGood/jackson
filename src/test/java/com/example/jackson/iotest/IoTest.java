package com.example.jackson.iotest;

import com.example.jackson.util.IoUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author xiaoxuxuy
 * @date 2021/7/4 5:51 下午
 */
@Slf4j
public class IoTest {

    @Test
    public void ioTest() {
        String json1String = IoUtil.readFileAsString("json1.json");
        log.info("Json1字符串为: {}", json1String);

        String json2String = IoUtil.readFileAsString("json2.json");
        log.info("Json2字符串为: {}", json2String);
    }

}
