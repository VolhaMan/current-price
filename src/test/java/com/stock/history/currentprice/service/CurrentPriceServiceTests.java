package com.stock.history.currentprice.service;

import com.stock.history.currentprice.model.StockPrice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CurrentPriceServiceTests {
    private static final String VALID_STOCK_CODE = "GOOGL";
    private static final String INVALID_STOCK_CODE = "GOOGLE INC";
    CurrentPriceService currentPriceService;

    @BeforeEach
    public void setUp() {
        currentPriceService = new CurrentPriceService();
    }

    @Test
    public void nullStockCodeTest() {
        assertThrows(IllegalArgumentException.class, () -> currentPriceService.getCurrentPrice(null));
    }

    @Test
    public void emptyStockCodeTest() {
        assertThrows(IllegalArgumentException.class, () -> currentPriceService.getCurrentPrice(""));
    }

    @Test
    public void onlyWhiteSpacesStockCodeTest() {
        assertThrows(IllegalArgumentException.class, () -> currentPriceService.getCurrentPrice("   "));
    }

    @Test
    public void invalidStockCodeTest() {
        assertThrows(IllegalArgumentException.class, () -> currentPriceService.getCurrentPrice(INVALID_STOCK_CODE));

    }

    @Test
    public void validStockCodeTest() {
        StockPrice stockPrice = currentPriceService.getCurrentPrice(VALID_STOCK_CODE);
        assertEquals(stockPrice.getStockCode(), VALID_STOCK_CODE);
        assertNotNull(stockPrice.getTimestamp());
        assertNotEquals(stockPrice.getPrice(), 0.0d);
    }
}
