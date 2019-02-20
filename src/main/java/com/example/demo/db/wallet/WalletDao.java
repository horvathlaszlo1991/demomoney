package com.example.demo.db.wallet;

import com.example.demo.db.user.UserDao;
import com.example.demo.model.Response;
import com.example.demo.model.User;
import com.example.demo.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Repository
public class WalletDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public WalletDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    private static class WalletRowMapper implements RowMapper<Wallet> {
        @Override
        public Wallet mapRow(ResultSet resultSet, int i) throws SQLException {
            long wid = resultSet.getLong("wallet.id");
            long wcash = resultSet.getLong("wallet.cash");
            long wcard = resultSet.getLong("wallet.card");
            long wuserid = resultSet.getLong("wallet.user_id");
            String uname = resultSet.getString("user.name");
            String uemail = resultSet.getString("user.email");
            String upass = resultSet.getString("user.password");
            return new Wallet(wid, wcash, wcard, new User(wuserid, uname, uemail, upass));
        }
    }

    public List<Wallet> getWalletsFromUserByUserid(long userid) {
        try {
            return jdbcTemplate.query("SELECT wallet.id, wallet.cash, wallet.card, wallet.user_id, " +
                            "user.name, user.email, user.password " +
                            "FROM wallet JOIN user ON wallet.user_id = user.id WHERE wallet.user_id = ?", new WalletRowMapper(),
                    userid);
        } catch (DataAccessException dae) {
            return Collections.emptyList();
        }
    }

    /*
    public List<Wallet> getWalletsFromUserByUserid(long userid) {
        try {
            return jdbcTemplate.query("SELECT id, cash, card, user_id FROM wallet WHERE user_id = ?", new WalletRowMapper(),
                    userid);
        } catch (DataAccessException dae) {
            return Collections.emptyList();
        }
    }
    */


    public Response createWallet(Wallet wallet) {
        try {
            jdbcTemplate.update("INSERT INTO wallet (cash, card, user_id) VALUES (?, ?, ?);",
                    wallet.getCash(), wallet.getCard(), wallet.getUser().getId());
            return new Response("Wallet created succesfully", true);
        } catch (DataAccessException dae) {
            return new Response(dae.getMessage(), false);
        }
    }

    public Response deleteWalletById(long id) {
        try {
            jdbcTemplate.update("upDATE wallet SET deleted = 1 WHERE id = ?", id);
            return new Response("Wallet deleted succesfully", true);
        } catch (DataAccessException dae) {
            return new Response(dae.getMessage(), false);
        }
    }

    public Response updateCashByWalletId(long id, long cash) {
        try {
            jdbcTemplate.update("UPDATE wallet SET cash = ? WHERE id = ?", cash, id);
            return new Response("Cash updated succesfully", true);
        } catch (DataAccessException dae) {
            return new Response(dae.getMessage(), false);
        }
    }

    public Response updateCardByWalletId(long id, long card) {
        try {
            jdbcTemplate.update("UPDATE wallet SET card = ? WHERE id = ?", card, id);
            return new Response("Cash updated succesfully", true);
        } catch (DataAccessException dae) {
            return new Response(dae.getMessage(), false);
        }
    }


}
