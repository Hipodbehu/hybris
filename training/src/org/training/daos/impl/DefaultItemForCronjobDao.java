package org.training.daos.impl;

import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.training.daos.ItemForCronjobDao;
import org.training.model.ItemForCronjobModel;

import java.util.List;

public class DefaultItemForCronjobDao extends AbstractItemDao implements ItemForCronjobDao {
  @Override
  public List<ItemForCronjobModel> getItems() {
    final String queryString = "SELECT {p:" + ItemForCronjobModel.PK + "} "
            + "FROM {" + ItemForCronjobModel._TYPECODE + " AS p}";
    final FlexibleSearchQuery flexibleSearchQuery = new FlexibleSearchQuery(queryString);
    return flexibleSearchService.<ItemForCronjobModel>search(flexibleSearchQuery).getResult();
  }
}
