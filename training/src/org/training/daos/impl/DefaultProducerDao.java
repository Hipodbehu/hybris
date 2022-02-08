package org.training.daos.impl;

import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import org.training.daos.ProducerDao;
import org.training.model.ProducerModel;

import java.util.List;

public class DefaultProducerDao extends AbstractItemDao implements ProducerDao {
  @Override
  public List<ProducerModel> findProducers() {
    final String queryString = "SELECT {p:" + ProducerModel.PK + "} " +
            "FROM {" + ProducerModel._TYPECODE + " AS p} ";
    final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
    return flexibleSearchService.<ProducerModel>search(query).getResult();
  }
}
