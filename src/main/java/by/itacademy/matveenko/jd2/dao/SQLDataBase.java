package by.itacademy.matveenko.jd2.dao;

import java.util.ArrayList;
import java.util.List;

import by.itacademy.matveenko.jd2.bean.UserRole;
import by.itacademy.matveenko.jd2.bean.NewUserInfo;

public class SQLDataBase {
	private List <NewUserInfo>  dataBase = new ArrayList<>();
	private static final SQLDataBase instance = new SQLDataBase();
	
	public SQLDataBase () {
		}
	
	 public SQLDataBase (List <NewUserInfo>  dataBase) {
		 instance.dataBase = dataBase;
		}
	
	public static SQLDataBase getInstance() {
		return instance;
	}	  
	
    public List <NewUserInfo> getDataBase(){
    	dataBase.add (new NewUserInfo ("Yury", "Matveenko", "korn1984@narod.ru", "KoRn", "KoRn1984", UserRole.ADMIN));
    	dataBase.add (new NewUserInfo ("Anastasia", "Koroleva", "koroleva@mail.ru", "Korolek", "Korolek1985", UserRole.USER));
		return dataBase;
    }
}