package com.stc.assessment.systemdesign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SystemDesignApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemDesignApplication.class, args);
		log.info("SystemDesignApplication Is Running");
	}

}
