package com.example.jackson.version2;

import com.alibaba.fastjson.JSONObject;
import com.example.jackson.common.ClassFactory;
import com.example.jackson.common.JsonConst;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

@Slf4j
public class BaseCodeRepoTest {

    @Test
    public void version2Json1Test() {
        ObjectMapper mapper = new ObjectMapper();
        // 注入多态解析类
        ClassFactory.BASE_CODE_REPOS.forEach(mapper::registerSubtypes);

        String jsonString = JsonConst.JSON1;
        log.info("Json1字符串为: {}", jsonString);

        try {
            List<BaseCodeRepo> baseCodeRepos = mapper.readValue(jsonString, new TypeReference<List<BaseCodeRepo>>() {
            });
            baseCodeRepos.forEach(item -> log.info(item.getType() + "对象信息为: {}", JSONObject.toJSONString(item)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void version2Json2Test() {
        ObjectMapper mapper = new ObjectMapper();
        // 注入多态解析类
        ClassFactory.BASE_CODE_REPOS.forEach(mapper::registerSubtypes);

        String jsonString = JsonConst.JSON2;
        log.info("Json2字符串为: {}", jsonString);

        try {
            GithubRepo githubRepo = (GithubRepo) mapper.readValue(jsonString, BaseCodeRepo.class);
            log.info("GITHUB对象信息为: {}", JSONObject.toJSONString(githubRepo));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}