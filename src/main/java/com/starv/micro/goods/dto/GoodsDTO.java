package com.starv.micro.goods.dto;

import java.util.UUID;

public class GoodsDTO {
    private UUID id;
    private String name;
    private String description;
    private String sku;
    private Long availableCount;

    public GoodsDTO(UUID id, String name, String description, String sku, Long availableCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sku = sku;
        this.availableCount = availableCount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Long getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(Long availableCount) {
        this.availableCount = availableCount;
    }
}
