package org.eclipse.lsp4xml.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.eclipse.lsp4j.services.LanguageClient;

/**
 * LogHelper
 */
public class LogHelper {

  //This will apply to all child loggers
  public static void initializeRootLogger(LanguageClient newLanguageClient, Map<?, ?> initializationObject) {
    Logger logger = Logger.getLogger("");
    logger.removeHandler(logger.getHandlers()[0]);
		logger.setLevel(Level.SEVERE);
		logger.setUseParentHandlers(false);// Stops output to console

		try {
			logger.addHandler(LogHelper.getClientHandler(newLanguageClient));
		} catch (Exception e) {
			//TODO: handle exception
		}
		
		String path = (String)initializationObject.get("lsp4xml.LogPath");
		if(path != null) {
			createDirectoryPath(path);
			try {
				FileHandler fh = LogHelper.getFileHandler(path);
				if(fh != null) {
					logger.addHandler(fh);
				}
			} catch (SecurityException | IOException e) {
				logger.log(Level.WARNING, "Error at creation of FileHandler for logging");
			}
		}
		else {
			logger.log(Level.INFO, "Log file could not be created, path not provided");
		}
		
	}

	private static void createDirectoryPath(String path) {
		String parentPath = Paths.get(path).normalize().getParent().toString();
		new File(parentPath).mkdirs();
	}

  
  public static ClientLogHandler getClientHandler(LanguageClient languageClient) {
    return new ClientLogHandler(languageClient);
  }

  public static FileHandler getFileHandler(String filePath) throws SecurityException, IOException {
    FileHandler fh = null;
    fh = new FileHandler(filePath, true);
    fh.setFormatter(new SimpleFormatter());
    fh.setLevel(Level.INFO);
    return fh;
  }

  public void unregisterHandler(Handler handler) {
		if(handler == null) {
			return;
		}
    Logger.getLogger("").removeHandler(handler);
  }
}