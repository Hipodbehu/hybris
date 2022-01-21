package org.training.controller;

import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("/user")
  public String showPage(final ModelMap model) {
    final String uid = (String) model.getAttribute("uid");
    UserModel user = null;
    if (uid == null)
    {
      user = userService.getCurrentUser();
    }
    else
    {
      user = userService.getUserForUID(uid);
    }
    model.addAttribute("user", user);
    return "user";
  }
}
