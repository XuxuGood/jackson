package com.example.jackson.common;

import com.example.jackson.version2.BaseCodeRepo;
import org.apache.commons.compress.utils.Lists;
import org.reflections.Reflections;
import org.reflections.scanners.MemberUsageScanner;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.MethodParameterNamesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * 多态工厂
 *
 * @author xiaoxuxuy
 * @date 2021/6/18 11:00 下午
 */
@Component
public class ClassFactory {

    private static final String PACKAGE_PATH = "com.example.jackson.version2";

    public static List<Class<? extends BaseCodeRepo>> BASE_CODE_REPOS = Lists.newArrayList();

    static {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage(PACKAGE_PATH))
                .setScanners(new SubTypesScanner(false)
                        , new MethodParameterNamesScanner()
                        , new MethodAnnotationsScanner()
                        , new MemberUsageScanner()
                        , new TypeAnnotationsScanner()));
        // 获取继承了BaseCodeRepo的所有类
        Set<Class<? extends BaseCodeRepo>> codeRepoClassSet = reflections.getSubTypesOf(BaseCodeRepo.class);
        BASE_CODE_REPOS.addAll(codeRepoClassSet);
    }

}
