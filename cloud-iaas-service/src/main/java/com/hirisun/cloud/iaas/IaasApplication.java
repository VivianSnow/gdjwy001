package com.hirisun.cloud.iaas;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.hirisun.cloud"})
@EnableDiscoveryClient
@MapperScan("com.hirisun.cloud.iaas.mapper")
@EnableFeignClients("com.hirisun.cloud.api.*")
public class IaasApplication {

	public static void main(String[] args) {
		SpringApplication.run(IaasApplication.class,args);

	}
}
