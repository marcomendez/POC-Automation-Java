package steps;

import org.openqa.selenium.WebElement;
import pages.IPage;

public class BaseStep {

     public WebElement GetElement (String elementName, String pageName)  {

         IPage page = null;

         try {
             page = (IPage) Class.forName("pages." + pageName).newInstance();

         } catch (Exception e) {
             e.printStackTrace();
         }

         return page.GetLocator(elementName);
     }
}
