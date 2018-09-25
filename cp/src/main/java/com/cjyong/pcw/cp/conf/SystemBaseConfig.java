package com.cjyong.pcw.cp.conf;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.cjyong.pcw.cp.conf.interceptor.TokenInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/11/28
 * Time: 16:27
 * Description: CrossDomain config class
 */

@Configuration
@EnableConfigurationProperties(CPConfig.class)
@EnableSwagger2
@Slf4j
@EnableScheduling
@EnableTransactionManagement
@EnableJpaRepositories(value="com.cjyong.pcw.cp.main.dao",entityManagerFactoryRef = "emf")
@EntityScan("com.cjyong.pcw.cp.main.entity")
public class SystemBaseConfig implements WebMvcConfigurer {

    private CPConfig cpConfig;
    private TokenInterceptor tokenInterceptor;

    @Autowired
    public SystemBaseConfig(CPConfig cpConfig, TokenInterceptor tokenInterceptor) {
        this.cpConfig = cpConfig;
        this.tokenInterceptor = tokenInterceptor;
    }

    /**
     * Add interceptor config.
     *
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns(com.cjyong.pcw.cp.conf.ApiInfo.ablumApi + "/**")
                .addPathPatterns(com.cjyong.pcw.cp.conf.ApiInfo.activityApi + "/**")
                .addPathPatterns(com.cjyong.pcw.cp.conf.ApiInfo.dailySentenceApi + "/**");
    }

    /**
     * Add default path to swagger-ui.html
     *
     * @param registry
     */
    @Override
    public void addViewControllers( ViewControllerRegistry registry ) {
        registry.addViewController( "" ).setViewName( "redirect:/swagger-ui.html" );
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE );
    }

    /**
     * Simple cross domain filter
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

    /**
     * Initialize System base information
     * @return
     */
    @Bean
    public boolean applicationInfoInit(){
        log.info("Start initialize system variables setting!");
        ApplicationInfo.setJwtKey(cpConfig.getJwt().getKey());
        ApplicationInfo.setJwtLife(cpConfig.getJwt().getLife());
        ApplicationInfo.setQiniuAccessKey(cpConfig.getQiniu().getAccessKey());
        ApplicationInfo.setQiniuSecretKey(cpConfig.getQiniu().getSecretKey());
        ApplicationInfo.setQinniuBucket(cpConfig.getQiniu().getBucket());
        ApplicationInfo.setPhotosBaseUrl(cpConfig.getQiniu().getImageUrl());
        log.info("Finished initialize system variables setting!");
        return true;
    }

    /**
     * configure swagger
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList();
        tokenPar.name("x-access-token").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .forCodeGeneration(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cjyong.pcw.cp.main.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }

    //ADD description for swagger2
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Springfox Restful API")
                .description("This is restful API for pcw project.")
                .contact(new Contact("cjyong", "https://github.com/cai123nb/pcw", "2686600303@qq.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/cai123nb/gp/blob/master/LICENSE")
                .termsOfServiceUrl(cpConfig.getDeployUrl())
                .version("2.0")
                .build();
    }

    //Configure database setting
    /**
     * inject druid of datasource
     *
     * @return
     */
    @Bean
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(cpConfig.getDatasource().getUrl());
        dataSource.setUsername(cpConfig.getDatasource().getName());
        dataSource.setPassword(cpConfig.getDatasource().getPassword());
        dataSource.setDriverClassName(cpConfig.getDatasource().getDriverClassName());
        dataSource.setInitialSize(cpConfig.getDatasource().getDruid().getInitialSize());
        dataSource.setMinIdle(cpConfig.getDatasource().getDruid().getMinIdle());
        dataSource.setMaxWait(cpConfig.getDatasource().getDruid().getMaxWait());
        dataSource.setMaxActive(cpConfig.getDatasource().getDruid().getMaxActive());
        dataSource.setMinEvictableIdleTimeMillis(cpConfig.getDatasource().getDruid().getMinEvictableIdleTimeMillis());
        dataSource.setPoolPreparedStatements(cpConfig.getDatasource().getDruid().isPoolPreparedStatement());
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(cpConfig.getDatasource().getDruid().getMaxPoolPreparedStatementPerConnectionSize());
        try{
            dataSource.setFilters("stat,wall");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return dataSource;
    }

    /**
     * Inject entityFactory
     *
     * @return
     */
    @Bean(name = "emf")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());;
        entityManagerFactoryBean.setPackagesToScan("com.cjyong.pcw.cp.main.entity");
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties jpaProperties = new Properties();
        jpaProperties.put(org.hibernate.cfg.Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
        jpaProperties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "update");
        jpaProperties.put(org.hibernate.cfg.Environment.SHOW_SQL, true);
        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }

    /**
     * Set druid config infos.
     *
     * @return
     */
    @Bean
    public static ServletRegistrationBean druidStatViewServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        servletRegistrationBean.addInitParameter("*","127.0.0.1");
        servletRegistrationBean.addInitParameter("deny","192.168.1.173");
        servletRegistrationBean.addInitParameter("loginUsername","cjyong");
        servletRegistrationBean.addInitParameter("loginPassword","cjyong");
        servletRegistrationBean.addInitParameter("resetEnable","true");
        return servletRegistrationBean;
    }

    /**
     * Add Filter
     *
     * @return
     */
    @Bean
    public static FilterRegistrationBean druidStatFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

    /**
     * Add jpa transaction
     *
     * @return
     */
    @Bean(name = "transactionManager")
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new JpaTransactionManager();
    }


}