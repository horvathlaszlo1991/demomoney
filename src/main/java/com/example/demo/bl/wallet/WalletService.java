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

    public Response updateCashByWalletId(long id, long cash) {
        return walletDao.updateCashByWalletId(id, cash);
    }

    public Response updateCardByWalletId(long id, long card) {
        return walletDao.updateCardByWalletId(id, card);
    }

    public Response changeCardAmountByWalletId(long id, long amount) {
        return walletDao.changeCardAmountByWalletId(id, amount);
    }

    public Response changeCashAmountByWalletId(long id, long amount) {
        return walletDao.changeCashAmountByWalletId(id, amount);
    }

}
