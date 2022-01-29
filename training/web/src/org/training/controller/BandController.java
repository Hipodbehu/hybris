package org.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.training.data.BandData;
import org.training.facades.BandFacade;

import java.util.List;

@Controller
public class BandController {
  @Autowired
  private BandFacade bandFacade;

  @GetMapping("/bands")
  public String showBands(ModelMap model) {
    List<BandData> bands = bandFacade.getBands();
    model.addAttribute("bands", bands);
    return "bandList";
  }

  @GetMapping("/bands/{code}")
  public String showBands(@PathVariable String code,
                          ModelMap model) {
    BandData band = null;
    if (code != null) {
      band = bandFacade.getBand(code);
    }
    model.addAttribute("band", band);
    return "band";
  }
}
