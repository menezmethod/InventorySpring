package com.inventoryreact.InventoryReact.product;

import com.inventoryreact.InventoryReact.part.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService =  productService;
    }

    @GetMapping
    @CrossOrigin(origins = "https://inventoryreact.netlify.app/")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping(path = "{productId}")
    @CrossOrigin(origins = "https://inventoryreact.netlify.app/")
    public Optional<Product> find(@PathVariable("productId") Long productId) {
        return productService.getProductById(productId);
    }

    @PostMapping
    @CrossOrigin(origins = "https://inventoryreact.netlify.app/")
    public void addNewProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @DeleteMapping(path = "{productId}")
    @CrossOrigin(origins = "https://inventoryreact.netlify.app/")
    public void deleteProduct(
            @PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);
    }

    @PutMapping(path = "{productId}")
    @CrossOrigin(origins = "https://inventoryreact.netlify.app/")
    public void updateProduct (
            @PathVariable("productId") Long productId,
            @RequestParam(required = false) String productName,
            @RequestParam(required = false) Integer productStockLevel,
            @RequestParam(required = false) String productCost,
            @RequestParam(required = false) Integer productMin,
            @RequestParam(required = false) Integer productMax,
            @RequestParam(required = false) Integer productMachineId) {
        productService.updateProduct(productId, productName, productStockLevel, productCost, productMin, productMax, productMachineId);
    }
}
