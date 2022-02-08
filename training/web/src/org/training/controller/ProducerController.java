package org.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.training.data.BandData;
import org.training.data.ProducerData;
import org.training.facades.ProducerFacade;

import java.util.List;

@Controller
public class ProducerController {
  public static final String PRODUCERS_ATTRIBUTE = "producers";
  public static final String PRODUCERS_PAGE = "producerList";

  @Autowired
  private ProducerFacade producerFacade;

  @GetMapping("/producers")
  public String showBands(ModelMap model) {
    List<ProducerData> producers = producerFacade.getProducers();
    model.addAttribute(PRODUCERS_ATTRIBUTE, producers);
    return PRODUCERS_PAGE;
  }
}
