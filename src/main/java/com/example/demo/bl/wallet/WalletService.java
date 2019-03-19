package com.example.demo.bl.wallet;

import com.example.demo.db.wallet.WalletDao;
import com.example.demo.model.Response;
import com.example.demo.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletService {

    private WalletDao walletDao;

    @Autowired
    public WalletService(WalletDao walletDao) {
        this.walletDao = walletDao;
    }

    public List<Wallet> getWalletsFromUserByUserid(long userid) {
        return walletDao.getWalletsFromUserByUserid(userid);
    }

    public Response createWallet(Wallet wallet) {
        return walletDao.createWallet(wallet);
    }

    public Response deleteWalletById(long id) {
        return walletDao.deleteWalletById(id);
    }

    /*
    public Response updateCashByWalletId(long id, long cash) {
        if (cash < 0) {
            return new Response("Cash amount cannot be negative", false);
        }
        return walletDao.updateCashByWalletId(id, cash);
    }

    public Response updateCardByWalletId(long id, long card) {
        if (card < 0) {
            return new Response("Card amount cannot be negative", false);
        }
        return walletDao.updateCardByWalletId(id, card);
    }
    */

    public Response updateWalletById(long id, long cash, long card) {
        if (card < 0 || cash < 0) {
            return new Response("Amount cannot be negative", false);
        }
        return walletDao.updateWalletById(id, cash, card);
    }

    public Response addCardAmountByWalletId(long id, long amount) {
        return walletDao.addCardAmountByWalletId(id, amount);
    }

    public Response addCashAmountByWalletId(long id, long amount) {
        return walletDao.addCashAmountByWalletId(id, amount);
    }

}
