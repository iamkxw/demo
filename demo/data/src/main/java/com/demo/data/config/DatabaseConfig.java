package com.demo.data.config;

import com.demo.common.config.ConnectionSetting;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.demo.data.repository")
@EnableTransactionManagement
@EnableSpringDataWebSupport
public class DatabaseConfig {

    @Autowired
    ConnectionSetting connectionSetting;

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName(connectionSetting.getDriver());
        dataSource
                .setUrl(connectionSetting.getUrl()
                        + "?useUnicode=true&characterEncoding=utf8&autoReconnect=true&rewriteBatchedStatements=TRUE&zeroDateTimeBehavior=convertToNull");
        dataSource.setUsername(connectionSetting.getUsername());
        dataSource.setPassword(connectionSetting.getPassword());
        dataSource.setTestWhileIdle(true); // 空闲时允许检测DB链接
        dataSource.setTestOnBorrow(true); // 获取链接时进行有效性检查
        dataSource.setValidationQuery("SELECT 1"); // 数据库链接有效性检查
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        //设置数据库类型
        vendorAdapter.setDatabase(Database.MYSQL);
        //是否自动建表
        vendorAdapter.setGenerateDdl(false);
        //是否打印sql语句
        vendorAdapter.setShowSql(true);
        return vendorAdapter;
    }

    @Bean
    public JpaDialect jpaDialect() {
        return new HibernateJpaDialect();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(dataSource());
        lef.setJpaVendorAdapter(jpaVendorAdapter());
        lef.setPackagesToScan("com.demo.data.domain");
        lef.setJpaDialect(jpaDialect());
        return lef;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return jpaTransactionManager;
    }
}
