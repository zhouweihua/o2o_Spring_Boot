package com.zwh.o2o.config.dao;

import java.beans.PropertyVetoException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@MapperScan("com.zwh.o2o.dao")
public class DataSourceConfiguration {

	@Bean(name = "dataSource")
	public ComboPooledDataSource createDataSource() throws PropertyVetoException {
		ComboPooledDataSource pool = new ComboPooledDataSource();
		pool.setDriverClass("com.mysql.jdbc.Driver");
		pool.setJdbcUrl("jdbc:mysql://localhost:3306/o2o?useUnicode=true&characterEncoding=utf8&useSSL=false");
		pool.setUser("root");
		pool.setPassword("12345678");
		
		pool.setMaxPoolSize(30);
		pool.setMinPoolSize(10);
		pool.setAutoCommitOnClose(false);
		pool.setCheckoutTimeout(100000);
		pool.setAcquireRetryAttempts(2);
		return pool;
	}
    
	
}
