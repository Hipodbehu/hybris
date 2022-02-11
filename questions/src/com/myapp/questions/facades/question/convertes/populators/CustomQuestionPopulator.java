package com.myapp.questions.facades.question.convertes.populators;

import com.myapp.data.QuestionData;
import com.myapp.questions.model.QuestionModel;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

public class CustomQuestionPopulator implements Populator<QuestionModel, QuestionData> {
  @Override
  public void populate(QuestionModel questionModel, QuestionData questionData) throws ConversionException {
    questionData.setQuestion(questionModel.getQuestion());
    questionData.setQuestionCustomerName(questionModel.getQuestionCustomer().getName());
    questionData.setAnswer(questionModel.getAnswer());
  }
}
