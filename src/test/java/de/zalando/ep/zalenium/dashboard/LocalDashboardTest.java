package de.zalando.ep.zalenium.dashboard;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.File;
import java.io.IOException;

import com.google.gson.JsonObject;
import de.zalando.ep.zalenium.util.CommonProxyUtilities;
import de.zalando.ep.zalenium.util.TestUtils;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class LocalDashboardTest {

    private static final String TEST_COUNT_FILE_NAME = "executedTestsInfo.json";

    private TestInformation ti = new TestInformation.TestInformationBuilder()
            .withSeleniumSessionId("seleniumSessionId")
            .withTestName("testName")
            .withProxyName("proxyName")
            .withBrowser("browser")
            .withBrowserVersion("browserVersion")
            .withPlatform("platform")
            .withTestStatus(TestInformation.TestStatus.COMPLETED)
            .build();

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Before
    public void initDashboard() throws IOException {
        ti.setVideoRecorded(true);
        LocalDashboard.setExecutedTests(0, 0);
        TestUtils.ensureRequiredInputFilesExist(temporaryFolder);
        CommonProxyUtilities proxyUtilities = TestUtils.mockCommonProxyUtilitiesForDashboardTesting(temporaryFolder);
        LocalDashboard.setCommonProxyUtilities(proxyUtilities);
    }

    @After
    public void restoreCommonProxyUtilities() {
        LocalDashboard.restoreCommonProxyUtilities();
    }

    @Test
    public void testCountOne() {
        LocalDashboard dashboard = new LocalDashboard();
        try {
            dashboard.updateDashboard(ti);
            Assert.assertEquals(1, LocalDashboard.getExecutedTests());
            Assert.assertEquals(1, LocalDashboard.getExecutedTestsWithVideo());
        }
        catch(Exception e) {
            Assert.fail(e.toString());
        }
    }

    @Test
    public void testCountTwo() {
        LocalDashboard dashboard = new LocalDashboard();
        try {
            dashboard.updateDashboard(ti);
            dashboard.updateDashboard(ti);
            Assert.assertEquals(2, LocalDashboard.getExecutedTests());
            Assert.assertEquals(2, LocalDashboard.getExecutedTestsWithVideo());
        } catch (Exception e) {
            Assert.fail(e.toString());
        }
    }

    @Test
    public void missingExecutedTestsFile()  throws IOException {
        LocalDashboard dashboard = new LocalDashboard();
        try
        {
            dashboard.updateDashboard(ti);
        } catch (Exception e) {
            Assert.fail(e.toString());
        }

        cleanTempVideosFolder();
        TestUtils.ensureRequiredInputFilesExist(temporaryFolder);
        try {
            dashboard.updateDashboard(ti);
        } catch (Exception e) {
            Assert.fail(e.toString());
        }
        Assert.assertEquals(1, LocalDashboard.getExecutedTests());
        Assert.assertEquals(1, LocalDashboard.getExecutedTestsWithVideo());
    }

    @Test
    public void nonNumberContentsIgnored() throws IOException {
        File testCountFile = new File(temporaryFolder.getRoot().getAbsolutePath() + "/" + LocalDashboard.VIDEOS_FOLDER_NAME
                + "/" + TEST_COUNT_FILE_NAME);
        JsonObject testQuantities = new JsonObject();
        testQuantities.addProperty("executedTests", "Not-A-Number");
        testQuantities.addProperty("executedTestsWithVideo", "Not-A-Number");
        FileUtils.writeStringToFile(testCountFile, testQuantities.toString(), UTF_8);
        LocalDashboard.setExecutedTests(0, 0);
        DashboardCollection.updateDashboard(ti);
        Assert.assertEquals(1, LocalDashboard.getExecutedTests());
        Assert.assertEquals(1, LocalDashboard.getExecutedTestsWithVideo());
    }

    private void cleanTempVideosFolder() throws IOException {
        FileUtils.cleanDirectory(new File(temporaryFolder.getRoot().getAbsolutePath()));
    }
}
