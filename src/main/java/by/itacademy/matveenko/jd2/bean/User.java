package by.itacademy.matveenko.jd2.bean;

import com.google.common.base.Objects;

public class User {
    private Integer id;
	private String name;
    private String surname;
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
    	this.name = userName;
        this.surname = userSurname;
        this.email = email;        
        this.role = role;
    }

    public static class Builder{
        private User newUser;

        public Builder(){
            this.newUser = new User();
        }

        public Builder withLogin(String login){
            newUser.setLogin(login);
            return this;
        }
        public Builder withPassword(String password){
            newUser.setPassword(password);
            return this;
        }
        public Builder withName(String name){
            newUser.setName(name);
            return this;
        }
        public Builder withSurname(String surname){
            newUser.setSurname(surname);
            return this;
        }

        public Builder withEmail(String email){
            newUser.setEmail(email);
            return this;
        }

        public Builder withRole(UserRole role){
            newUser.setRole(role);
            return this;
        }

        public Builder withId(Integer id){
            newUser.setId(id);
            return this;
        }

        public User build(){
            return newUser;
        }
    }


    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
        return Objects.equal(name, that.name) && Objects.equal(surname, that.surname) && Objects.equal(email, that.email)
        	   && Objects.equal(login, that.login) && Objects.equal(password, that.password) && Objects.equal(role, that.role);
    }
    
    @Override
	public int hashCode() {
		return Objects.hashCode(name, surname, email, login, password, role);
	}

	@Override
    public String toString() {
        return "NewUserInfo{" +
                "userName='" + name + '\'' +
                ", userSurname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password=" + password +
                ", role='" + role + '\'' +
                '}';
    }  
}