package com.inventoryreact.InventoryReact.part;

import com.inventoryreact.InventoryReact.product.Product;
import com.inventoryreact.InventoryReact.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PartService {

    private final PartRepository partRepository;
    ProductRepository productRepository;

    @Autowired
    public PartService(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    public List<Part> getParts() {
        return partRepository.findAll();
    }

    public void addPart(Part part) {
        partRepository.save(part);
    }

    public void deletePart(Long partId) {
        boolean exists = partRepository.existsById(partId);
        if (!exists) {
            throw new IllegalStateException(("part with id " + partId + " does not exist"));
        }
        partRepository.deleteById(partId);
    }

    @Transactional
    public void updatePart(Long partId,
                           String partName,
                           Integer partStockLevel,
                           String partCategory,
                           String partCost,
                           Integer partMin,
                           Integer partMax,
                           Integer partsMachineId) {

        Part part = partRepository.findById(partId).orElseThrow(() -> new IllegalStateException("part with id " + partId + "does not exist"));

        if(partName != null && partName.length() > 0 && !Objects.equals(part.getPartName(), partName)){
            part.setPartName(partName);
        }
        if(partStockLevel != null && partStockLevel > 0 && !Objects.equals(part.getPartStockLevel(), partStockLevel)){
            part.setPartStockLevel(partStockLevel);
        }
        if(partCategory != null && partCategory.length() > 0 && !Objects.equals(part.getPartCategory(), partCategory)){
            part.setPartCategory(partCategory);
        }
        if(partCost != null && partCost.length()  > 0 && !Objects.equals(part.getPartCost(), partCost)){
            part.setPartCost(partCost);
        }
        if(partMin != null && partMin > 0 && !Objects.equals(part.getPartMin(), partMin)){
            part.setPartMin(partMin);
        }
        if(partMax != null && partMax > 0 && !Objects.equals(part.getPartMax(), partCost)){
            part.setPartMax(partMax);
        }
        if(partsMachineId != null && partsMachineId > 0 && !Objects.equals(part.getPartMachineId(), partsMachineId)){
            part.setPartMachineId(partsMachineId);
        }

    }

    @Transactional
    public void assignPart(Long partId, Long productId) {
        Part part = partRepository.findById(partId).get();
        Product product = productRepository.findById(productId).get();
        part.setProduct(product);
        partRepository.save(part);
    }

    public Optional<Part> getPartById(Long partId) {
        return partRepository.findById(partId);
    }

}
