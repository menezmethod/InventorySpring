package com.inventoryreact.InventoryReact.part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/parts")
public class PartController {

    private final PartService partService;

    @Autowired
    public PartController(PartService partService) {
        this.partService =  partService;
    }

    @GetMapping
    @CrossOrigin(origins = "https://inventoryreact.netlify.app/")
    public List<Part> getParts() {
        return partService.getParts();
    }

    @GetMapping(path = "{partId}")
    @CrossOrigin(origins = "https://inventoryreact.netlify.app/")
    public Optional<Part> find(@PathVariable("partId") Long partId) {
        return partService.getPartById(partId);
    }

    @PostMapping
    @CrossOrigin(origins = "https://inventoryreact.netlify.app/")
    public void addNewPart(@RequestBody Part part){
        partService.addPart(part);
    }

    @DeleteMapping(path = "{partId}")
    @CrossOrigin(origins = "https://inventoryreact.netlify.app/")
    public void deletePart(
            @PathVariable("partId") Long partId) {
        partService.deletePart(partId);
    }

    @PutMapping(path = "{partId}")
    @CrossOrigin(origins = "https://inventoryreact.netlify.app/")
    public void updatePart (
            @PathVariable("partId") Long partId,
            @RequestParam(required = false) String partName,
            @RequestParam(required = false) Integer partStockLevel,
            @RequestParam(required = false) String partCategory,
            @RequestParam(required = false) String partCost,
            @RequestParam(required = false) Integer partMin,
            @RequestParam(required = false) Integer partMax,
            @RequestParam(required = false) Integer partMachineId) {
        partService.updatePart(partId, partName, partStockLevel, partCategory, partCost, partMin, partMax, partMachineId);
    }
    @PutMapping(path = "/{partId}/products/{productId}")
    public void assignPartToProduct (
            @PathVariable("partId") Long partId,
            @PathVariable("productId") Long productId
    ) {
       partService.assignPart(partId, productId);
    }
}
