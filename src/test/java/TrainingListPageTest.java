import org.testng.annotations.Test;
import pageObjects.TrainingListPage;
import pageObjects.businessObjects.HomeBO;
import pageObjects.businessObjects.TrainingListBO;


public class TrainingListPageTest extends BaseTest {

   @Test(description = "Verify 'Trainings' search works properly with searching in 'Skills'")
   public void verifyTrainingsSearchWorksProperlyForSkills() {
      TrainingListBO trainingListBO = new TrainingListBO();

      new HomeBO()
            .proceedToHomePage()
            .clickSignInButton()
            .login("ivanhorintest@gmail.com","ivanhorintestPassword")
            .openPage(TrainingListPage.class);
      trainingListBO
              .expandSkillsModalWindow()
              .performSearchInSkills("Java")
              .verifyEachListElementContainsWord(trainingListBO.getSkillsSearchResultsTextList(),"Java");
      trainingListBO
              .clearSkillsInput()
            .performSearchInSkills("DATA")
            .verifyEachListElementContainsWord(trainingListBO.getSkillsSearchResultsTextList(),"Data");
      trainingListBO
            .clearSkillsInput()
            .performSearchInSkills("Pascal")
            .verifyNoSearchResultsAreReturnedForSkillsSearch();
   }
}
