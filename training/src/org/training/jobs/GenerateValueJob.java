package org.training.jobs;

import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.training.model.ItemForCronjobModel;
import org.training.service.ItemForCronjobService;

import java.util.List;

public class GenerateValueJob extends AbstractJobPerformable<CronJobModel> {
  @Autowired
  private ItemForCronjobService itemForCronjobService;

  @Autowired
  private ConfigurationService configurationService;

  @Override
  public PerformResult perform(CronJobModel cronJobModel) {
    List<ItemForCronjobModel> itemForCronjobModel = itemForCronjobService.getItems();
    itemForCronjobModel.stream()
            .forEach(itemForCronjobModel1 -> itemForCronjobModel1.setToken(String.valueOf(Math.random())));
    modelService.saveAll(itemForCronjobModel);
    return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
  }
}
