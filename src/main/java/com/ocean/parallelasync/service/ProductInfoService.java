package com.ocean.parallelasync.service;

import com.ocean.parallelasync.domain.ProductInfo;
import com.ocean.parallelasync.domain.ProductOption;

import java.util.List;

import static com.ocean.parallelasync.util.CommonUtil.delay;

public class ProductInfoService {

    public ProductInfo retrieveProductInfo(String productId) {
        delay(1000);
        List<ProductOption> productOptions = List.of(new ProductOption(1, "64GB", "Black", 699.99),
                new ProductOption(2, "128GB", "Black", 749.99));
        return ProductInfo.builder().productId(productId)
                .productOptions(productOptions)
                .build();
    }
}