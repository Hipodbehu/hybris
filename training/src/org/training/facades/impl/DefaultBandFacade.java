package org.training.facades.impl;


import java.util.ArrayList;
import java.util.List;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.config.ConfigurationService;
import org.springframework.beans.factory.annotation.Required;
import org.training.data.BandData;
import org.training.data.TourSummaryData;
import org.training.enums.MusicType;
import org.training.facades.BandFacade;
import org.training.model.BandModel;
import org.training.service.BandService;

import java.util.Locale;

public class DefaultBandFacade implements BandFacade {
  private static final String NAME = "band.name";

  private BandService bandService;
  private ConfigurationService configurationService;

  @Override
  public List<BandData> getBands() {
    final List<BandModel> bandModels = bandService.getBands();
    final String name = configurationService.getConfiguration().getString(NAME);
    final List<BandData> bandFacadeData = new ArrayList<>();
    for (final BandModel sm : bandModels) {
      final BandData sfd = new BandData();
      sfd.setId(sm.getCode());
      sfd.setName(sm.getName());
      sfd.setDescription(sm.getHistory());
      sfd.setAlbumsSold(sm.getAlbumSales());
      bandFacadeData.add(sfd);
    }
    return bandFacadeData;
  }

  @Override
  public BandData getBand(final String code) {
    if (code == null) {
      throw new IllegalArgumentException("Band name cannot be null");
    }
    final BandModel band = bandService.getBand(code);
    if (band == null) {
      return null;
    }

    // Create a list of genres
    final List<String> genres = new ArrayList<>();
    if (band.getTypes() != null) {
      for (final MusicType musicType : band.getTypes()) {
        genres.add(musicType.getCode());
      }
    }
    // Now we can create the BandData transfer object
    final BandData bandData = new BandData();
    bandData.setId(band.getCode());
    bandData.setName(band.getName());
    bandData.setAlbumsSold(band.getAlbumSales());
    bandData.setDescription(band.getHistory());
    bandData.setGenres(genres);
    return bandData;
  }

  @Required
  public void setBandService(final BandService bandService) {
    this.bandService = bandService;
  }


  @Required
  public void setConfigurationService(final ConfigurationService configurationService) {
    this.configurationService = configurationService;
  }
}