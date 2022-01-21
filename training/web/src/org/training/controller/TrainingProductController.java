package org.training.controller;

import de.hybris.platform.catalog.CatalogService;
import de.hybris.platform.core.model.product.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.service.TrainingProductService;

@Controller
public class TrainingProductController {
  @Autowired
  private CatalogService catalogService;

  @Autowired
  private TrainingProductService trainingProductService;

  @GetMapping("trainingProduct")
  public String showPage(@RequestParam(value = "code", required = false) String code,
                         @RequestParam(value = "name", required = false) String name,
                         final ModelMap model) {
    catalogService.setSessionCatalogVersion("hwcatalog", "Online");

    ProductModel product = null;
    if (code != null && name != null) {
      product = trainingProductService.getProductForCode(code, name);
    }

    model.addAttribute("product", product);
    return "trainingProduct";
  }
}
