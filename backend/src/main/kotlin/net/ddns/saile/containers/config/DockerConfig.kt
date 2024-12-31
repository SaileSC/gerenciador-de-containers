package net.ddns.saile.containers.config

import com.github.dockerjava.api.DockerClient
import com.github.dockerjava.core.DefaultDockerClientConfig
import com.github.dockerjava.core.DockerClientConfig
import com.github.dockerjava.core.DockerClientImpl
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient
import com.github.dockerjava.transport.DockerHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy
import java.time.Duration

@Configuration
class DockerConfig{
    @Bean
    fun buildDockerClient():DockerClient{
        val clientConfig:DockerClientConfig = DefaultDockerClientConfig.createDefaultConfigBuilder()
            .build()

        val httpClient:DockerHttpClient = ApacheDockerHttpClient.Builder()
            .dockerHost(clientConfig.dockerHost)
            .sslConfig(clientConfig.sslConfig)
            .maxConnections(100)
            .connectionTimeout(Duration.ofSeconds(30))
            .responseTimeout(Duration.ofSeconds(45))
            .build()

        return DockerClientImpl.getInstance(clientConfig, httpClient);
    }
}