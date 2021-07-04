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
                // 指定被扫描的包名
                .setUrls(ClasspathHelper.forPackage(PACKAGE_PATH))
                // 允许getAllTypes获取所有Object的子类, 不设置为false则 getAllTypes 会报错, 默认为true
                .setScanners(new SubTypesScanner(false)
                        // 设置方法参数名称扫描器, 否则调用 getConstructorParamNames 会报错
                        , new MethodParameterNamesScanner()
                        // 设置方法注解扫描器, 否则 getConstructorsAnnotatedWith,getMethodsAnnotatedWith 会报错
                        , new MethodAnnotationsScanner()
                        // 设置 member 扫描器, 否则 getMethodUsage 会报错, 不推荐使用,有可能会报错 Caused by: java.lang.ClassCastException: javassist.bytecode.InterfaceMethodrefInfo cannot be cast to javassist.bytecode.MethodrefInfo
                        , new MemberUsageScanner()
                        // 设置类注解扫描器, 否则 getTypesAnnotatedWith 会报错
                        , new TypeAnnotationsScanner()));
        // 获取继承了BaseCodeRepo的所有类
        Set<Class<? extends BaseCodeRepo>> codeRepoClassSet = reflections.getSubTypesOf(BaseCodeRepo.class);
        BASE_CODE_REPOS.addAll(codeRepoClassSet);
    }

}
