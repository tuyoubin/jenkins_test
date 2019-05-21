package initialization;


public class UserDataInitializer {
	
	public UserDataInitializer(){
		
	}
	public static void userDataInitializer(){
		UserData user = new UserData();
		user.insert();
	}
}
