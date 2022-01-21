package org.training.service;

import org.training.jalo.Band;
import org.training.model.BandModel;

public interface BandService {
  BandModel getBand(String code);
}
