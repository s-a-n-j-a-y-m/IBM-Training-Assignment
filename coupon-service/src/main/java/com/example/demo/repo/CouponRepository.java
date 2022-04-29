package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CouponEntity;
@Repository
public interface CouponRepository extends JpaRepository<CouponEntity, Integer> {
	
	@Query
	public CouponEntity findByCouponCode(String couponCode);

}
