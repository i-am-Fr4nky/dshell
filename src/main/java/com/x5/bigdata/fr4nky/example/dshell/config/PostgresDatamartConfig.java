//package com.x5.bigdata.fr4nky.example.dshell.config;
//
//import jakarta.persistence.EntityManagerFactory;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import javax.sql.DataSource;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "entityManagerFactoryDatamart",
//        transactionManagerRef = "transactionManagerDatamart",
//        basePackages = {"com.x5.bigdata.fr4nky.example.dshell.entity.datamart"}
//)
//public class PostgresDatamartConfig {
//
//    @Bean(name = "postgresDataSourceDatamart")
//    @ConfigurationProperties("spring.datasource.datamart")
//    public DataSource postgresDataSourceDatamart() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "entityManagerFactoryDatamart")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryDatamart(
//            EntityManagerFactoryBuilder builder,
//            @Value("${spring.datasource.datamart.hibernate.default_schema}") String defaultSchema,
//            @Qualifier("postgresDataSourceDatamart") DataSource dataSource) {
//
//        var entityManagerFactoryBuilder = builder
//                .dataSource(dataSource)
//                .packages("com.x5.bigdata.bdsp.portal.promo.domain.datamart")
//                .persistenceUnit("DatamartPersistenceUnit")
//                .build();
//        entityManagerFactoryBuilder.getJpaPropertyMap().put("hibernate.default_schema", defaultSchema);
//        return entityManagerFactoryBuilder;
//    }
//
//    @Bean(name = "transactionManagerDatamart")
//    public PlatformTransactionManager transactionManagerDatamart(
//            @Qualifier("entityManagerFactoryDatamart") EntityManagerFactory entityManagerFactory) {
//
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//}
