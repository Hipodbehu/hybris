package org.training.setup;

import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.servicelayer.impex.ImportConfig;
import de.hybris.platform.servicelayer.impex.ImportResult;
import de.hybris.platform.servicelayer.impex.ImportService;
import de.hybris.platform.servicelayer.impex.impl.StreamBasedImpExResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.training.constants.TrainingConstants;
import org.training.service.TrainingService;

import java.io.InputStream;

import static org.training.constants.TrainingConstants.PLATFORM_LOGO_CODE;

@SystemSetup(extension = TrainingConstants.EXTENSIONNAME)
public class TrainingSystemSetup {
  public static final String LOADING_CUSTOM_ESSENTIAL = "Loading custom essential data loading for expertSoftTestExtension";
  public static final String LOADING_CUSTOM_PROJECT = "Loading custom project data loading for expertSoftTestExtension";
  public static final String IMPEX_DATA_BANDS_PATH = "impex/data-bands.impex";
  public static final String IMPEX_DATA_Y_BAND_TOUR_PATH = "impex/data-yBandTour.impex";
  public static final String FAILED = "FAILED";

  private static final Logger LOG = LoggerFactory.getLogger(TrainingSystemSetup.class);
  private final TrainingService trainingService;
  private ImportService importService;

  public TrainingSystemSetup(final TrainingService trainingService) {
    this.trainingService = trainingService;
  }

  @SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
  public void createEssentialData() {
    trainingService.createLogo(PLATFORM_LOGO_CODE);
  }

  @SystemSetup(type = SystemSetup.Type.ESSENTIAL)
  public boolean putInMyEssentialData() {
    LOG.info(LOADING_CUSTOM_ESSENTIAL);
    return true;
  }

  @SystemSetup(type = SystemSetup.Type.ESSENTIAL)
  public boolean addMyProjectData() {
    LOG.info(LOADING_CUSTOM_PROJECT);
    impexImport(IMPEX_DATA_BANDS_PATH);
    impexImport(IMPEX_DATA_Y_BAND_TOUR_PATH);
    return true;
  }

  protected boolean impexImport(final String filename) {
    final String message = "training impexing [" + filename + "]...";
    try (final InputStream resourceAsStream = getClass().getResourceAsStream(filename)) {
      if (resourceAsStream == null) {
        throw new Exception();
      }
      LOG.info(message);
      final ImportConfig importConfig = new ImportConfig();
      importConfig.setScript(new StreamBasedImpExResource(resourceAsStream, "UTF-8"));
      importConfig.setLegacyMode(Boolean.FALSE);
      final ImportResult importResult = getImportService().importData(importConfig);
      if (importResult.isError()) {
        LOG.error(message + " " + FAILED);
        return false;
      }
    } catch (final Exception e) {
      LOG.error(message + " " + FAILED, e);
      return false;
    }
    return true;
  }

  private InputStream getImageStream() {
    return TrainingSystemSetup.class.getResourceAsStream("/training/sap-hybris-platform.png");
  }

  public ImportService getImportService() {
    return importService;
  }

  public void setImportService(ImportService importService) {
    this.importService = importService;
  }
}
