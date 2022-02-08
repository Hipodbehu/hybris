package org.training.facades.impl;

import org.springframework.beans.factory.annotation.Required;
import org.training.data.ProducerData;
import org.training.facades.ProducerFacade;
import org.training.model.ProducerModel;
import org.training.service.ProducerService;

import java.util.ArrayList;
import java.util.List;

public class DefaultProducerFacade implements ProducerFacade {
  private ProducerService producerService;

  @Override
  public List<ProducerData> getProducers() {
    final List<ProducerModel> producerModels = producerService.getProducers();
    final List<ProducerData> producerDataList = new ArrayList<>();
    for (final ProducerModel pm : producerModels) {
      final ProducerData sfd = new ProducerData();
      sfd.setId(pm.getCode());
      sfd.setFirstName(pm.getFirstName());
      sfd.setLastName(pm.getSurname());
      producerDataList.add(sfd);
    }
    return producerDataList;
  }

  @Required
  public void setProducerService(final ProducerService producerService) {
    this.producerService = producerService;
  }
}
