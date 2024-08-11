package com.beratyesbek.stockapp.service;

import com.beratyesbek.stockapp.model.dto.StockExchangeReadDTO;
import com.beratyesbek.stockapp.model.dto.UpdateStockExchangeDTO;
import com.beratyesbek.stockapp.model.entity.Stock;
import com.beratyesbek.stockapp.model.entity.StockExchange;
import com.beratyesbek.stockapp.model.mapper.StockExchangeMapper;
import com.beratyesbek.stockapp.repository.StockExchangeRepository;
import com.beratyesbek.stockapp.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockExchangeService {

    private final StockExchangeRepository stockExchangeRepository;

    private final StockRepository stockRepository;
    private final StockExchangeMapper stockExchangeMapper;

    public StockExchangeReadDTO getStockExchangeByName(String name) {
        StockExchange stockExchange =  stockExchangeRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Stock Exchange not found"));
        return stockExchangeMapper.mapTo(stockExchange);
    }

    public StockExchangeReadDTO addStockToExchange(String name, UpdateStockExchangeDTO stockExchangeDTO) {
        StockExchange stockExchange = stockExchangeRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Stock Exchange not found"));

        List<Stock> stock = stockRepository.findAllById(stockExchangeDTO.getStockIds());
        stockExchange.getStocks().addAll(stock);
        updateLiveInMarketStatus(stockExchange);
        stockExchangeRepository.save(stockExchange);
        return stockExchangeMapper.mapTo(stockExchange);
    }

    public StockExchangeReadDTO removeStockFromExchange(String name, List<Long> stockIds) {
        StockExchange stockExchange = stockExchangeRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Stock Exchange not found"));
        List<Stock> stock = stockRepository.findAllById(stockIds);

        stockExchange.getStocks().removeAll(stock);
        updateLiveInMarketStatus(stockExchange);

        stockExchangeRepository.save(stockExchange);
        return stockExchangeMapper.mapTo(stockExchange);    }

    private void updateLiveInMarketStatus(StockExchange stockExchange) {
        stockExchange.setLiveInMarket(stockExchange.getStocks().size() >= 5);
    }
}