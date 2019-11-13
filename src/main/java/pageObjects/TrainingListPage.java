package pageObjects;

import decorator.elements.Button;
import decorator.elements.PageElement;
import decorator.elements.TextInput;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class TrainingListPage extends AbstractPage {

   private static final Logger LOG = Logger.getLogger(TrainingListPage.class);

   private By expandAllSkillsArrow = By.xpath("//*[@class='filter-field__arrow-icon' and @ng-click='openSkillsDropDown()']");

   private By collapseAllSkillsArrow = By.xpath("//*[@class='filter-field__arrow-icon arrow-icon-rotate' and @ng-click='openSkillsDropDown()']");

   private By skillsSearchInput = By.xpath("//input[@ng-model='searchTrainingBySkills']");

   private By skillsSearchResultsList = By.xpath("//label[contains(@ng-class,'Skill')]");

   public TrainingListPage expandSkillsModalWindow(){
      getElement(expandAllSkillsArrow).click();
      LOG.info("Expand 'Skills' modal window");
      return this;
   }

   public TrainingListPage collapseSkillsModalWindow(){
      getElement(collapseAllSkillsArrow).click();
      LOG.info("Collapse 'Skills' modal window");
      return this;
   }

   public boolean isSkillsModalWindowExpanded(){
      return isDisplayed(collapseAllSkillsArrow);
   }

   public TrainingListPage performSearchInSkills(String searhTerm){
      getElement(skillsSearchInput).sendKeys(searhTerm);
      return this;
   }

   public TrainingListPage clearSkillsInput(){
      getElement(skillsSearchInput).clear();
      return this;
   }

   public List<WebElement> getSkillsSearchResultsElements(){
     return getElements(skillsSearchResultsList);
   }

   public boolean isSkillsSearchResultsPresent(){
      return !getElements(skillsSearchResultsList).isEmpty();
   }
}
