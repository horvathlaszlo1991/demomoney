package com.example.demo.ui.wallet;

import com.example.demo.bl.wallet.WalletService;
import com.example.demo.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WalletController {

    private WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @RequestMapping(value = "/wallets/{userid}", method = RequestMethod.GET)
    public String getWalletsFromUserByUserid(@PathVariable long userid) {
        //return "Hello " + userid;
        return walletService.getWalletsFromUserByUserid(userid).get(0).toString();
    }
}
