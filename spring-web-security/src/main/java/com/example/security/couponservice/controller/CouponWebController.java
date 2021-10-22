package com.example.security.couponservice.controller;

import com.example.security.couponservice.model.Coupon;
import com.example.security.couponservice.repo.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CouponWebController {

    @Autowired
    private CouponRepo repo;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/createCoupon")
    public String create() {
        return "createCoupon";
    }

    @PostMapping("/saveCoupon")
    public String saveCoupon(Coupon coupon) {
        repo.save(coupon);
        return "createResponse";
    }

    @GetMapping("/showCouponPage")
    public String showCoupon() {
        return "showCouponPage";
    }

    @GetMapping("/fetchCoupon")
    public ModelAndView fetchCoupon(String code) {
        ModelAndView mv = new ModelAndView("couponDetails");
        mv.addObject(repo.findByCode(code));
        return mv;
    }
}
