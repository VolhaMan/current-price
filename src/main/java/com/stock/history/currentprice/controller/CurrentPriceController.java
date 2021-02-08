package com.stock.history.currentprice.controller;

import com.stock.history.currentprice.model.StockPrice;
import com.stock.history.currentprice.service.CurrentPriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CurrentPriceController {

    @Autowired
    CurrentPriceService currentPriceService;

    @GetMapping("current-price")
    public StockPrice getCurrentPrice(@RequestParam(name = "stock_code") String stockCode) {
        log.info("Current-price request received for stock code {}", stockCode);
        return currentPriceService.getCurrentPrice(stockCode);
    }
}
