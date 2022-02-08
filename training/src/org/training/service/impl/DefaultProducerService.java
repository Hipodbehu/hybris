package org.training.service.impl;

import org.springframework.beans.factory.annotation.Required;
import org.training.daos.ProducerDao;
import org.training.model.ProducerModel;
import org.training.service.ProducerService;

import java.util.List;

public class DefaultProducerService implements ProducerService {
  private ProducerDao producerDao;

  @Override
  public List<ProducerModel> getProducers() {
    return producerDao.findProducers();
  }

  @Required
  public void setProducerDao(final ProducerDao producerDao) {
    this.producerDao = producerDao;
  }
}
