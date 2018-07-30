package cucumber.runtime;

import com.ericsson.ei.mongodbhandler.MongoDBHandler;
import com.mongodb.MongoClient;
import cucumber.runtime.snippets.FunctionNameGenerator;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.mongo.tests.MongodForTestsFactory;
import gherkin.formatter.model.Step;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

public class GlobalRunner implements Backend {

    private Glue glue;
    private List<String> gluePaths;
    private MongoClient mongoClient = null;
    private MongodForTestsFactory testsFactory;

    @Autowired
    public MongoDBHandler mongoDBHandler;

    @Override
    public void loadGlue(Glue glue, List<String> gluePaths) {
        this.glue = glue;
        this.gluePaths = gluePaths;
        try {
            testsFactory = MongodForTestsFactory.with(Version.V3_4_1);
            mongoClient = testsFactory.newMongo();
            String port = "" + mongoClient.getAddress().getPort();
            System.setProperty("spring.data.mongodb.port", port);
            mongoDBHandler.setMongoClient(mongoClient);
        } catch (IOException ignored) {

        }
    }

    @Override
    public void setUnreportedStepExecutor(UnreportedStepExecutor executor) {

    }

    @Override
    public void buildWorld() {

    }

    @Override
    public void disposeWorld() {
        mongoClient.close();
        testsFactory.shutdown();
    }

    @Override
    public String getSnippet(Step step, FunctionNameGenerator functionNameGenerator) {
        return null;
    }
}