package by.itacademy.matveenko.jd2.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.itacademy.matveenko.jd2.bean.User;
import by.itacademy.matveenko.jd2.bean.UserRole;
import by.itacademy.matveenko.jd2.dao.DaoException;
import by.itacademy.matveenko.jd2.dao.IUserDao;
import by.itacademy.matveenko.jd2.dao.connectionpool.ConnectionPool;
import by.itacademy.matveenko.jd2.dao.connectionpool.ConnectionPoolException;

public class UserDao implements IUserDao{
	
    @Override
    public User findUserByLoginAndPassword(String login, String password) throws DaoException {
        String sql = "SELECT login, password, name, surname, email, roles.role as role from users join roles on roles.id = users.role where login=? and password=?";
        User user = new User();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, login);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                	user.setLogin(rs.getString("login"));
                	user.setPassword(rs.getString("password"));
                	user.setUserName(rs.getString("name"));
                	user.setUserSurname(rs.getString("surname"));
                	user.setEmail(rs.getString("email"));
                	user.setRole(UserRole.valueOf(rs.getString("role").toUpperCase()));
                    return user;
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } catch (ConnectionPoolException e) {
            throw new DaoException(e);
        }
        return null;
    }

    @Override
    public boolean saveUser(User user) throws DaoException {
        String sql = "INSERT INTO users(login, password, name, surname, email, role) values (?,?,?,?,?,?)";
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
            PreparedStatement ps = connection.prepareStatement(sql)) {
        	ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getUserName());
            ps.setString(4, user.getUserSurname());
            ps.setString(5, user.getEmail());
            ps.setInt(6, user.getRole().getRole());
            ps.executeUpdate();
        } catch (SQLException e) {
            return false;
        } catch (ConnectionPoolException e) {
            throw new DaoException(e);
        }
        return true;
    }
}