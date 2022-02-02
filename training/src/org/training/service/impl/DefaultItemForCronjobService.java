package org.training.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.training.daos.ItemForCronjobDao;
import org.training.model.ItemForCronjobModel;
import org.training.service.ItemForCronjobService;

import java.util.List;

public class DefaultItemForCronjobService implements ItemForCronjobService {
  private ItemForCronjobDao itemForCronjobDao;

  @Required
  public void setItemForCronjobDao(final ItemForCronjobDao itemForCronjobDao) {
    this.itemForCronjobDao = itemForCronjobDao;
  }

  @Override
  public List<ItemForCronjobModel> getItems() {
    return itemForCronjobDao.getItems();
  }
}
