package test;

import by.itacademy.matveenko.jd2.dao.DaoException;
import by.itacademy.matveenko.jd2.dao.impl.UserDao;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void findById() throws SQLException, DaoException {
        UserDao dao = new UserDao();
        var user = dao.findById(1);
        assertTrue(user.getUserName().equalsIgnoreCase("rob"));

    }
}