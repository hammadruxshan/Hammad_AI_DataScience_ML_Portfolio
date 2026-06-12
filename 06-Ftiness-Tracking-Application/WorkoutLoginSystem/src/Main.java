
public class Main {

   
    public static void main(String[] args) {
        IDandPassword idandPasswords=new IDandPassword();
        LoginPage loginpage=new LoginPage(idandPasswords.getLoginInfo()) ;
        
        LivePage livepage = new LivePage();
        CoachPage coachpage = new CoachPage();
        TodayPage todaypage = new TodayPage();
        CustomerSupportPage customersuppportpage = new CustomerSupportPage ();
        PersonalDataPage personaldatapage = new PersonalDataPage();
        AchievementPage achievementpage = new AchievementPage();
        SocialPage socialpage = new SocialPage();
        PostPage postpage = new PostPage();
        ChatPage chatpage = new ChatPage();
        ProfilePage profilepage = new ProfilePage();
        PersonalProfilePage personalprofilepage = new PersonalProfilePage();
        ProfileEditPage profileeditpage = new ProfileEditPage();
        TargetPage targetpage = new TargetPage();
    }
    
}
