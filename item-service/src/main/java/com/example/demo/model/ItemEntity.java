package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "item_table")
public class ItemEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private int itemId;
	@Column(name = "item_name")
	private String itemName;
	@Column(name = "actual_price")
	private double actualPrice;
	@Column(name = "coupon_code_applied")
	private String discountCodeApplied;
	@Column(name = "discount_received")
	private double discountReceived;
	@Column(name = "final_price")
	private double priceAfterDiscount;
	@Transient
	private String couponCode;
	

}