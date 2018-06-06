package org.molgenis.app.manager.service;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.mockito.Mock;
import org.molgenis.app.manager.exception.*;
import org.molgenis.app.manager.meta.App;
import org.molgenis.app.manager.meta.AppFactory;
import org.molgenis.app.manager.meta.AppMetadata;
import org.molgenis.app.manager.model.AppConfig;
import org.molgenis.app.manager.model.AppResponse;
import org.molgenis.app.manager.service.impl.AppManagerServiceImpl;
import org.molgenis.data.DataService;
import org.molgenis.data.Query;
import org.molgenis.data.file.FileStore;
import org.molgenis.data.plugin.model.Plugin;
import org.molgenis.data.plugin.model.PluginFactory;
import org.molgenis.data.support.QueryImpl;
import org.molgenis.i18n.MessageSourceHolder;
import org.molgenis.i18n.format.MessageFormatFactory;
import org.molgenis.i18n.test.exception.TestAllPropertiesMessageSource;
import org.molgenis.test.AbstractMockitoTest;
import org.molgenis.util.file.UnzipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.ZipException;

import static org.apache.commons.codec.CharEncoding.UTF_8;
import static org.mockito.Mockito.*;
import static org.molgenis.app.manager.service.impl.AppManagerServiceImpl.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class AppManagerServiceTest extends AbstractMockitoTest
{
	private static final String APP_META_NAME = "sys_App";
	private static final String APP_META_URI = "uri";
	private static final String PLUGIN_META_NAME = "sys_Plugin";

	private AppManagerServiceImpl appManagerService;

	@Mock
	private AppFactory appFactory;

	@Mock
	private DataService dataService;

	@Mock
	private FileStore fileStore;

	@Mock
	private PluginFactory pluginFactory;

	@Mock
	private App app;

	@BeforeClass
	public void beforeClass()
	{
		TestAllPropertiesMessageSource messageSource = new TestAllPropertiesMessageSource(new MessageFormatFactory());
		messageSource.addMolgenisNamespaces("app-manager");
		MessageSourceHolder.setMessageSource(messageSource);
	}

	@AfterClass
	public void afterClass()
	{
		MessageSourceHolder.setMessageSource(null);
	}

	@BeforeMethod
	public void beforeMethod()
	{
		appManagerService = new AppManagerServiceImpl(appFactory, dataService, fileStore, new Gson(), pluginFactory);
	}

	@Test
	public void testGetApps()
	{
		when(app.getId()).thenReturn("id");
		when(app.getUri()).thenReturn("uri");
		when(app.getLabel()).thenReturn("label");
		when(app.getDescription()).thenReturn("description");
		when(app.isActive()).thenReturn(true);
		when(app.getAppVersion()).thenReturn("v1.0.0");
		when(app.includeMenuAndFooter()).thenReturn(true);
		when(app.getTemplateContent()).thenReturn("<h1>Test</h1>");
		when(app.getAppConfig()).thenReturn("{'config': 'test'}");
		when(app.getResourceFolder()).thenReturn("folder");
		AppResponse appResponse = AppResponse.create(app);

		when(dataService.findAll(APP_META_NAME, App.class)).thenReturn(Stream.of(app));
		List<AppResponse> actual = appManagerService.getApps();
		List<AppResponse> expected = Collections.singletonList(appResponse);

		assertEquals(actual, expected);
	}

	@Test
	public void testGetAppByUri()
	{
		when(app.getId()).thenReturn("id");
		when(app.getUri()).thenReturn("uri");
		when(app.getLabel()).thenReturn("label");
		when(app.getDescription()).thenReturn("description");
		when(app.isActive()).thenReturn(true);
		when(app.getAppVersion()).thenReturn("v1.0.0");
		when(app.includeMenuAndFooter()).thenReturn(true);
		when(app.getTemplateContent()).thenReturn("<h1>Test</h1>");
		when(app.getAppConfig()).thenReturn("{'config': 'test'}");
		when(app.getResourceFolder()).thenReturn("folder");

		Query<App> query = QueryImpl.EQ(APP_META_URI, "test");
		when(dataService.findOne(APP_META_NAME, query, App.class)).thenReturn(app);
		AppResponse actual = appManagerService.getAppByUri("test");
		AppResponse expected = AppResponse.create(app);

		assertEquals(actual, expected);
	}

	@Test
	public void testActivateApp()
	{
		when(dataService.findOneById(APP_META_NAME, "test", App.class)).thenReturn(app);
		when(app.getUri()).thenReturn("uri");

		Plugin plugin = mock(Plugin.class);
		when(pluginFactory.create("app/uri/")).thenReturn(plugin);
		plugin.setLabel("label");
		plugin.setDescription("description");

		appManagerService.activateApp("test");
		verify(dataService).update(APP_META_NAME, app);
		verify(dataService).add("sys_Plugin", plugin);
		verify(app).setActive(true);
	}

	@Test
	public void testDeactivateApp()
	{
		when(dataService.findOneById(APP_META_NAME, "test", App.class)).thenReturn(app);
		when(app.getUri()).thenReturn("uri");

		appManagerService.deactivateApp("test");

		verify(app).setActive(false);
		verify(dataService).update(APP_META_NAME, app);
		verify(dataService).deleteById(PLUGIN_META_NAME, "app/uri/");
	}

	@Test
	public void testDeleteApp() throws IOException
	{
		when(dataService.findOneById(APP_META_NAME, "test", App.class)).thenReturn(app);
		when(app.getResourceFolder()).thenReturn("folder");

		appManagerService.deleteApp("test");

		verify(dataService).deleteById(APP_META_NAME, "test");
		verify(fileStore).deleteDirectory(Paths.get("folder"));
	}

	@Test
	public void testAppUriDoesNotExist()
	{
		Query<App> query = QueryImpl.EQ(APP_META_URI, "test");
		when(dataService.findOne(APP_META_NAME, query, App.class)).thenReturn(null);
		try
		{
			appManagerService.getAppByUri("test");
			fail();
		}
		catch (AppForURIDoesNotExistException actual)
		{
			assertEquals(actual.getUri(), "test");
		}
	}

	@Test
	public void testAppIdDoesNotExist()
	{
		when(dataService.findOneById(APP_META_NAME, "test", App.class)).thenReturn(null);
		try
		{
			appManagerService.activateApp("test");
			fail();
		}
		catch (AppForIDDoesNotExistException actual)
		{
			assertEquals(actual.getId(), "test");
		}
	}

	@Test
	public void testUploadApp() throws IOException
	{
		InputStream zipData = mock(InputStream.class);
		String fileName = "app.zip";
		Path tempDir = Paths.get(APPS_TMP_DIR, ZIP_FILE_PREFIX + fileName + "29183740123947");

		when(fileStore.createTempDirectory(Paths.get(APPS_TMP_DIR), ZIP_FILE_PREFIX + fileName)).thenReturn(tempDir);
		doReturn(true).when(fileStore).exists(tempDir.resolve(ZIP_INDEX_FILE));
		doReturn(true).when(fileStore).exists(tempDir.resolve(ZIP_CONFIG_FILE));

		assertEquals(appManagerService.uploadApp(zipData, fileName, "app"), tempDir);

		verify(fileStore).unpack(zipData, tempDir);
	}

	@Test(expectedExceptions = AppArchiveMissingFilesException.class, expectedExceptionsMessageRegExp = "missingFromArchive:\\[index\\.html, config\\.json\\]")
	public void testUploadAppMissingIndexAndConfig() throws IOException
	{
		InputStream zipData = mock(InputStream.class);
		String fileName = "app.zip";
		Path tempDir = Paths.get(APPS_TMP_DIR, ZIP_FILE_PREFIX + fileName + "29183740123947");

		when(fileStore.createTempDirectory(Paths.get(APPS_TMP_DIR), ZIP_FILE_PREFIX + fileName)).thenReturn(tempDir);
		doReturn(false).when(fileStore).exists(tempDir.resolve(ZIP_INDEX_FILE));
		doReturn(false).when(fileStore).exists(tempDir.resolve(ZIP_CONFIG_FILE));

		appManagerService.uploadApp(zipData, fileName, "app");
	}

	@Test(expectedExceptions = InvalidAppArchiveException.class)
	public void testUploadAppInvalidZip() throws IOException
	{
		InputStream zipData = mock(InputStream.class);
		String fileName = "app.zip";
		Path tempDir = Paths.get(APPS_TMP_DIR, ZIP_FILE_PREFIX + fileName + "29183740123947");

		when(fileStore.createTempDirectory(Paths.get(APPS_TMP_DIR), ZIP_FILE_PREFIX + fileName)).thenReturn(tempDir);

		doThrow(new UnzipException(new ZipException("Invalid zip"))).when(fileStore).unpack(zipData, tempDir);

		appManagerService.uploadApp(zipData, fileName, "app");
	}

	@Test
	public void testCheckAndObtainConfig() throws IOException
	{
		String configContent = IOUtils.toString(getClass().getResourceAsStream("/config.json"), UTF_8);

		Path appDir = Paths.get(APPS_DIR, "example2");
		when(fileStore.exists(appDir)).thenReturn(false);

		Path appTempDir = Paths.get(APPS_TMP_DIR, "temp");

		appManagerService.checkAndObtainConfig(appTempDir, configContent);

		verify(fileStore).move(appTempDir, appDir);
	}

	@Test(expectedExceptions = InvalidAppConfigException.class)
	public void testCheckAndObtainConfigInvalidJsonConfigFile() throws IOException
	{
		appManagerService.checkAndObtainConfig(Paths.get("tempDir"), "");
	}

	@Test(expectedExceptions = AppConfigMissingParametersException.class, expectedExceptionsMessageRegExp = "missingConfigParameters:\\[label, description, includeMenuAndFooter, uri, version\\]")
	public void testCheckAndObtainConfigMissingRequiredConfigParameters() throws IOException
	{
		String configContent = IOUtils.toString(getClass().getResourceAsStream("/config-missing-keys.json"), UTF_8);
		appManagerService.checkAndObtainConfig(Paths.get("tempDir"), configContent);
	}

	@Test(expectedExceptions = AppAlreadyExistsException.class, expectedExceptionsMessageRegExp = "example2")
	public void testCheckAndObtainConfigAppAlreadyExists() throws IOException
	{
		URL url = AppManagerServiceTest.class.getResource("/config.json");
		when(fileStore.exists(Paths.get(APPS_DIR, "example2"))).thenReturn(true);
		appManagerService.checkAndObtainConfig(Paths.get(APPS_DIR, "tempDir"), IOUtils.toString(url, UTF_8));
	}

	@Test
	public void testExtractFileContent() throws IOException
	{
		when(fileStore.streamFileContent(Paths.get("testDir", "test"))).thenReturn(
				getClass().getResourceAsStream("/index.html"));
		appManagerService.extractFileContent(Paths.get("testDir", "test"));
	}

	@Test
	public void testConfigureApp()
	{
		when(appFactory.create()).thenReturn(app);

		AppConfig appConfig = mock(AppConfig.class);
		when(appConfig.getLabel()).thenReturn("test-app");
		when(appConfig.getDescription()).thenReturn("Test app description");
		when(appConfig.getIncludeMenuAndFooter()).thenReturn(true);
		when(appConfig.getVersion()).thenReturn("1.0");
		when(appConfig.getUri()).thenReturn("test-app-uri");
		when(appConfig.getApiDependency()).thenReturn("v2.0");

		appManagerService.configureApp(appConfig, "<h1>Test</h1>");

		verify(dataService).add(AppMetadata.APP, app);
	}
}
