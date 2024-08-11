package com.beratyesbek.stockapp.model.mapper;

import com.beratyesbek.stockapp.model.dto.StockReadDTO;
import com.beratyesbek.stockapp.model.entity.Stock;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StockMapper {

    public  StockReadDTO mapTo(Stock stock) {
        return StockReadDTO.builder()
                .id(stock.getId())
                .name(stock.getName())
                .description(stock.getDescription())
                .currentPrice(stock.getCurrentPrice())
                .build();
    }

    public List<StockReadDTO> mapTo(List<Stock> stock) {
        return stock.stream().map(this::mapTo).toList();
    }
}
