package com.kroha.web;

import com.kroha.domain.ProductDto;
import com.kroha.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductDto productDto;

    @GetMapping("/create")
    public String getCreateForm(Model model) {
        List<ProductDto> products = productService.getAll();
        return "productAd";
    }

    @PostMapping("/create")
    public String createProducts(@ModelAttribute ProductDto product, Principal principal) {
        ProductDto createdProduct = ProductService.create(product, principal.getName());
        return "redirect:/portfolio/" + createdProduct.getId();
    }

    @PostMapping("/{id}")
    public String deleteProduct(@PathVariable("id") Long id, Principal principal) {
        productService.delete(id);
        return "redirect:/portfolio/";
    }
}
