package org.training.service.impl;

import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.servicelayer.ServicelayerBaseTest;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.training.model.BandModel;
import org.training.service.BandService;

@IntegrationTest
public class DefaultBandServiceTest extends ServicelayerBaseTest {
  @Autowired
  private BandService bandService;

  @Test
  public void shouldReturnNullWhenValidData() {
    BandModel band = bandService.getBand("A001");
    Assert.assertTrue(band == null);
  }
}