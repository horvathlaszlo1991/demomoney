package com.example.demo.db.wallet;

import com.example.demo.db.user.UserDao;
import com.example.demo.model.Response;
import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import com.example.demo.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
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
            long wid = resultSet.getLong("id");
            long wcash = resultSet.getLong("cash");
            long wcard = resultSet.getLong("card");
            long wuserid = resultSet.getLong("user_id");
            byte wdeleted = resultSet.getByte("deleted");
            return new Wallet(wid, wcash, wcard, wuserid, wdeleted == 1);
        }
    }

    public List<Wallet> getWalletsFromUserByUserid(long userid) {
        try {
            return jdbcTemplate.query("SELECT id, cash, card, user_id, deleted " +
                            "FROM wallet WHERE user_id = ?", new WalletRowMapper(),
                    userid);
        } catch (DataAccessException dae) {
            return Collections.emptyList();
        }
    }


    public Response createWallet(Wallet wallet) {
        try {
            jdbcTemplate.update("INSERT INTO wallet (cash, card, user_id) VALUES (?, ?, ?);",
                    wallet.getCash(), wallet.getCard(), wallet.getUserId());
            return new Response("Wallet created succesfully", true);
        } catch (DataAccessException dae) {
            return new Response(dae.getMessage(), false);
        }
    }

    public Response deleteWalletById(long id) {
        try {
            jdbcTemplate.update("UPDATE wallet SET deleted = 1 WHERE id = ?", id);
            return new Response("Wallet deleted succesfully", true);
        } catch (DataAccessException dae) {
            return new Response(dae.getMessage(), false);
        }
    }

    /*
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
            return new Response("Card updated succesfully", true);
        } catch (DataAccessException dae) {
            return new Response(dae.getMessage(), false);
        }
    }
    */

    public Response updateWalletById(long id, long cash, long card) {
        try {
            jdbcTemplate.update("UPDATE wallet SET card = ?, cash = ? WHERE id = ?", card, cash, id);
            return new Response("Wallet updated succesfully", true);
        } catch (DataAccessException dae) {
            return new Response(dae.getMessage(), false);
        }
    }

    public Response addCashAmountByWalletId(long id, long amount) {
        try {
            jdbcTemplate.update("UPDATE wallet SET cash = cash + ? WHERE id = ?",
                    amount, id);
            return new Response("Cash amount added succesfully", true);
        } catch (DataAccessException dae) {
            return new Response(dae.getMessage(), false);
        }
    }

    public Response addCardAmountByWalletId(long id, long amount) {
        try {
            jdbcTemplate.update("UPDATE wallet SET card = card + ? WHERE id = ?",
                    id, amount, id);
            return new Response("Card amount added succesfully", true);
        } catch (DataAccessException dae) {
            return new Response(dae.getMessage(), false);
        }
    }


}
