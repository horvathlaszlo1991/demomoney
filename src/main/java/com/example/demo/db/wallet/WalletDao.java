package com.example.demo.db.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WalletDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public WalletDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


}
