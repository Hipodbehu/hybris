package org.training.service.impl;

import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.training.daos.ContactRequestDao;
import org.training.model.ContactRequestModel;
import org.training.service.ContactRequestService;

import java.util.List;

public class DefaultContactRequestService implements ContactRequestService {
  private ContactRequestDao contactRequestDao;

  @Override
  public ContactRequestModel getContactRequest(final String sender) {
    final List<ContactRequestModel> result = contactRequestDao.findBySender(sender);
    final int resultCount = result.size();
    if (resultCount == 0) {
      throw new UnknownIdentifierException(
              "ContactRequest with sender '" + sender + "' not found!"
      );
    } else if (resultCount > 1) {
      throw new AmbiguousIdentifierException(
              "ContactRequest with sender '" + sender + "' is not unique, " + resultCount
                      + " requests found!"
      );
    }
    return result.iterator().next();
  }

  @Required
  public void setContactRequestDao(final ContactRequestDao contactRequestDao){
    this.contactRequestDao = contactRequestDao;
  }
}
