package com.recipe.core.config;

import com.zaxxer.hikari.HikariDataSource;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = { "com.recipe.core.repository" })
public class PersistenceConfig {

    @Value("${hikari.driverclassName}")
    private String driverClassName;

    @Value("${hikari.url}")
    private String jdbcUrl;

    @Value("${hikari.username}")
    private String userName;

    @Value("${hikari.password}")
    private String password;

    @Value("${hikari.pool.size}")
    private int poolSize;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        final HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setMaximumPoolSize(poolSize);
        hikariDataSource.setDriverClassName(driverClassName);
        hikariDataSource.setJdbcUrl(jdbcUrl);
        hikariDataSource.setUsername(userName);
        hikariDataSource.setPassword(password);
        return hikariDataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setPrepareConnection(true);
        hibernateJpaVendorAdapter.setDatabase(Database.H2);
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager();
    }

    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:db-changelog.xml");
        liquibase.setDataSource(dataSource());
        return liquibase;
    }
}
