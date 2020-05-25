package unitTest;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import helpers.FeatureClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JsonHelper;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonHelperTest {

    @Test
    public void testVerifyBasicFields() throws IOException {
        JsonHelper jsonHelper = new JsonHelper();
        jsonHelper.doMerge("build/cucumber/cucumber.json", "build/cucumber/retry/cucumber.json", "build/cucumber/cucumberMerged.json");

        JsonParser parser = new JsonParser();
        FileReader cucumberJson = new FileReader("build/cucumber/cucumber.json");
        FileReader cucumberMerged = new FileReader("build/cucumber/cucumberMerged.json");

        List<FeatureClass> myCucumberJsonList = new Gson().fromJson((JsonArray) parser.parse(cucumberJson) , new TypeToken<ArrayList<FeatureClass>>(){}.getType());
        List<FeatureClass> myCucumberRetryJsonList = new Gson().fromJson((JsonArray) parser.parse(cucumberMerged) , new TypeToken<ArrayList<FeatureClass>>(){}.getType());

        Assert.assertEquals(myCucumberJsonList.size(), myCucumberRetryJsonList.size());
        for (int i = 0; i<myCucumberJsonList.size() ; i++) {
            Assert.assertEquals(myCucumberJsonList.get(i).line, myCucumberRetryJsonList.get(i).line);
            Assert.assertEquals(myCucumberJsonList.get(i).scenarios.size(), myCucumberRetryJsonList.get(i).scenarios.size());
            Assert.assertEquals(myCucumberJsonList.get(i).name, myCucumberRetryJsonList.get(i).name);
            Assert.assertEquals(myCucumberJsonList.get(i).id, myCucumberRetryJsonList.get(i).id);
            Assert.assertEquals(myCucumberJsonList.get(i).uri, myCucumberRetryJsonList.get(i).uri);
            Assert.assertEquals(myCucumberJsonList.get(i).tags.size(), myCucumberRetryJsonList.get(i).tags.size());
        }
    }
}
