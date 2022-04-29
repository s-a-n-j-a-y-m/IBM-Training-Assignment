package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ItemEntity;
import com.example.demo.proxy.CouponDto;
import com.example.demo.proxy.CouponProxy;
import com.example.demo.service.ItemService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
public class ItemController {
	
	private final CouponProxy couponProxy;
	private final ItemService itemService;
	@PostMapping("/items")
	@CircuitBreaker(name = "COUPON_SERVICE_CIRCUIT_BREAKER",fallbackMethod = "couponFallBack")
	public ResponseEntity<?> createItem(@RequestBody ItemEntity itemEntity)
	{
		CouponDto couponDto=couponProxy.getCouponByCode(itemEntity.getCouponCode());
		log.info("coupon proxy called");
		itemEntity.setDiscountCodeApplied(couponDto.getCouponCode());
		itemEntity.setDiscountReceived(couponDto.getDiscountAmount());
		itemEntity.setPriceAfterDiscount(itemEntity.getActualPrice()-couponDto.getDiscountAmount());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(itemService.createItem(itemEntity));
	}
	
	
	public ResponseEntity<?> couponFallBack(Exception e)
	{
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("COUPON-WS is down try after some time.!!!");
	}

}
