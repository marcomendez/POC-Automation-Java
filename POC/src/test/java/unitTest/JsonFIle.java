package unitTest;

import org.testng.annotations.Test;
import utils.MergeJson;

import java.io.IOException;

public class JsonFIle {

    @Test
    public void testAddPass() throws IOException {
        MergeJson mergeJson = new MergeJson();
        MergeJson.Merge(mergeJson);
    }

}
