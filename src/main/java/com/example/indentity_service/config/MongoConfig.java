package com.example.indentity_service.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.net.ssl.SSLContext;

@Configuration
public class MongoConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Bean
    public MongoClient mongoClient() {
        try {
            // Tạo connection string
            ConnectionString connectionString = new ConnectionString(mongoUri);

            MongoClientSettings.Builder settingsBuilder = MongoClientSettings.builder()
                    .applyConnectionString(connectionString);

            // Cấu hình SSL không verify certificate
            configureSSL(settingsBuilder);

            return MongoClients.create(settingsBuilder.build());
        } catch (Exception e) {
            throw new RuntimeException("Failed to create MongoClient: " + e.getMessage(), e);
        }
    }

    private void configureSSL(MongoClientSettings.Builder settingsBuilder) {
        try {
            // Tạo TrustManager chấp nhận tất cả certificates (chỉ dùng cho development)
            javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[]{
                new javax.net.ssl.X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                    }
                    public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                    }
                }
            };

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            settingsBuilder.applyToSslSettings(builder -> {
                builder.enabled(true);
                builder.context(sslContext);
                builder.invalidHostNameAllowed(true);
            });

            System.out.println("SSL configured without certificate verification");
        } catch (Exception e) {
            System.err.println("Error configuring SSL: " + e.getMessage());
            // Fallback cuối cùng
            settingsBuilder.applyToSslSettings(builder -> {
                builder.enabled(true);
                builder.invalidHostNameAllowed(true);
            });
        }
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), database);
    }
}

