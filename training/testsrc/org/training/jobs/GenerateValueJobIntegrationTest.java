package org.training.jobs;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.PK;
import de.hybris.platform.core.Registry;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.model.ModelService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.training.model.ItemForCronjobModel;
import org.training.model.NewsModel;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@IntegrationTest
public class GenerateValueJobIntegrationTest extends ServicelayerTransactionalTest {
  @Resource
  private ModelService modelService;
  @Resource
  private GenerateValueJob generateValueJob;

  @Before
  public void setUp() throws Exception {
    try {
      Thread.sleep(TimeUnit.SECONDS.toMillis(1));
      new JdbcTemplate(Registry.getCurrentTenant().getDataSource()).execute("CHECKPOINT");
      Thread.sleep(TimeUnit.SECONDS.toMillis(1));
    } catch (InterruptedException exc) {
    }
  }

  @Test
  public void testGeneratingValue() throws Exception {
    final ItemForCronjobModel itemForCronjobModel = modelService.create(ItemForCronjobModel.class);
    modelService.saveAll();
    PK pk = itemForCronjobModel.getPk();
    final PerformResult result = generateValueJob.perform(null);
    ItemForCronjobModel itemForCronjobModel1 = modelService.get(pk);
    Assert.assertNotNull(itemForCronjobModel1.getToken());
  }
}