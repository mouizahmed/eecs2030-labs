package test;



class BankAccountException extends Exception { // code was removed

}
class WithdrawTransactionException extends BankAccountException {
	// code was removed
}
class WithdrawBalanceException extends WithdrawTransactionException {
	// code was removed
}
class DepositTransactionException extends BankAccountException {
	// code was removed
}




public class writtentest2 {

	
	public void doSomething2 (double amount) {
		try { 
			if ((amount > 0) && (amount < 10))
				throw new WithdrawTransactionException(); 
			else if ((amount > 0) && (amount < 1000))
				amount -= Math.round(amount / 100) * 0.5; 
			else
				throw new WithdrawBalanceException();
		} catch (WithdrawTransactionException e) { 
			amount = 1000;
			amount -= Math.round (amount / 100) * 0.5; 
		} catch ( WithdrawBalanceException e) { 
			amount = 0; } 
		finally {
			amount = amount + 1;
			System.out.println (amount);
		}
	
	
}
}
