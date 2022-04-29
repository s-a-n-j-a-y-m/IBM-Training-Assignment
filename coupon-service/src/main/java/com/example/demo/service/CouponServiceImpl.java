package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.CouponEntity;
import com.example.demo.repo.CouponRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CouponServiceImpl implements CouponService {
private final CouponRepository couponRepository;
	@Override
	public CouponEntity findCouponByCode(String couponCode) {
		// TODO Auto-generated method stub
		return couponRepository.findByCouponCode(couponCode);
	}

}
