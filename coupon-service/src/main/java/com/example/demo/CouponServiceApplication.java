package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.demo.model.CouponEntity;
import com.example.demo.repo.CouponRepository;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
@EnableEurekaClient
public class CouponServiceApplication {
	private final CouponRepository couponRepository;

	public static void main(String[] args) {
		SpringApplication.run(CouponServiceApplication.class, args);
	}

	@PostConstruct
	public void initDate() {
		List<CouponEntity> list = Stream.of(new CouponEntity(1, "CODE-1", 12.9, "2ndMay'22"),
				new CouponEntity(2, "CODE-2", 10.9, "12ndMay'22"), new CouponEntity(3, "CODE-3", 19.9, "22ndMay'22"))
				.collect(Collectors.toList());

		couponRepository.saveAll(list);
	}

}