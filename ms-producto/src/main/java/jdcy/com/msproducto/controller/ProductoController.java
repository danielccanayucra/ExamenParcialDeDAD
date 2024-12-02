package jdcy.com.msproducto.controller;

import jdcy.com.msproducto.dto.ProductoDto;
import jdcy.com.msproducto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<ProductoDto>> listAllProducts() {
        return ResponseEntity.ok(productoService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> getProductById(@PathVariable Integer id) {
        Optional<ProductoDto> product = productoService.findById(id);
        return product.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductoDto> saveProduct(@RequestBody ProductoDto productDto) {
        ProductoDto savedProduct = productoService.save(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDto> update(@PathVariable Integer id, @RequestBody ProductoDto productDto) {
        ProductoDto updatedProduct = productoService.update(id, productDto);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        productoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
