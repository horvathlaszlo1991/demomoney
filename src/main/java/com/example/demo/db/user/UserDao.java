package com.example.demo.db.user;

import com.example.demo.model.Response;
import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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
            UserRole userRole = UserRole.valueOf(resultSet.getString("role"));
            return new User(id, name, email, password, false, userRole);
        }
    }

    public List<User> listActiveUsers() {
        return jdbcTemplate.query(
                "SELECT id, name, email, password, role FROM user WHERE deleted = 0 ORDER BY id ASC",
                new UserRowMapper()
        );
    }

    public List<User> listAllUsers() {
        return jdbcTemplate.query(
                "SELECT id, name, email, password, role FROM user ORDER BY id ASC",
                new UserRowMapper()
        );
    }

    public Response createUser(User user) {
        try {
            jdbcTemplate.update("INSERT INTO user(name, email, password) values (?, ?, ?)",
                    user.getName(), user.getEmail(), user.getPassword());
            return new Response("User succesfully created", true);
        } catch (DataAccessException dae) {
            return new Response(dae.getMessage(), false);
        }
    }

    public Response deleteUserById (long userid) {
        try {
            jdbcTemplate.update("UPDATE user SET deleted = 1 WHERE id = ?", userid);
            return new Response("User succesfully deleted", true);
        } catch (DataAccessException dae) {
            return new Response(dae.getMessage(), false);
        }
    }

    public Response updateUser (User user) {
        try {
            jdbcTemplate.update("UPDATE user SET name = ?, email = ?, password = ? WHERE id = ?",
                    user.getName(), user.getEmail(), user.getPassword(), user.getId());
            return new Response ("User updated succesfully", true);
        } catch (DataAccessException dae) {
            return new Response(dae.getMessage(), false);
        }
    }

    public Optional<User> findUserById (long id) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT id, name, email, password, role FROM user WHERE id = ?",
                    new UserRowMapper(), id));
        } catch (DataAccessException dae) {
            return Optional.empty();
        }
    }

    public Optional<User> findUserByEmail (String email) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT id, name, email, password, role FROM user WHERE email = ?",
                    new UserRowMapper(), email));
        } catch (DataAccessException dae) {
            return Optional.empty();
        }
    }

    public Optional<User> findUserByUsername (String username) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT id, name, email, password, role FROM user WHERE name = ?",
                    new UserRowMapper(), username));
        } catch (DataAccessException dae) {
            return Optional.empty();
        }
    }



}
