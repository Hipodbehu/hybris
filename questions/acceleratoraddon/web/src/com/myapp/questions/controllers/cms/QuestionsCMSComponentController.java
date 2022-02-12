package com.myapp.questions.controllers.cms;

import com.myapp.questions.controllers.QuestionsControllerConstants;
import com.myapp.questions.model.cms2.components.QuestionsCMSComponentModel;
import de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller("QuestionsCMSComponentController")
@RequestMapping(value = "/view/QuestionsCMSComponentController")
public class QuestionsCMSComponentController extends AbstractCMSAddOnComponentController<QuestionsCMSComponentModel> {
  @Override
  protected void fillModel(HttpServletRequest request, Model model, QuestionsCMSComponentModel component) {
    model.addAttribute("numberOfQuestions", component.getNumberOfQuestions());
    model.addAttribute("fontSize", component.getFontSize());
  }

  @Override
  protected String getView(final QuestionsCMSComponentModel component) {

    return "addon:/questions/cms/" + (getTypeCode(component).toLowerCase(Locale.ROOT));
  }
}
