package com.myapp.questions.controllers.cms;

import com.myapp.questions.model.cms2.components.QuestionsCMSComponentModel;
import de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = ControllerConsta)
public class QuestionsCMSComponentController extends AbstractCMSAddOnComponentController<QuestionsCMSComponentModel> {
  @Override
  protected void fillModel(HttpServletRequest request, Model model, QuestionsCMSComponentModel component) {
    model.addAttribute("numberOfQuestions", component.getNumberOfQuestions());
    model.addAttribute("fontSize", component.getFontSize());
  }
}
