package steps;

import org.openqa.selenium.WebElement;
import pages.IPage;

public class BaseStep {

     public WebElement GetElement (String elementName, String pageHome)  {

         IPage page = null;

         try {
             page = (IPage) Class.forName("pages." + pageHome).newInstance();

         } catch (Exception e) {
             e.printStackTrace();
         }

         return page.GetLocator(elementName);
     }
}
