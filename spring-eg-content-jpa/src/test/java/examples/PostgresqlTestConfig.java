package examples;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.content.jpa.config.EnableJpaStores;
import org.springframework.content.jpa.config.JpaStoreConfigurer;
import org.springframework.content.jpa.config.JpaStoreProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages="examples")	 	// Tell Spring Data JPA where to find Repositories
@EnableTransactionManagement
@EnableJpaStores
public class PostgresqlTestConfig {

    @Value("#{environment.POSTGRESQL_URL}")
    private String postgresqlUrl;

    @Value("#{environment.POSTGRESQL_USERNAME}")
    private String postgresqlUsername;

    @Value("#{environment.POSTGRESQL_PASSWORD}")
    private String postgresqlPassword;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
            ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl(postgresqlUrl);
        ds.setUsername(postgresqlUsername);
        ds.setPassword(postgresqlPassword);
        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.POSTGRESQL);
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("examples");  	// Tell Hibernate where to find Entities
        factory.setDataSource(dataSource());

        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return txManager;
    }

    @Value("/org/springframework/content/jpa/schema-drop-postgresql.sql")
    private Resource dropReopsitoryTables;

    @Value("/org/springframework/content/jpa/schema-postgresql.sql")
    private Resource dataReopsitorySchema;

    @Bean
    DataSourceInitializer datasourceInitializer() {
        ResourceDatabasePopulator databasePopulator =
                new ResourceDatabasePopulator();

        databasePopulator.addScript(dropReopsitoryTables);
        databasePopulator.addScript(dataReopsitorySchema);
        databasePopulator.setIgnoreFailedDrops(true);

        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource());
        initializer.setDatabasePopulator(databasePopulator);

        return initializer;
    }

    @Bean
    public JpaStoreConfigurer configurer() {
        return new JpaStoreConfigurer() {
            @Override
            public void configure(JpaStoreProperties store) {
                store.commitTimeout(120);
            }
        };
    }
}
