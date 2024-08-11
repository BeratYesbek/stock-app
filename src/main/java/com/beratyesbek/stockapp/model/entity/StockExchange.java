package com.beratyesbek.stockapp.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stock_exchange")
@SQLRestriction("deleted is false")
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "UPDATE stock_exchange SET deleted = TRUE WHERE id=?")
public class StockExchange extends BaseEntity {

    private static final Boolean DEFAULT_LIVE_IN_MARKET = false;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "live_in_market")
    private boolean liveInMarket;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "stock_exchange_stocks",
            joinColumns = @JoinColumn(name = "stock_exchange_id"),
            inverseJoinColumns = @JoinColumn(name = "stock_id"))
    private List<Stock> stocks;

    @Override
    public void prePersist() {
        super.prePersist();
        this.liveInMarket = DEFAULT_LIVE_IN_MARKET;
    }
}