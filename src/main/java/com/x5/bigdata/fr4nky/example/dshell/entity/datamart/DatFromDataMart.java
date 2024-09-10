package com.x5.bigdata.fr4nky.example.dshell.entity.datamart;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name = "product", schema = "data_mart") // TODO use default
@Data
@Setter
public class DatFromDataMart {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "type_of_packaging")
    private String packagingType;

    @Column(name = "price")
    private Float price;

    @Column(name = "categoty_id")
    private Integer categoryId;

}
