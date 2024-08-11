package com.beratyesbek.stockapp.controller;

import com.beratyesbek.stockapp.model.dto.StockReadDTO;
import com.beratyesbek.stockapp.model.dto.StockUpdateDTO;
import com.beratyesbek.stockapp.model.entity.Stock;
import com.beratyesbek.stockapp.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stock")
public class StockController {

    private final StockService stockService;

    @PostMapping
    public ResponseEntity<StockReadDTO> create(@RequestBody Stock stock) {
        return ResponseEntity.ok(stockService.create(stock));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody StockUpdateDTO updateDTO) {
        stockService.update(id, updateDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        stockService.delete(id);
        return ResponseEntity.ok().build();
    }
}
