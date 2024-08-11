package com.beratyesbek.stockapp.controller;
import com.beratyesbek.stockapp.model.dto.StockExchangeReadDTO;
import com.beratyesbek.stockapp.model.dto.UpdateStockExchangeDTO;
import com.beratyesbek.stockapp.model.entity.StockExchange;
import com.beratyesbek.stockapp.service.StockExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stock-exchange")
public class StockExchangeController {


    private final StockExchangeService service;

    @GetMapping("/{name}")
    public ResponseEntity<StockExchangeReadDTO> getStockExchange(@PathVariable String name) {
        return ResponseEntity.ok(service.getStockExchangeByName(name));
    }

    @PostMapping("/{name}")
    public ResponseEntity<StockExchangeReadDTO> addStockToExchange(
            @PathVariable String name,
            @RequestBody UpdateStockExchangeDTO stockExchangeDTO) {
        return ResponseEntity.ok(service.addStockToExchange(name, stockExchangeDTO));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<StockExchangeReadDTO> removeStockFromExchange(@PathVariable String name,
                                                                        @RequestParam List<Long> stockIds) {
        return ResponseEntity.ok(service.removeStockFromExchange(name, stockIds));
    }
}