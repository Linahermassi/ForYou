package com.example.foryou.RestControllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.example.foryou.DAO.Entities.Product;
import com.example.foryou.DAO.Repositories.ProductRepository;
import com.example.foryou.Services.Interfaces.IproductService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Products")
public class ProductRestController {



        private IproductService iProductService;
        @PostMapping("/ajouterProduct")
        public ResponseEntity<String> addProduct(@RequestBody Product product){
            iProductService.add(product);
            return ResponseEntity.ok("Added successfully.");
        }
        @PostMapping("ajouterAllProducts")
        public ResponseEntity<String> addAllProduct(@RequestBody List<Product> productList){
            iProductService.addAll(productList);
            return ResponseEntity.ok("Added successfully.");
        }
        @PutMapping("/ModifierProduct")
        public ResponseEntity<String> editProduct(@RequestBody Product product){
            iProductService.edit(product);
            return ResponseEntity.ok("Edited successfully.");
        }
        @DeleteMapping("SupprimerProduct")
        public ResponseEntity<String> deleteProduct(@RequestBody Product product){
            iProductService.delete(product);
            return ResponseEntity.ok("Deleted successfully.");
        }
        @DeleteMapping("/SupprimerProductById")
        public ResponseEntity<String> supprimerProductsById(@RequestParam int productId){
            iProductService.deleteById(productId);
            return ResponseEntity.ok("Deleted successfully.");
        }
        @DeleteMapping("/SupprimerAllProducts")
        public ResponseEntity<String> supprimerAllProducts(@RequestBody List<Product> productList){
            iProductService.deleteAll(productList);
            return ResponseEntity.ok("Deleted successfully.");
        }
        @DeleteMapping("/SupprimerAll")
        public ResponseEntity<String> SupprimerAll() {
            iProductService.deleteAll();
            return ResponseEntity.ok("Deleted successfully.");
        }
    }

