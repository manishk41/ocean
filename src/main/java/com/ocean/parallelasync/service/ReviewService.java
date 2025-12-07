package com.ocean.parallelasync.service;

import com.ocean.parallelasync.domain.Review;

import static com.ocean.parallelasync.util.CommonUtil.delay;

public class ReviewService {

    public Review retrieveReviews(String productId) {
        delay(1000);
        return new Review(200, 4.5);
    }

}