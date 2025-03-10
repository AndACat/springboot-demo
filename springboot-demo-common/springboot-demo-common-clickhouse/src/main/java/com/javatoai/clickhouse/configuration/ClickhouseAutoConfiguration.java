package com.javatoai.clickhouse.configuration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 *
 */
@AutoConfiguration
@Import(ClickhouseConfiguration.ClickHouse.class)
public class ClickhouseAutoConfiguration {

}
