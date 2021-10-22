package com.example.security.couponservice.repo;

import com.example.security.couponservice.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CouponRepo extends JpaRepository<Coupon, Long> {

    Coupon findByCode(String code);

}
