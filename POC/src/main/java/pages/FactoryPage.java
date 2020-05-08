package pages;

public class FactoryPage {

    public static IPage GetPage(String pageName)
    {
        switch (pageName){
            case "Login":
               return new Login();
            case "Home":
                return new Home();
            case  "Create Space":
                return new CreateSpace();
            default:
                System.out.println("Page" + pageName + " no found");
                return  null;
        }
    }
}
