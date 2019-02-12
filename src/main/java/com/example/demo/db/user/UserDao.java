package com.example.demo.db.user;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            return new User(id, name, email, password);
        }
    }

    public List<User> listActiveUsers() {
        return jdbcTemplate.query(
                "SELECT id, name, email, password FROM user WHERE deleted = 0 ORDER BY id ASC",
                new UserRowMapper()
        );
    }

    public List<User> listAllUsers() {
        return jdbcTemplate.query(
                "SELECT id, name, email, password FROM user ORDER BY id ASC",
                new UserRowMapper()
        );
    }

}
