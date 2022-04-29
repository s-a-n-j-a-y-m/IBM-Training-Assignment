package com.example.demo.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "COUPON-WS")
public interface CouponProxy {

	@GetMapping("/coupon/{couponCode}")
	public CouponDto getCouponByCode(@PathVariable("couponCode") String couponCode);
}