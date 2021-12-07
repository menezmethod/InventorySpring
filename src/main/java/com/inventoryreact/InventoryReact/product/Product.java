package com.inventoryreact.InventoryReact.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inventoryreact.InventoryReact.part.Part;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Part> parts;

    private  String productName;
    private Integer productStockLevel;
    private String productCost;
    private Integer productMin;
    private Integer productMax;
    private Integer productMachineId;

    public Product() {
    }
    public Product(String productName, Integer productStockLevel, String productCost, Integer productMin, Integer productMax, Integer productMachineId) {
        this.productName = productName;
        this.productStockLevel = productStockLevel;
        this.productCost = productCost;
        this.productMin = productMin;
        this.productMax = productMax;
        this.productMachineId = productMachineId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductStockLevel() {
        return productStockLevel;
    }

    public void setProductStockLevel(Integer productStockLevel) {
        this.productStockLevel = productStockLevel;
    }

    public String getProductCost() {
        return productCost;
    }

    public void setProductCost(String productCost) {
        this.productCost = productCost;
    }

    public Integer getProductMin() {
        return productMin;
    }

    public void setProductMin(Integer productMin) {
        this.productMin = productMin;
    }

    public Integer getProductMax() {
        return productMax;
    }

    public void setProductMax(Integer productMax) {
        this.productMax = productMax;
    }

    public Integer getProductMachineId() {
        return productMachineId;
    }

    public void setProductMachineId(Integer productMachineId) {
        this.productMachineId = productMachineId;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productStockLevel=" + productStockLevel +
                ", productCost=" + productCost +
                ", productMin=" + productMin +
                ", productMax=" + productMax +
                ", productMachineId=" + productMachineId +
                '}';
    }
}
