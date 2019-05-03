package com.lswq.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@Configurable
@MapperScan("com.lswq.mapper")
public class MysqlPrimaryDataSourceConfig {

    @Value("${spring.datasource.driverClassName}")
    private String className;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String userName;

    @Value("${spring.datasource.password}")
    private String password;

    @Primary
    @Bean(destroyMethod = "close", initMethod = "init")
    public DruidDataSource mysqlDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(className);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setConnectionInitSqls(Collections.singleton("set names utf8mb4"));
        return dataSource;
    }

    @Bean(name = "mysqlTransactionManager")
    @Primary
    public DataSourceTransactionManager mysqlTransactionManager(@Qualifier("mysqlDataSource") DataSource mysqlDataSource) {
        return new DataSourceTransactionManager(mysqlDataSource);
    }

    @Bean(name = "mysqlSqlSessionFactory")
    @Primary
    public SqlSessionFactory mysqlSqlSessionFactory(@Qualifier("mysqlDataSource") DataSource mysqlDataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(mysqlDataSource);
        Resource[] mapperResource = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml");
        List<Resource> resources = Arrays.asList(mapperResource);
        bean.setMapperLocations(resources.toArray(new Resource[resources.size()]));
        bean.setTypeAliasesPackage("com.lswq.entity");
        bean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        bean.getObject().getConfiguration().setJdbcTypeForNull(JdbcType.NULL);
        return bean.getObject();
    }
    
}
