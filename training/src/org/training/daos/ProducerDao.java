package org.training.daos;

import org.training.model.ProducerModel;

import java.util.List;

public interface ProducerDao {
  List<ProducerModel> findProducers();
}
