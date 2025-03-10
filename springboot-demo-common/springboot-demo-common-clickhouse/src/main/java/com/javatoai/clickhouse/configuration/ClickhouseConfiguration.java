package com.javatoai.clickhouse.configuration;

import com.clickhouse.jdbc.ClickHouseDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 */
abstract class ClickhouseConfiguration {
    @Configuration(proxyBeanMethods = false)
    @ConditionalOnClass(com.clickhouse.jdbc.ClickHouseDataSource.class)
    @ConditionalOnMissingBean(com.clickhouse.jdbc.ClickHouseDataSource.class)
    static class ClickHouse {
        @Bean
        @ConfigurationProperties(prefix = "spring.datasource.clickhouse")
        public DataSourceProperties clickHouseDataSourceProperties() {
            // 这里返回的 DataSourceProperties 将被绑定到 "spring.datasource.clickhouse.*"
            return new DataSourceProperties();
        }
        @Bean
        public com.clickhouse.jdbc.ClickHouseDataSource clickHouseDataSource(@Qualifier("clickHouseDataSourceProperties") DataSourceProperties dataSourceProperties) {
            try {
                // 把 username、password 等放进 Properties
                Properties props = new Properties();
                // 如果你的 DataSourceProperties 里定义了 getUsername() / getPassword()
                // 需要确保它不为 null 后再set
                if (dataSourceProperties.getUsername() != null) {
                    props.setProperty("user", dataSourceProperties.getUsername());
                }
                if (dataSourceProperties.getPassword() != null) {
                    props.setProperty("password", dataSourceProperties.getPassword());
                }

                // 如果还有其他参数，比如socket_timeout、connect_timeout等，也可在此设置
                // props.setProperty("socket_timeout", "30000");
                // props.setProperty("something_else", "xxx");

                // 最终将 props 传给第二个参数
                return new ClickHouseDataSource(dataSourceProperties.getUrl(), props);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        @Bean(name = "clickhouseJdbcTemplate")
        public JdbcTemplate clickhouseJdbcTemplate(@Qualifier("clickHouseDataSource") DataSource dataSource) {
            return new JdbcTemplate(dataSource);
        }
    }
}
