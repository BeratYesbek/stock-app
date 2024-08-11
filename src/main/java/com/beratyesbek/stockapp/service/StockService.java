package com.beratyesbek.stockapp.service;

import com.beratyesbek.stockapp.model.dto.StockReadDTO;
import com.beratyesbek.stockapp.model.dto.StockUpdateDTO;
import com.beratyesbek.stockapp.model.entity.Stock;
import com.beratyesbek.stockapp.model.mapper.StockMapper;
import com.beratyesbek.stockapp.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockMapper stockMapper;
    private final StockRepository stockRepository;

    public StockReadDTO create(Stock stock) {
        Stock savedStock = stockRepository.save(stock);
        return stockMapper.mapTo(savedStock);
    }

    public void update(Long stockId, StockUpdateDTO updateDTO) {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new RuntimeException("Stock not found"));
        stock.setCurrentPrice(updateDTO.getNewPrice());
        stockRepository.save(stock);
    }

    public void delete(Long stockId) {
        Stock stock = stockRepository.findById(stockId)
                .orElseThrow(() -> new RuntimeException("Stock not found"));

        stock.getStockExchanges().forEach(se -> se.getStocks().remove(stock));
        stockRepository.delete(stock);
    }
}
