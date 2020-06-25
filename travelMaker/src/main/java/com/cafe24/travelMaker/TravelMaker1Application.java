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
			
		SpringApplication.run(TravelMaker1Application.class, args);
		logger.info("로거 출력 - {}","값");
		/* try - catch 문에서 에러 더 정확한 에러를 확인하고 싶을때 이걸루 고고 */
		logger.error("로거 출력 - {}","값");
		logger.debug("로거 출력 - {}","값");
	}
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			//파일 업로드 없을 경우 폴더 생성
			storageService.init();
		};
	}

}
