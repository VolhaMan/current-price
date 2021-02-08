package com.stock.history.currentprice.service;

import com.stock.history.currentprice.model.StockPrice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Random;

@Service
@Slf4j
public class CurrentPriceService {

    private final Random random = new Random();

    public StockPrice getCurrentPrice(String stockCode) {
        if (!StringUtils.hasText(stockCode) || stockCode.length() > 8) {
            log.error("Invalid stock code argument {}", stockCode);
            throw new IllegalArgumentException("invalid stock code argument");
        }
        return new StockPrice(stockCode, new Date(), random.nextDouble() * random.nextInt(1000));
    }
}
