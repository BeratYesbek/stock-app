package com.beratyesbek.stockapp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stock")
@SQLRestriction("deleted is false")
@EqualsAndHashCode(callSuper = true)
@SQLDelete(sql = "UPDATE stock SET deleted = TRUE WHERE id=?")
public class Stock extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "current_price")
    private BigDecimal currentPrice;

    @ManyToMany(mappedBy = "stocks")
    private List<StockExchange> stockExchanges;

}