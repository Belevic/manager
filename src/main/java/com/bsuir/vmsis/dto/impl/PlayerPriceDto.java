package com.bsuir.vmsis.dto.impl;

import com.bsuir.vmsis.dto.BaseDto;
import lombok.Data;

import javax.persistence.Column;
@Data
public class PlayerPriceDto extends BaseDto {

    private Long maxPrice;
    private Long minPrice;
    private Long price;
    private Long transferPrice;

    public Long getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Long maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Long getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Long minPrice) {
        this.minPrice = minPrice;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getTransferPrice() {
        return transferPrice;
    }

    public void setTransferPrice(Long transferPrice) {
        this.transferPrice = transferPrice;
    }
}
