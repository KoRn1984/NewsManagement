package by.itacademy.matveenko.jd2.bean;

import com.google.common.base.Objects;

import by.itacademy.matveenko.jd2.bean.User;

public class User {	
	private String userName;
    private String userSurname;
    private String email;
    private String login;
    private String password;
    private UserRole role;

    public User() {
    }

    //TODO builder      
    public User(String login, String password, String userName, String userSurname, String email, UserRole role) {    	
    	this.login = login;
        this.password = password;
    	this.userName = userName;
        this.userSurname = userSurname;
        this.email = email;        
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User that = (User) obj;
        return Objects.equal(userName, that.userName) && Objects.equal(userSurname, that.userSurname) && Objects.equal(email, that.email)
        	   && Objects.equal(login, that.login) && Objects.equal(password, that.password) && Objects.equal(role, that.role);
    }
    
    @Override
	public int hashCode() {
		return Objects.hashCode(userName, userSurname, email, login, password, role);
	}

	@Override
    public String toString() {
        return "NewUserInfo{" +
                "userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password=" + password +
                ", role='" + role + '\'' +
                '}';
    }  
}