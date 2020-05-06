package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/id/{id}")
    public ProductDTO findProductById(@PathVariable Long id) {
        Product product = productService.findProductByID(id);
        return productToDto(product);
    }

    @GetMapping("/name/{name}")
    public ProductDTO findProductByName(@PathVariable String name) {
        Product product = productService.findProductByName(name);
        return productToDto(product);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAllUsers() {
        List<Product> productList = productService.findAllProducts();
        List<ProductDTO> userDTOList = new ArrayList<>();

        productList.forEach(product -> {
            ProductDTO dto = productToDto(product);
            userDTOList.add(dto);
        });

        return ResponseEntity.ok(userDTOList);
    }

    @PostMapping
    public void createProduct(@RequestBody ProductDTO request) {
        Product product = new Product();

        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setCategory(request.getCategory());
        product.setDiscount(request.getDiscount());
        product.setDescription(request.getDescription());

        productService.createProduct(product);
    }

    @DeleteMapping("/id")
    public void deleteProductById(@RequestBody ProductDTO request) {
        productService.deleteProductById(request.getId());
    }

    @DeleteMapping("/name")
    public void deleteProductByName(@RequestBody ProductDTO request) {
        productService.deleteProductByName(request.getName());
    }

    @PutMapping
    public void updateUser(@RequestBody ProductDTO request) {
        Product product = dtoToProduct(request);
        productService.updateProductById(request.getId(), product);
    }

    private ProductDTO productToDto(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setUserId(product.getUserId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setCategory(product.getCategory());
        productDTO.setDiscount(product.getDiscount());
        productDTO.setDescription(product.getDescription());
        return productDTO;
    }

    private Product dtoToProduct(ProductDTO dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setUserId(dto.getUserId());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setCategory(dto.getCategory());
        product.setDiscount(dto.getDiscount());
        product.setDescription(dto.getDescription());
        return product;
    }
}
