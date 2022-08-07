package by.itacademy.matveenko.jd2.util.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import by.itacademy.matveenko.jd2.bean.User;
import by.itacademy.matveenko.jd2.service.ServiceException;

public class UserDataValidationImpl implements UserDataValidation {
	private final static String NAME_PATTERN = "^([А-Я]{1}[а-яё]{1,23}|[A-Z]{1}[a-z]{1,23})$";
	private final static String SURNAME_PATTERN = "^([А-Я]{1}[а-яё]{1,23}|[A-Z]{1}[a-z]{1,23})$";
	private final static String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";
	private final static String LOGIN_PATTERN = "^[A-Za-z]([.A-Za-z0-9-]{1,18})([A-Za-z0-9])$";
	private final static String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^\\w\\s]).{6,}";
	private List<String> invalidRegistrationData = new ArrayList<>();

	@Override
	public boolean checkAuthDataLogination(String login, String password) {
		boolean result = false;
		if (login != null & password != null) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean checkAuthDataRegistration(User user) throws ServiceException {
		String userName = user.getUserName();
		String userSurname = user.getUserSurname();
		String login = user.getLogin();
		String password = user.getPassword();
		String email = user.getEmail();
		List<String> invalidRegistrationData = new ArrayList<>();
	
		if (!checkName(userName)) {
			invalidRegistrationData.add("Incorrect name!");
		}
		
		if (!checkSurname(userSurname)) {
			invalidRegistrationData.add("Incorrect surname!");
		}
		
		if (!checkEmail(email)) {
			invalidRegistrationData.add("Incorrect email!");
		}
		if (!checkLogin(login)) {
			invalidRegistrationData.add("Incorrect login!");
			}
		if (!checkPassword(password)) {
			invalidRegistrationData.add("Incorrect password!");
			}
		return checkName(userName) && checkSurname(userSurname) && checkEmail(email) && checkLogin(login) && checkPassword(password);
}
	
	@Override
	public List<String> getInvalidRegistrationData() {
		return invalidRegistrationData;
	}
	
	private boolean checkName(String userName) {
		return Pattern.compile(NAME_PATTERN).matcher(userName).matches();
	}
	
	private boolean checkSurname(String userSurname) {
		return Pattern.compile(SURNAME_PATTERN).matcher(userSurname).matches();
	}
	
	private boolean checkEmail(String email) {
		return Pattern.compile(EMAIL_PATTERN).matcher(email).matches();
	}
	
	private boolean checkLogin(String login) {
		return Pattern.compile(LOGIN_PATTERN).matcher(login).matches();
	}
	
	private boolean checkPassword(String password) {
		return Pattern.compile(PASSWORD_PATTERN).matcher(password).matches();
	}
}