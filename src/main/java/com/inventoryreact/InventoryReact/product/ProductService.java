package com.inventoryreact.InventoryReact.product;

import com.inventoryreact.InventoryReact.part.Part;
import com.inventoryreact.InventoryReact.part.PartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    PartRepository partRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }


    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProduct(Long productId) {
        boolean exists = productRepository.existsById(productId);
        if (!exists) {
            throw new IllegalStateException(("product with id " + productId + " does not exist"));
        }
        productRepository.deleteById(productId);
    }

    @Transactional
    public void updateProduct(Long productId,
                           String productName,
                           Integer productStockLevel,
                           String productCost,
                           Integer productMin,
                           Integer productMax,
                           Integer productMachineId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalStateException("product with id " + productId + "does not exist"));

        if(productName != null && productName.length() > 0 && !Objects.equals(product.getProductName(), productName)){
            product.setProductName(productName);
        }
        if(productStockLevel != null && productStockLevel > 0 && !Objects.equals(product.getProductStockLevel(), productStockLevel)){
            product.setProductStockLevel(productStockLevel);
        }
        if(productCost != null && productCost.length() > 0 && !Objects.equals(product.getProductCost(), productCost)){
            product.setProductCost(productCost);
        }
        if(productMin != null && productMin > 0 && !Objects.equals(product.getProductMin(), productMin)){
            product.setProductMin(productMin);
        }
        if(productMax != null && productMax > 0 && !Objects.equals(product.getProductMax(), productMax)){
            product.setProductMax(productMax);
        }
        if(productMachineId != null && productMachineId > 0 && !Objects.equals(product.getProductMachineId(), productMachineId)){
            product.setProductMachineId(productMachineId);
        }
    }
    public Optional<Product> getProductById(Long partId) {
        return productRepository.findById(partId);
    }
}
