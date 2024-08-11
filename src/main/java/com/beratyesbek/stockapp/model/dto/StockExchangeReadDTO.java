package com.beratyesbek.stockapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockExchangeReadDTO {
    private String name;
    private Boolean isLiveInMarket;
    private String description;
    private OffsetDateTime createdDate;
    private OffsetDateTime updatedDate;

    private List<StockReadDTO> stocks;
}
