package com.stock.history.currentprice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class StockPrice {
    private String stockCode;
    private Date timestamp;
    private double price;
}
