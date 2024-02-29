package com.kroha.web;

import com.kroha.domain.ProductDto;
import com.kroha.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/create")
    public String getCreateForm(Model model) {
        model.addAttribute("product", new ProductDto());
        return "productAdd";
    }

    @PostMapping("/create")
    public String createProducts(@ModelAttribute ProductDto product) {
        ProductDto createdProduct = productService.create(product);
        return "redirect:/portfolio";

    }

    @PostMapping("product/{id}")
    public String deleteProduct(@PathVariable("id") Long id, Principal principal) {
        productService.delete(id);
        return "redirect:/portfolio/";
    }

    @GetMapping("/photo/{id}")
    @ResponseBody
    public byte[] getPhoto(@PathVariable("id") Long id) {
        return productService.getPhoto(id);
    }
}
