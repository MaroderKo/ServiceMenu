package me.Dex.ServiceMenu;

import me.Dex.ServiceMenu.Domain.AdmissionDoc;
import me.Dex.ServiceMenu.Service.AdmissionDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "me.Dex.ServiceMenu")
@EntityScan("me.Dex.ServiceMenu.Domain")
@EnableJpaAuditing
@EnableJpaRepositories("me.Dex.ServiceMenu.Repository")
public class ServiceMenuApplication {

	@Autowired
	AdmissionDocService service;
	public static void main(String[] args) {
		SpringApplication.run(ServiceMenuApplication.class, args);
	}


}
