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


    public void testVerifyBasicFields() throws IOException {

        // do to merge
        JsonHelper jsonHelper = new JsonHelper();
        jsonHelper.doMerge("build/cucumber/msdca.json", "build/cucumber/AKT_run_1.json", "build/cucumber/cucumberMerged.json");

        // read Jsons
        JsonParser parser = new JsonParser();
        FileReader cucumberJson = new FileReader("build/cucumber/msdca.json");
        FileReader cucumberMerged = new FileReader("build/cucumber/cucumberMerged.json");

        // load jsons
        List<FeatureClass> myCucumberJsonList = new Gson().fromJson((JsonArray) parser.parse(cucumberJson) , new TypeToken<ArrayList<FeatureClass>>(){}.getType());
        List<FeatureClass> myCucumberMergedList = new Gson().fromJson((JsonArray) parser.parse(cucumberMerged) , new TypeToken<ArrayList<FeatureClass>>(){}.getType());

        // validations
        Assert.assertEquals(myCucumberJsonList.size(), myCucumberMergedList.size());
        for (int i = 0; i < myCucumberJsonList.size() ; i++) {
            Assert.assertEquals(myCucumberJsonList.get(i).line, myCucumberMergedList.get(i).line);
            Assert.assertEquals(myCucumberJsonList.get(i).scenarios.size(), myCucumberMergedList.get(i).scenarios.size());
            Assert.assertEquals(myCucumberJsonList.get(i).name, myCucumberMergedList.get(i).name);
            Assert.assertEquals(myCucumberJsonList.get(i).id, myCucumberMergedList.get(i).id);
            Assert.assertEquals(myCucumberJsonList.get(i).uri, myCucumberMergedList.get(i).uri);
            Assert.assertEquals(myCucumberJsonList.get(i).tags.size(), myCucumberMergedList.get(i).tags.size());
        }
    }
}
