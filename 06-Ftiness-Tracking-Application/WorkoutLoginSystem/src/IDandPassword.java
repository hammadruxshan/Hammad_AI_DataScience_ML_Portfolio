import java.util.HashMap;

public class IDandPassword {
    HashMap<String,String>logininfo=new HashMap<String,String>();
    IDandPassword(){
        logininfo.put("User","1234");
        logininfo.put("User1","1234");
        logininfo.put("User2","1234");
        logininfo.put("User3", "1234");
        
    }
    public HashMap getLoginInfo(){
        return logininfo;
    }
}
