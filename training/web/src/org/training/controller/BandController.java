package org.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.model.BandModel;
import org.training.service.BandService;

@Controller
public class BandController {
  @Autowired
  private BandService bandService;

  @GetMapping("/band")
  public String showBand(@RequestParam(value = "code", required = false) String code,
                         ModelMap model) {
    BandModel band = null;
    if (code != null) {
      band = bandService.getBand(code);
    }
    model.addAttribute("band", band);
    return "band";
  }
}
