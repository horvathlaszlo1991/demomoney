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

    @RequestMapping(value = "/wallets/create", method = RequestMethod.POST)
    public Response createWallet(@RequestBody Wallet wallet) {
        return walletService.createWallet(wallet);
    }

    @RequestMapping(value = "/wallets/{userid}", method = RequestMethod.GET)
    public List<Wallet> getWalletsFromUserByUserid(@PathVariable long userid) {
        return walletService.getWalletsFromUserByUserid(userid);
    }

    @RequestMapping(value = "/wallets/addcard/{walletid}", method = RequestMethod.POST)
    public Response addCardAmount(@PathVariable long walletid, @RequestParam long amount) {
        return walletService.addCardAmountByWalletId(walletid, amount);
    }

    @RequestMapping(value = "/wallets/addcash/{walletid}", method = RequestMethod.POST)
    public Response addCashAmount(@PathVariable long walletid, @RequestParam long amount) {
        return walletService.addCashAmountByWalletId(walletid, amount);
    }

    @RequestMapping(value = "/wallets/delete", method = RequestMethod.DELETE)
    public Response deleteWalletById(@RequestParam long id) {
        return walletService.deleteWalletById(id);
    }


    @RequestMapping(value = "/wallets/updatewallet/{walletid}", method = RequestMethod.POST)
    public Response updateWallet(@PathVariable long walletid, @RequestParam long cash, @RequestParam long card) {
        return walletService.updateWalletById(walletid, cash, card);
    }

    /*
    @RequestMapping(value = "/wallets/updatecard/{walletid}", method = RequestMethod.POST)
    public Response updateCardAmount(@PathVariable long walletid, @RequestParam long amount) {
        return walletService.updateCardByWalletId(walletid, amount);
    }

    @RequestMapping(value = "/wallets/updatecash/{walletid}", method = RequestMethod.POST)
    public Response updateCashAmount(@PathVariable long walletid, @RequestParam long amount) {
        return walletService.updateCashByWalletId(walletid, amount);
    }
    */

}
