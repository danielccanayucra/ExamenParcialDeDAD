package jdcy.com.msproducto.service;

import jdcy.com.msproducto.dto.ProductoDto;


import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<ProductoDto> list();

    Optional<ProductoDto> findById(Integer id);

    ProductoDto save(ProductoDto productoDto);

    ProductoDto update(Integer id, ProductoDto productoDto);

    void delete(Integer id);
}
