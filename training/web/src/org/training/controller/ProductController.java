package org.training.controller;

import de.hybris.platform.catalog.CatalogService;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping("/product")
  public String showPage(@RequestParam(value = "code", required = false) String code, ModelMap model) {
    ProductModel product = null;
    if (code != null)
    {
      product = productService.getProductForCode(code);
    }
    model.addAttribute("product", product);
    return "product";
  }
}
