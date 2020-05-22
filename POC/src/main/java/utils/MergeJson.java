package utils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;


public class MergeJson {

    private JsonArray LoadJson(String jsonPath) throws FileNotFoundException {
        JsonParser parser = new JsonParser();
        FileReader jsonFile = new FileReader(jsonPath);
        return (JsonArray) parser.parse(jsonFile);
    }

    public static void Merge(MergeJson mergeJsonaa) throws IOException {
        // Load Cucumber.json Files.
        JsonArray cucumberJson = mergeJsonaa.LoadJson("build/cucumber/cucumber.json");
        JsonArray cucumberJsonRetry = mergeJsonaa.LoadJson("build/cucumber/retry/cucumber.json");

        //Instance new Json cucumber aux.
        JsonArray newCucumberJson = new JsonArray();
        JsonArray newCucumberScenariosArray = new JsonArray();

        // Iterate  features
        for (int i = 0; i < cucumberJson.size(); i++) {
            JsonObject featureJson = (JsonObject) cucumberJson.get(i);

            // Iterate re-executed features
            for (int x = 0; x < cucumberJsonRetry.size(); x++) {
                JsonObject retryFeatureJson = (JsonObject) cucumberJsonRetry.get(x);
                newCucumberScenariosArray = new JsonArray();

                if (featureJson.get("name").equals(retryFeatureJson.get("name"))) {

                    // Iterate scenarios
                    JsonArray scenariosJson = featureJson.getAsJsonArray("elements");

                    for (int j = 0; j < scenariosJson.size(); j++) {
                        JsonObject scenarioJson = scenariosJson.get(j).getAsJsonObject();

                        // Iterate re-executed scenarios
                        JsonArray scenariosRetryJson = retryFeatureJson.getAsJsonArray("elements");

                        for (int l = 0; l < scenariosRetryJson.size(); l++) {
                            JsonObject scenarioRetryJson = scenariosRetryJson.get(l).getAsJsonObject();

                            if (scenarioJson.get("name").equals(scenarioRetryJson.get("name"))) {
                                // Add re-executed scenario
                                newCucumberScenariosArray.add(scenarioRetryJson);
                                break;
                            } else if (l == scenariosRetryJson.size() - 1) {
                                newCucumberScenariosArray.add(scenarioJson);
                            }
                        }
                    }

                    // Add re-executed feature
                    featureJson.add("elements", newCucumberScenariosArray);
                    newCucumberJson.add(featureJson);
                    break;
                } else if(x == cucumberJsonRetry.size() - 1) {
                    newCucumberJson.add(featureJson);
                }
            }
        }

        // Override cucumber json
        JsonElement newCucumberJsonAux = (JsonElement) newCucumberJson;
        mergeJsonaa.writeCucumberMergedJsonFile(newCucumberJsonAux.getAsJsonArray().toString());

    }



    public  void writeCucumberMergedJsonFile(String jsonString) throws IOException {
        File folder = new File("build/cucumber/merged/");
        folder.mkdirs();
        FileWriter writerCucumberJson = new FileWriter("build/cucumber/merged/cucumber.json");
        writerCucumberJson.write(jsonString);
        writerCucumberJson.close();
    }
}
