package com.zwh.o2o.config.dao;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class SessionFactoryConfiguration {
	@Autowired
	private DataSource dataSource;

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		// 扫描mybatis配置文件
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		// 扫描相关mapper文件
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "/mapper/**.xml";
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
		// 调用dataSource
		sqlSessionFactoryBean.setDataSource(dataSource);
		// 映射实体类
		sqlSessionFactoryBean.setTypeAliasesPackage("com.zwh.o2o.entity");
		return sqlSessionFactoryBean;
	}
}
