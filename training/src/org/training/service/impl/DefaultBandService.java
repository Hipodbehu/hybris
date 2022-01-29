package org.training.service.impl;

import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.springframework.beans.factory.annotation.Required;
import org.training.model.BandModel;
import org.training.service.BandService;

import java.util.List;

public class DefaultBandService implements BandService {
  private FlexibleSearchService flexibleSearchService;

  @Override
  public BandModel getBand(String code) {
    final FlexibleSearchQuery query = new FlexibleSearchQuery("SELECT {PK} FROM {BAND} WHERE {code} = ?code");
    query.addQueryParameter("code", code);
    final SearchResult<BandModel> result = this.flexibleSearchService.search(query);
    final int resultCount = result.getTotalCount();
    if (resultCount == 0) {
      throw new UnknownIdentifierException("Band not found!");
    } else if (resultCount > 1) {
      throw new AmbiguousIdentifierException("Band code is not unique!");
    }
    return result.getResult().get(0);
  }

  @Override
  public List<BandModel> getBands() {
    final FlexibleSearchQuery query = new FlexibleSearchQuery("SELECT {PK} FROM {BAND}");
    final SearchResult<BandModel> result = this.flexibleSearchService.search(query);
    return result.getResult();
  }

  @Required
  public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService) {
    this.flexibleSearchService = flexibleSearchService;
  }
}
