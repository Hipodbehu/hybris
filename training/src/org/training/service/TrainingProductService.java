package org.training.service;

import de.hybris.platform.core.model.product.ProductModel;

public interface TrainingProductService {
  ProductModel getProductForCode(String code, String name);
}
