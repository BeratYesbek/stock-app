package com.beratyesbek.stockapp.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StockUpdateDTO {

    private BigDecimal newPrice;
}
