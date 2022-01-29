package org.training.service.impl;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.training.model.BandModel;
import org.training.service.BandService;

import javax.annotation.Resource;
import java.util.List;

@IntegrationTest
public class DefaultBandServiceTest extends ServicelayerBaseTest {
  @Resource
  private BandService bandService;

  @Test(expected = UnknownIdentifierException.class)
  public void shouldThrowExceptionWhenValidDataButNotFoundGetBand() {
    BandModel band = bandService.getBand("A001");
    Assert.assertNotNull(band);
  }

  @Test
  public void shouldReturnEmptyWhenValidDataGetBands() {
    List<BandModel> bandModels = bandService.getBands();
    Assert.assertTrue(bandModels.isEmpty());
  }
}