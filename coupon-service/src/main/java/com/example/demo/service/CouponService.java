package com.example.demo.service;

import com.example.demo.model.CouponEntity;

public interface CouponService {
	
	public CouponEntity findCouponByCode(String couponCode);

}