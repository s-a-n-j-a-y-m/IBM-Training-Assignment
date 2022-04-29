package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CouponEntity;
import com.example.demo.service.CouponService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CouponController {
	
	private final CouponService couponService;

	@GetMapping("/coupon/{couponCode}")
	public CouponEntity findCouponByCode(@PathVariable("couponCode") String couponCode)
	{
		return couponService.findCouponByCode(couponCode);
	}
}
