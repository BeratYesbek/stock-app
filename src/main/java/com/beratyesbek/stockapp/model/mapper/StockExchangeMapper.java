package com.beratyesbek.stockapp.model.mapper;

import com.beratyesbek.stockapp.model.dto.StockExchangeReadDTO;
import com.beratyesbek.stockapp.model.entity.StockExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StockExchangeMapper {

    @Autowired
    private StockMapper stockMapper;

    public StockExchangeReadDTO mapTo(StockExchange stockExchange) {
        return StockExchangeReadDTO.builder()
                .name(stockExchange.getName())
                .isLiveInMarket(stockExchange.isLiveInMarket())
                .description(stockExchange.getDescription())
                .createdDate(stockExchange.getCreatedDate())
                .updatedDate(stockExchange.getUpdatedDate())
                .stocks(stockMapper.mapTo(stockExchange.getStocks()))
                .build();
    }

    public List<StockExchangeReadDTO> mapTo(List<StockExchange> stockExchanges) {
        return stockExchanges.stream().map(this::mapTo).toList();
    }
}
