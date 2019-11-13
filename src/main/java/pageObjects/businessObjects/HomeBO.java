package pageObjects.businessObjects;


import org.testng.Assert;
import pageObjects.AbstractPage;
import pageObjects.HomePage;
import pageObjects.SignInPage;

import java.lang.reflect.Method;

public class HomeBO {

   private HomePage homePage;

   public HomeBO() {
      homePage= new HomePage();
   }

   public HomeBO proceedToHomePage(){
      homePage.proceedToHomePage();
      return this;
   }

   public SignInBO clickSignInButton(){
      homePage.clickSignInButton();
      return new SignInBO();
   }

   public void verifyUserIsLoggedIn(){
      Assert.assertTrue(homePage.isUserNameDisplayed(),"User is not logged in");
   }

   public void verifyRightUserNameIsDisplayed(String expectedUserName){
      Assert.assertEquals(homePage.getLoggedInUserName(),expectedUserName);
   }

   public <T extends AbstractPage> T openPage(Class<T> page) {
      try {
         Method method = homePage.getClass().getMethod("open" + page.getSimpleName());
         method.invoke(homePage);
         return page.newInstance();
      } catch (Exception e) {
         e.printStackTrace();
         throw new IllegalArgumentException(String.format("No page with name '%s'",page.getName()));
      }
   }
}
