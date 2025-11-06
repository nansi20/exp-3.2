package com.example.partb;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.example.partb")
public class HibernateConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        
        // ✅ FIXED LINE: added allowPublicKeyRetrieval=true to resolve connection issue
        ds.setUrl("jdbc:mysql://localhost:3306/testdb?allowPublicKeyRetrieval=true&useSSL=false");
        
        ds.setUsername("root");
        ds.setPassword("navsi2520@"); // ✅ make sure this is your actual MySQL root password
        return ds;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("com.example.partb");

        Properties props = new Properties();
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        props.put("hibernate.hbm2ddl.auto", "update");
        props.put("hibernate.show_sql", "true");

        factoryBean.setHibernateProperties(props);
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager tx = new HibernateTransactionManager();
        tx.setSessionFactory(sessionFactory().getObject());
        return tx;
    }
}
