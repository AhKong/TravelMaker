package com.cafe24.travelMaker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cafe24.travelMaker.service.StorageService;

@SpringBootApplication
public class TravelMaker1Application {

	public static void main(String[] args) {
		SpringApplication.run(TravelMaker1Application.class, args);
	}
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			//파일 업로드 없을 경우 폴더 생성
			storageService.init();
		};
	}

}
