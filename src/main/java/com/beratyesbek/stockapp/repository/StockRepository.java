package com.beratyesbek.stockapp.repository;

import com.beratyesbek.stockapp.model.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
