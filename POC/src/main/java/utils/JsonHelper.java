package utils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;

public class JsonHelper {

    private static final String Name = "name";
    private static final String Elements = "elements";

    private JsonArray loadJson(String jsonPath) throws FileNotFoundException {
        JsonParser parser = new JsonParser();
        FileReader jsonFile = new FileReader(jsonPath);
        return (JsonArray) parser.parse(jsonFile);
    }

    public void doMerge(String cucumberFile, String retriedCucumberFile, String newCucumberFile) throws IOException {
        // Load Cucumber.json Files.
        JsonArray cucumberJson = loadJson(cucumberFile);
        JsonArray cucumberJsonRetry = loadJson(retriedCucumberFile);

        //Instance new Json cucumber.
        JsonArray newCucumberJson = new JsonArray();

        // Iterate  features
        for (int indexCucumberJson = 0; indexCucumberJson < cucumberJson.size(); indexCucumberJson++) {
            JsonObject featureJson = (JsonObject) cucumberJson.get(indexCucumberJson);

            // Iterate rety features
            for (int indexCucumberJsonRetry = 0; indexCucumberJsonRetry < cucumberJsonRetry.size(); indexCucumberJsonRetry++) {
                JsonObject retryFeatureJson = (JsonObject) cucumberJsonRetry.get(indexCucumberJsonRetry);
                JsonArray newCucumberScenariosArray = new JsonArray();

                if (featureJson.get(Name).equals(retryFeatureJson.get(Name))) {

                    // Iterate scenarios
                    JsonArray scenariosJson = featureJson.getAsJsonArray(Elements);

                    for (int i = 0; i < scenariosJson.size(); i++) {
                        JsonObject scenarioJson = scenariosJson.get(i).getAsJsonObject();

                        // Iterate retry scenarios
                        JsonArray scenariosRetryJson = retryFeatureJson.getAsJsonArray(Elements);

                        for (int x = 0; x < scenariosRetryJson.size(); x++) {
                            JsonObject scenarioRetryJson = scenariosRetryJson.get(x).getAsJsonObject();

                            if (scenarioJson.get(Name).equals(scenarioRetryJson.get(Name))) {
                                newCucumberScenariosArray.add(scenarioRetryJson);
                                break;
                            } else if (x == scenariosRetryJson.size() - 1) {
                                newCucumberScenariosArray.add(scenarioJson);
                            }
                        }
                    }

                    // Add retry feature
                    featureJson.add(Elements, newCucumberScenariosArray);
                    newCucumberJson.add(featureJson);
                    break;
                } else if(indexCucumberJsonRetry == cucumberJsonRetry.size() - 1) {
                    newCucumberJson.add(featureJson);
                }
            }
        }

        // Create cucumber json Merged.
        JsonElement newCucumberJsonAux = (JsonElement) newCucumberJson;
        createNewCucumberJson(newCucumberJsonAux.getAsJsonArray().toString(), newCucumberFile);

    }

    public  void createNewCucumberJson(String jsonString, String newCucumberFile) throws IOException {
        FileWriter writerCucumberJson = new FileWriter(newCucumberFile);
        writerCucumberJson.write(jsonString);
        writerCucumberJson.close();
    }
}
