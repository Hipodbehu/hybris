package org.training.facades;

import org.training.data.ProductData;

public interface ProductFacade {
  ProductData getProduct(String productCode);
}
