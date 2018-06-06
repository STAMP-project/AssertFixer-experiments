package org.molgenis.app.manager.service.impl;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.apache.commons.io.IOUtils;
import org.molgenis.app.manager.exception.*;
import org.molgenis.app.manager.meta.App;
import org.molgenis.app.manager.meta.AppFactory;
import org.molgenis.app.manager.meta.AppMetadata;
import org.molgenis.app.manager.model.AppConfig;
import org.molgenis.app.manager.model.AppResponse;
import org.molgenis.app.manager.service.AppManagerService;
import org.molgenis.data.DataService;
import org.molgenis.data.Query;
import org.molgenis.data.file.FileStore;
import org.molgenis.data.plugin.model.Plugin;
import org.molgenis.data.plugin.model.PluginFactory;
import org.molgenis.data.plugin.model.PluginMetadata;
import org.molgenis.data.support.QueryImpl;
import org.molgenis.i18n.CodedRuntimeException;
import org.molgenis.util.file.UnzipException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static com.google.common.collect.Lists.newArrayList;
import static java.io.File.separator;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;

@Service
public class AppManagerServiceImpl implements AppManagerService
{
	public static final String APPS_DIR = "apps";
	public static final String APPS_TMP_DIR = "apps_tmp";
	public static final String ZIP_FILE_PREFIX = "zip_file_";
	public static final String ZIP_INDEX_FILE = "index.html";
	public static final String ZIP_CONFIG_FILE = "config.json";

	private static final String APP_PLUGIN_ROOT = "app/";
	private static final Logger LOG = LoggerFactory.getLogger(AppManagerService.class);

	private final AppFactory appFactory;
	private final DataService dataService;
	private final FileStore fileStore;
	private final Gson gson;
	private final PluginFactory pluginFactory;

	public AppManagerServiceImpl(AppFactory appFactory, DataService dataService, FileStore fileStore, Gson gson,
			PluginFactory pluginFactory)
	{
		this.appFactory = requireNonNull(appFactory);
		this.dataService = requireNonNull(dataService);
		this.fileStore = requireNonNull(fileStore);
		this.gson = requireNonNull(gson);
		this.pluginFactory = requireNonNull(pluginFactory);
	}

	@Override
	public List<AppResponse> getApps()
	{
		return dataService.findAll(AppMetadata.APP, App.class).map(AppResponse::create).collect(toList());
	}

	@Override
	public AppResponse getAppByUri(String uri)
	{
		Query<App> query = QueryImpl.EQ(AppMetadata.URI, uri);
		App app = dataService.findOne(AppMetadata.APP, query, App.class);
		if (app == null)
		{
			throw new AppForURIDoesNotExistException(uri);
		}
		return AppResponse.create(app);
	}

	@Override
	@Transactional
	public void activateApp(String id)
	{
		LOG.debug("Activating app '{}'...", id);
		// Set app to active
		App app = getAppById(id);
		app.setActive(true);
		dataService.update(AppMetadata.APP, app);

		// Add plugin to plugin table to enable permissions and menu management
		String pluginId = generatePluginId(app);
		Plugin plugin = pluginFactory.create(pluginId);
		plugin.setLabel(app.getLabel());
		plugin.setDescription(app.getDescription());
		dataService.add(PluginMetadata.PLUGIN, plugin);
		LOG.info("Activated app '{}'.", id);
	}

	@Override
	@Transactional
	public void deactivateApp(String id)
	{
		LOG.debug("Deactivating app '{}'...", id);
		App app = getAppById(id);
		app.setActive(false);
		dataService.update(AppMetadata.APP, app);

		String pluginId = generatePluginId(app);
		dataService.deleteById(PluginMetadata.PLUGIN, pluginId);

		// TODO remove from menu JSON?
		LOG.info("Deactivated app '{}'.", id);
	}

	@Override
	@Transactional
	public void deleteApp(String id)
	{
		LOG.debug("Deleting app '{}'...", id);
		App app = getAppById(id);
		try
		{
			fileStore.deleteDirectory(Paths.get(app.getResourceFolder()));
		}
		catch (IOException err)
		{
			throw new CouldNotDeleteAppException(id);
		}
		dataService.deleteById(AppMetadata.APP, id);
		LOG.info("Deleted app '{}'.", id);
	}

	@Override
	public Path uploadApp(InputStream zipData, String zipFileName, String formFieldName) throws IOException
	{
		Path importDir = fileStore.createTempDirectory(Paths.get(APPS_TMP_DIR), ZIP_FILE_PREFIX + zipFileName);
		try
		{
			tryUnpackArchive(zipData, zipFileName, importDir);
			List<String> missingRequiredFilesList = buildMissingRequiredFiles(importDir);
			if (!missingRequiredFilesList.isEmpty())
			{
				throw new AppArchiveMissingFilesException(missingRequiredFilesList);
			}
			return importDir;
		}
		catch (CodedRuntimeException ex)
		{
			fileStore.deleteDirectory(importDir);
			throw ex;
		}

	}

	private void tryUnpackArchive(InputStream zipData, String zipFileName, Path importDir)
	{
		try
		{
			fileStore.unpack(zipData, importDir);
		}
		catch (UnzipException ex)
		{
			throw new InvalidAppArchiveException(zipFileName, ex);
		}
	}

	@Override
	public AppConfig checkAndObtainConfig(Path tempDir, String configContent)
	{
		try
		{
			if (configContent.isEmpty() || !isConfigContentValidJson(configContent))
			{
				throw new InvalidAppConfigException();
			}
			AppConfig appConfig = gson.fromJson(configContent, AppConfig.class);
			List<String> missingAppConfigParams = buildMissingConfigParams(appConfig);
			if (!missingAppConfigParams.isEmpty())
			{
				throw new AppConfigMissingParametersException(missingAppConfigParams);
			}
			Path appDir = Paths.get(APPS_DIR, appConfig.getUri());
			if (fileStore.exists(appDir))
			{
				throw new AppAlreadyExistsException(appConfig.getUri());
			}
			try
			{
				fileStore.move(tempDir, appDir);
			}
			catch (IOException ex)
			{
				LOG.error("Failed to move app from temp dir '{}' to app dir'{}'", tempDir, appDir);
				throw new UncheckedIOException(ex);
			}
			return appConfig;
		}
		finally
		{
			try
			{
				fileStore.delete(tempDir);
			}
			catch (IOException ex)
			{
				LOG.error("Failed to delete temp dir '{}'", tempDir);
			}
		}
	}

	@Override
	@Transactional
	public void configureApp(AppConfig appConfig, String htmlTemplate)
	{
		String appDirName = APPS_DIR + separator + appConfig.getUri();

		// If provided config does not include runtimeOptions, set an empty map
		Map<String, Object> runtimeOptions = appConfig.getRuntimeOptions();
		if (runtimeOptions == null)
		{
			runtimeOptions = Maps.newHashMap();
		}

		App newApp = appFactory.create();
		newApp.setLabel(appConfig.getLabel());
		newApp.setDescription(appConfig.getDescription());
		newApp.setAppVersion(appConfig.getVersion());
		newApp.setApiDependency(appConfig.getApiDependency());
		newApp.setTemplateContent(htmlTemplate);
		newApp.setActive(false);
		newApp.setIncludeMenuAndFooter(appConfig.getIncludeMenuAndFooter());
		newApp.setResourceFolder(appDirName);
		newApp.setAppConfig(gson.toJson(runtimeOptions));
		newApp.setUri(appConfig.getUri());

		dataService.add(AppMetadata.APP, newApp);
	}

	@Override
	public String extractFileContent(Path path) throws IOException
	{
		InputStream is = fileStore.streamFileContent(path);
		return IOUtils.toString(is, Charset.forName("utf-8"));
	}

	private String generatePluginId(App app)
	{
		String pluginId = APP_PLUGIN_ROOT + app.getUri();
		if (!pluginId.endsWith("/"))
		{
			pluginId = pluginId + "/";
		}
		return pluginId;
	}

	private App getAppById(String id)
	{
		App app = dataService.findOneById(AppMetadata.APP, id, App.class);
		if (app == null)
		{
			throw new AppForIDDoesNotExistException(id);
		}
		return app;
	}

	private boolean isConfigContentValidJson(String configContent)
	{
		try
		{
			gson.fromJson(configContent, AppConfig.class);
		}
		catch (JsonSyntaxException e)
		{
			return false;
		}
		return true;
	}

	private List<String> buildMissingRequiredFiles(Path path)
	{
		return Stream.of(ZIP_INDEX_FILE, ZIP_CONFIG_FILE)
					 .filter(filePath -> !fileStore.exists(path.resolve(filePath)))
					 .collect(toList());
	}

	private List<String> buildMissingConfigParams(AppConfig appConfig)
	{
		List<String> missingConfigParameters = newArrayList();

		if (appConfig.getLabel() == null)
		{
			missingConfigParameters.add("label");
		}

		if (appConfig.getDescription() == null)
		{
			missingConfigParameters.add("description");
		}

		if (appConfig.getIncludeMenuAndFooter() == null)
		{
			missingConfigParameters.add("includeMenuAndFooter");
		}

		if (appConfig.getUri() == null)
		{
			missingConfigParameters.add("uri");
		}

		if (appConfig.getVersion() == null)
		{
			missingConfigParameters.add("version");
		}

		return missingConfigParameters;
	}
}
