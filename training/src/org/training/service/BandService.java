package org.training.service;

import org.training.model.BandModel;

import java.util.List;

public interface BandService {
  BandModel getBand(String code);

  List<BandModel> getBands();
}
