package com.cjyong.pcw.cp.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Class created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2018/8/27
 * Time: 13:15
 * Description: 注入YML文件中个人的配置信息(prefix = cpconfig)
 */

@ConfigurationProperties("cpconfig")
@Data
public class CPConfig {

    private String deployUrl;                    //部署网址
    private String gitsecret;                   //Git webhook的密钥
    private String scriptLocation;             //Git update脚本位置
    private JWTConfig jwt;                       //JWT配置信息
    private DatasourceConfig datasource;        //数据库配置信息
    private QiniuConfig qiniu;                  //七牛云配置信息

    /**
     * 存储JWT相关配置信息
     *
     */
    @Data
    public static class JWTConfig {
        private String key;
        private long life;
    }

    /**
     * 存储数据库连接相关配置信息
     *
     */
    @Data
    public static class DatasourceConfig {
        private String role;
        private String name;
        private String password;
        private String driverClassName;
        private String url;
        private String sqlScriptEncoding;
        private DruidConfig druid;

        /**
         * 存储Druid相关的连接配置
         *
         */
        @Data
        public static class DruidConfig {
            private int maxActive;
            private int initialSize;
            private int minIdle;
            private long maxWait;
            private long timeBetweenEvictionRunsMillis;
            private long minEvictableIdleTimeMillis;
            private boolean poolPreparedStatement;
            private int maxPoolPreparedStatementPerConnectionSize;
        }
    }

    /**
     * 存储七牛云相关的配置信息
     */
    @Data
    public static class QiniuConfig {
        private String accessKey;
        private String secretKey;
        private String bucket;
        private String imageUrl;
    }
}
