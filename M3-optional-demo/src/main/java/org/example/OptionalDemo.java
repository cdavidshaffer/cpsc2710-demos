package org.example;

import java.util.Optional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class OptionalDemo {

  public void go() {
    Optional<BankAccount> b1 = createAccount(true);

    b1.ifPresent(theAccount -> System.out.println("Balance: "+theAccount.getBalance()));

    Optional<BankAccount> b2 = createAccount(false);
    b2.ifPresent(theAccount -> System.out.println("Balance: "+theAccount.getBalance()));

    createAccountNoMatterWhat(null);
  }

  /**
   *
   * @param isRoom boolean indicating if there is room for a new account
   * @return an empty option if there's no room, otherwise an optional with a new BankAccount in it
   */
  public Optional<BankAccount> createAccount(boolean isRoom) {
    if (isRoom)
      return Optional.of(new BankAccount(100));
    else
      return Optional.empty();
  }

  public @NotNull BankAccount createAccountNoMatterWhat(@Nullable String ownerName) {
    return null;
  }

  public static void main(String[] args) {
    new OptionalDemo().go();
  }
}

class BankAccount {
  private int balance;

  public BankAccount(int balance) {
    this.balance = balance;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }
}