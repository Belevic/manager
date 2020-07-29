package com.bsuir.vmsis.model.impl;


import com.bsuir.vmsis.model.BaseEntity;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;


@Entity(name = "player_price")
@Table(name = "player_price")
public class PlayerPrice extends BaseEntity implements Serializable {

    @Column(name = "max_price")
    private Long maxPrice;

    @Column(name = "min_price")
    private Long minPrice;

    @Column(name = "price")
    private Long price;

    @Column(name = "transfer_price")
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

