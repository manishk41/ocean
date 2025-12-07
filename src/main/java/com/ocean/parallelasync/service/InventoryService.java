package com.ocean.parallelasync.service;

import com.ocean.parallelasync.domain.Inventory;
import com.ocean.parallelasync.domain.ProductOption;

import java.util.concurrent.CompletableFuture;

import static com.ocean.parallelasync.util.CommonUtil.delay;

public class InventoryService {
    public Inventory addInventory(ProductOption productOption) {
        delay(500);
        return Inventory.builder()
                .count(2).build();

    }

    public CompletableFuture<Inventory> addInventory_CF(ProductOption productOption) {

        return CompletableFuture.supplyAsync(() -> {
            delay(500);
            return Inventory.builder()
                    .count(2).build();
        });

    }
}