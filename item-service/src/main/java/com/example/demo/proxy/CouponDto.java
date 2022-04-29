package com.example.demo.proxy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CouponDto {
	private int id;
	private String couponCode;
	private double discountAmount;
	private String expDate;
}