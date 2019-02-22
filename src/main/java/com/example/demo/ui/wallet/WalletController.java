package com.example.demo.ui.wallet;

import com.example.demo.bl.wallet.WalletService;
import com.example.demo.model.Response;
import com.example.demo.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WalletController {

    private WalletService walletService;

    @Autowired
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }


    @RequestMapping(value = "/wallets/{userid}", method = RequestMethod.GET)
    public List<Wallet> getWalletsFromUserByUserid(@PathVariable long userid) {
        return walletService.getWalletsFromUserByUserid(userid);
    }

    @RequestMapping(value = "/wallets/updatecard/{walletid}", method = RequestMethod.POST)
    public Response changeCardAmount(@PathVariable long walletid, @RequestParam long amount) {
        return walletService.changeCardAmountByWalletId(walletid, amount);
    }

    @RequestMapping(value = "/wallets/updatecash/{walletid}", method = RequestMethod.POST)
    public Response changeCashAmount(@PathVariable long walletid, @RequestParam long amount) {
        return walletService.changeCashAmountByWalletId(walletid, amount);
    }
}
