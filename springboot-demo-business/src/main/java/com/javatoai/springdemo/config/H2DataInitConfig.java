package com.javatoai.springdemo.config;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.javatoai.springdemo.utils.ApplicationContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.util.List;

/**
 * 初始化h2数据库
 */
@Slf4j
@Service
// DataSource创建完后才初始化此类
@AutoConfigureAfter(DataSource.class)
@Profile("dev")
public class H2DataInitConfig implements CommandLineRunner {
    // 初始化sql
    private static final String SCHEMA = "classpath:db/schema.sql";
    private static final List<String> INIT_DATA_LIST = List.of(
            "classpath:db/data.sql"
    );

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        // 文件锁，防止重复初始化
        log.info(">>> 开始初始化h2数据");
        if(ApplicationContextUtil.APPLICATION_CONTEXT == null){
            log.error("初始化h2数据失败, application context为null");
            return;
        }
        if (StrUtil.isNotBlank(SCHEMA)) {
            // 加载资源文件
            Resource schemaSql = ApplicationContextUtil.APPLICATION_CONTEXT.getResource(SCHEMA);
            if(schemaSql.contentLength() != 0L){
                // 手动执行SQL语句
                ScriptUtils.executeSqlScript(dataSource.getConnection(), schemaSql);
            }
            // 初始化数据
            if (CollUtil.isNotEmpty(INIT_DATA_LIST)) {
                for (String initData : INIT_DATA_LIST) {
                    Resource initDataSql = ApplicationContextUtil.APPLICATION_CONTEXT.getResource(initData);
                    if(initDataSql.contentLength() != 0L){
                        ScriptUtils.executeSqlScript(dataSource.getConnection(), initDataSql);
                    }
                }
            }
        }
        log.info(">>> 结束初始化h2数据");
    }
}
