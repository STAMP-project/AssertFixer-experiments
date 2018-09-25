package com.cjyong.pcw.cp;

import com.cjyong.pcw.cp.conf.ApplicationInfo;
import com.cjyong.pcw.cp.main.dao.UserRepository;
import com.cjyong.pcw.cp.main.entity.enums.UserID;
import com.cjyong.pcw.cp.main.service.BlogService;
import com.cjyong.pcw.cp.main.service.GithubService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CPApplication {

	public static void main(String[] args) {
		SpringApplication.run(CPApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository, BlogService blogService, GithubService githubService) {
		return (args) -> {
			ApplicationInfo.setHusband(userRepository.findById(UserID.HUSBAND.getId()).orElse(null));
			ApplicationInfo.setWife(userRepository.findById(UserID.WIFE.getId()).orElse(null));
			blogService.initCache();
			githubService.updateDirectory();
		};
	}
}
