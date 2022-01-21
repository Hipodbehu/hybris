package org.training.controller;

import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.model.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.model.ContactRequestModel;
import org.training.service.ContactRequestService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ContactRequestController {
  @Autowired
  private ContactRequestService contactRequestService;

  @Autowired
  private ModelService modelService;

  @GetMapping("/contactRequest")
  public String showPage(@RequestParam(value = "sender", required = false) String sender, final ModelMap model) {
    ContactRequestModel contactRequest = null;
    if (sender != null) {
      try {
        contactRequest = contactRequestService.getContactRequest(sender);
      } catch (final UnknownIdentifierException e) {
        // OK, nothing found
      }
    }

    model.addAttribute("contactRequest", contactRequest);
    return "contactRequest";
  }

  @PostMapping("/contactRequest")
  public String handleRequest(@RequestParam(value = "sender", required = false) String sender,
                              @RequestParam(value = "newSender", required = false) String newSender,
                              @RequestParam(value = "newMessage", required = false) String newMessage,
                              final ModelMap model) {
    ContactRequestModel contactRequest = null;
    if (sender != null) {
      try {
        contactRequest = contactRequestService.getContactRequest(sender);
      } catch (final UnknownIdentifierException e) {
        // OK, nothing found
      }
    }

    if (contactRequest == null) {
      contactRequest = new ContactRequestModel();
      modelService.attach(contactRequest);
    }
    if (newSender != null) {
      contactRequest.setSender(newSender);
    }
    if (newMessage != null) {
      contactRequest.setMessage(newMessage);
    }
    modelService.save(contactRequest);

    model.addAttribute("contactRequest", contactRequest);
    return "contactRequest";
  }
}
