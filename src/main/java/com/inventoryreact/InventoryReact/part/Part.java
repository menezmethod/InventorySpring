package com.inventoryreact.InventoryReact.part;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inventoryreact.InventoryReact.product.Product;

import javax.persistence.*;

@Entity
@Table
public class Part {
    @Id
    @SequenceGenerator(
            name = "part_sequence",
            sequenceName = "part_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "part_sequence"
    )
    private Long id;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    private  String partName;
    private Integer partStockLevel;
    private String partCategory;
    private String partCost;
    private Integer partMin;
    private Integer partMax;
    private Integer partMachineId;

    public Part() {
    }
    public Part(String partName, Integer partStockLevel, String partCategory, String partCost, Integer partMin, Integer partMax, Integer partMachineId) {
        this.id = id;
        this.partName = partName;
        this.partStockLevel = partStockLevel;
        this.partCategory = partCategory;
        this.partCost = partCost;
        this.partMin = partMin;
        this.partMax = partMax;
        this.partMachineId = partMachineId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public Integer getPartStockLevel() {
        return partStockLevel;
    }

    public void setPartStockLevel(Integer partStockLevel) {
        this.partStockLevel = partStockLevel;
    }

    public String getPartCategory() {
        return partCategory;
    }

    public void setPartCategory(String partCategory) {
        this.partCategory = partCategory;
    }

    public String getPartCost() {
        return partCost;
    }

    public void setPartCost(String partCost) {
        this.partCost = partCost;
    }

    public Integer getPartMin() {
        return partMin;
    }

    public void setPartMin(Integer partMin) {
        this.partMin = partMin;
    }

    public Integer getPartMax() {
        return partMax;
    }

    public void setPartMax(Integer partMax) {
        this.partMax = partMax;
    }

    public Integer getPartMachineId() {
        return partMachineId;
    }

    public void setPartMachineId(Integer partMachineId) {
        this.partMachineId = partMachineId;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", partName='" + partName + '\'' +
                ", partStockLevel=" + partStockLevel +
                ", partCategory='" + partCategory + '\'' +
                ", partCost=" + partCost +
                ", partMin=" + partMin +
                ", partMax=" + partMax +
                ", partMachineId=" + partMachineId +
                '}';
    }
}
