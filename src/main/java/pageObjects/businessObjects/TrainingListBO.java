package pageObjects.businessObjects;

import decorator.elements.PageElement;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.SignInPage;
import pageObjects.TrainingListPage;

import java.util.List;
import java.util.stream.Collectors;

public class TrainingListBO {
   private TrainingListPage trainingListPage;

   public TrainingListBO() {
      trainingListPage= new TrainingListPage();
   }

   public TrainingListBO expandSkillsModalWindow(){
      if (!trainingListPage.isSkillsModalWindowExpanded())
         trainingListPage.expandSkillsModalWindow();
      return this;
   }

   public TrainingListBO collapseSkillsModalWindow(){
      if (trainingListPage.isSkillsModalWindowExpanded())
         trainingListPage.collapseSkillsModalWindow();
      return this;
   }

   public TrainingListBO performSearchInSkills(String searchTerm){
      trainingListPage.performSearchInSkills(searchTerm);
      return this;
   }

   public TrainingListBO clearSkillsInput(){
      trainingListPage.clearSkillsInput();
      return this;
   }

   public List<String> getSkillsSearchResultsTextList(){
      return trainingListPage.getSkillsSearchResultsElements().stream().map(WebElement::getText)
            .collect(Collectors.toList());
   }

   public void verifyEachListElementContainsWord(List<String> list, String word){
      list.stream().forEach(element->
            Assert.assertTrue(element.contains(word),String.format("Element '%s' does not contain word '%s'",element,word)));
   }

   public void verifyNoSearchResultsAreReturnedForSkillsSearch(){
      Assert.assertFalse(trainingListPage.isSkillsSearchResultsPresent(),"Search results ARE returned");
   }
}
