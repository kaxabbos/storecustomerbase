package com.storecustomerbase.controller;

import com.storecustomerbase.controller.main.Attributes;
import com.storecustomerbase.model.Reviews;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reviews")
public class ReviewsCont extends Attributes {

    @GetMapping
    public String Reviews(Model model) {
        AddAttributesReviews(model);
        return "reviews";
    }


    @PostMapping("/add")
    public String ReviewsAdd(@RequestParam String review) {
        reviewsRepo.save(new Reviews(review, DateNow(), getUser()));
        return "redirect:/reviews";
    }
}
