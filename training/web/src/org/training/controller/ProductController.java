package org.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.data.ProductData;
import org.training.facades.ProductFacade;

@Controller
public class ProductController {
  @Autowired
  private ProductFacade productFacade;

  @GetMapping("/product")
  public String showPage(@RequestParam(value = "code", required = false) String code, ModelMap model) {
    ProductData product = null;
    if (code != null) {
      product = productFacade.getProduct(code);
    }
    model.addAttribute("product", product);
    return "product";
  }
}
