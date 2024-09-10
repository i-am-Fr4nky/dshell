package com.x5.bigdata.fr4nky.example.dshell.config;

import com.x5.bigdata.fr4nky.example.dshell.entity.app.BigProduct;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryApp",
        transactionManagerRef = "transactionManagerApp",
        basePackages = {"com.x5.bigdata.fr4nky.example.dshell.repository.app"}
)
public class PostgresAppConfig {

    @Primary
    @Bean(name = "postgresDataSourceApp")
    @ConfigurationProperties("spring.datasource.app")
    public DataSource postgresDataSourcePromo() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "entityManagerFactoryApp")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPromo(
            EntityManagerFactoryBuilder builder,
            @Value("${spring.datasource.app.hibernate.default_schema}") String defaultSchema,
            @Qualifier("postgresDataSourceApp") DataSource dataSource) {

        var entityManagerFactoryBuilder =  builder
                .dataSource(dataSource)
                .packages("com.x5.bigdata.fr4nky.example.dshell.entity.app")
                .persistenceUnit("ApppPersistenceUnit")
                .build();
        entityManagerFactoryBuilder.getJpaPropertyMap().put("hibernate.default_schema", defaultSchema);
        return entityManagerFactoryBuilder;
    }

    @Primary
    @Bean(name = "transactionManagerApp")
    public PlatformTransactionManager transactionManagerPromo(
            @Qualifier("entityManagerFactoryApp") EntityManagerFactory entityManagerFactory) {

        return new JpaTransactionManager(entityManagerFactory);
    }
}
