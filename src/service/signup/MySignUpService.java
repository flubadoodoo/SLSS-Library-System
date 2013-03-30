package service.signup;

import org.jdesktop.swingx.auth.LoginService;

import user.User;

public class MySignUpService extends LoginService {
	
	public boolean authenticate(String name, char[] pass, String server) {
		return User.initializeUser(name, new String(pass));
	}
	
}
