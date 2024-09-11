class Account(var balance: Double) {

  def deposit(amount: Double): Unit = {
    balance += amount
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) balance -= amount
    else println("Insufficient funds")
  }

  def transfer(amount: Double, that: Account): Unit = {
    if (amount <= balance) {
      this.withdraw(amount)
      that.deposit(amount)
    } else println("Insufficient funds for transfer")
  }

  override def toString: String = s"Balance: ${balance}"
}

class Bank(val accounts: List[Account]) {

  def accountsWithNegativeBalances: List[Account] = accounts.filter(_.balance < 0)

  def sumOfAllBalances: Double = accounts.map(_.balance).sum

  def applyInterest(): Unit = {
    accounts.foreach(account => {
      if (account.balance > 0) account.deposit(account.balance * 0.05)
      else account.balance += account.balance * 0.1
    })
  }

  override def toString: String = {
    accounts.zipWithIndex.map { case (acc, i) => s"Account ${i + 1}: $acc" }.mkString("\n")
  }
}

object AccountTest {
  def main(args: Array[String]): Unit = {
    val account1 = new Account(1000)
    val account2 = new Account(500)
    val account3 = new Account(5000)
    val account4 = new Account(-450)

    val bank = new Bank(List(account1, account2, account3, account4))

    //question 03
    println(".................Question 03....................\n")

    println(s"Initial Balance of account1: $account1")
    println(s"Initial Balance of account2: $account2")

    account1.deposit(200)
    println(s"Balance of account1 after deposit: $account1")

    account2.withdraw(100)
    println(s"Balance of account2 after withdrawal: $account2")

    account1.transfer(300, account2)
    println(s"Balance of account1 after transfer: $account1")
    println(s"Balance of account2 after receiving transfer: $account2")

    account1.transfer(1000, account2)

    //question 04
    println(".................Question 04....................\n")

    println("Bank accounts with negative balances: " + bank.accountsWithNegativeBalances.mkString(", "))
    println(s"Sum of all balances: ${bank.sumOfAllBalances}")

    println("Applying interest:")
    bank.applyInterest()
    println(bank)
  }
}
