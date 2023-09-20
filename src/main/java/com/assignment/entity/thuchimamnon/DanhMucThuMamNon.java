package com.assignment.entity.thuchimamnon;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

