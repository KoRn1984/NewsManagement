package by.itacademy.matveenko.jd2.bean;

import com.google.common.base.Objects;

import by.itacademy.matveenko.jd2.bean.NewUserInfo;

public class NewUserInfo {	
	private Integer id;
	private String userName;
    private String userSurname;
    private String email;
    private String login;
    private String password;
    private String role;

    public NewUserInfo() {
    }

    //TODO builder
    public NewUserInfo(String userName, String userSurname, String email, String login, String role) {
    	this.userName = userName;
        this.userSurname = userSurname;
        this.email = email;
        this.login = login;       
        this.role = role;
    }
    
    public NewUserInfo(String userName, String userSurname, String email, String login, String password, String role) {    	
    	this.userName = userName;
        this.userSurname = userSurname;
        this.email = email;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NewUserInfo that = (NewUserInfo) obj;
        return Objects.equal(id, that.id) && Objects.equal(userName, that.userName) && Objects.equal(userSurname, that.userSurname) && Objects.equal(email, that.email)
        	   && Objects.equal(login, that.login) && Objects.equal(password, that.password) && Objects.equal(role, that.role);
    }
    
    @Override
	public int hashCode() {
		return Objects.hashCode(id, userName, userSurname, email, login, password, role);
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