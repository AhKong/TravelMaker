package com.cafe24.travelMaker;

import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cafe24.travelMaker.service.StorageService;

@SpringBootApplication
public class TravelMaker1Application {

	private final static Logger logger =LoggerFactory.getLogger(SpringBootApplication.class);
	public static void main(String[] args) {
		logger.info("로거 출력 - {}","값");
		logger.error("로거 출력 - {}","값");
		logger.debug("로거 출력 - {}","값");
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
