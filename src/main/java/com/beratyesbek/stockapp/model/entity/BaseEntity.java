package com.beratyesbek.stockapp.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    private static final Boolean DEFAULT_DELETED = false;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DELETED")
    private Boolean deleted = DEFAULT_DELETED;

    @Column(name = "CREATED_DATE")
    private OffsetDateTime createdDate;

    @Column(name = "UPDATED_DATE")
    private OffsetDateTime updatedDate;

    @PrePersist
    public void prePersist() {
        createdDate = OffsetDateTime.now();
        updatedDate = OffsetDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedDate = OffsetDateTime.now();
    }

}
