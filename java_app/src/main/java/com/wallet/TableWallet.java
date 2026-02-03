//3
package com.wallet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Entity
public class TableWallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long walletId;
    private String currency;
    private BigDecimal money;
    private BigDecimal deposit;
    private float withdrawal;

    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public float getWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(float withdrawal) {
        this.withdrawal = withdrawal;
    }

}

@Repository
interface RepositoryTableWallet extends CrudRepository <TableWallet, Long>{
}
