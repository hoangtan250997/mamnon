package com.assignment.entity.thuchimamnon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name = "mntc_danhmuc_thumamnon")
    public class DanhMucThuMamNon implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @NotNull
        @Size(min = 1, max = 500)
        @Column(length = 500, nullable = false)
        private String name;

        @Column(unique = true, nullable=false)
        private Integer code;
        //this field will be mapped by a field in danhmucthu in MN
        private Boolean fromMamnon;

    }

