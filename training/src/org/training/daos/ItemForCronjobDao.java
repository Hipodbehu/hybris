package org.training.daos;

import org.training.model.ItemForCronjobModel;

import java.util.List;

public interface ItemForCronjobDao {
  List<ItemForCronjobModel> getItems();
}
