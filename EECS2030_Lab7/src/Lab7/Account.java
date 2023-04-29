package Lab7;
import java.util.Date;
import java.util.Objects;


public abstract class Account implements Comparable<Account> {
	// define the instance variables based on the given UML, here. 
	protected int accountNo;
	protected double balance;
	protected String fullName;
	protected Date dateOpened;
	protected double maxTransferable;
	
	
	/**
	 * This method deposit <code> amount </code> to this account.
	 * @param amount is the amount that is deposited to this account. 
	 */
	public abstract void deposit(double amount);
	
	
	/**
	 * This method withdraw <code> amount </code> from this account.
	 * @param amount is the amount that should be withdrawn from this account
	 * @return It returns true if the transaction is done successfully. 
	 * @throws Exception This methods may throw either <code> NotEnoughMoneyException </code> or
	 * <code> TransferNotAllowedException </code>.
	 */
	public abstract boolean withdraw(double amount) throws TransferNotAllowedException;
	
	/**
	 * This method transfers money from this account to the given account.
	 * @param to is the destination account, where the money is deposited to.
	 * @param amount is the amount of money that is transfered. 
	 * @return It returns true if the transaction is successful. 
	 * @throws Exception This methods may throw either <code> NotEnoughMoneyException </code> or
	 * <code> TransferNotAllowedException </code>.
	 */
	public boolean transferFrom(Account to, double amount) throws TransferNotAllowedException {
		
		if (this.balance < amount) {
			throw new NotEnoughMoneyException();
		}
		else if (amount > this.maxTransferable) {
			throw new TransferNotAllowedException();
		} else {
			this.balance -= amount;
			to.balance += amount;
			return true;
		}

		
	}
	
	
	
	/**
	 * This is the accessor method for <code> accountNo </code>
	 * @return It returns the accountNo of this account.
	 */
	public int getAccountNo() {
		return this.accountNo;
	}
	
	
	/**
	 * This is the accessor method for <code> balance </code>
	 * @return It returns the balance of the account.
	 */
	public double getBalance() {
		return this.balance;
	}
	
	
	/**
	 * This is the accessor method for <code> fullName </code>
	 * @return It returns the name of the holder of the account.
	 */
	public String getFullName() {
		return this.fullName;
	}
	
	
	/**
	 * This is the accessor method for <code> dateOpened </code>
	 * @return It returns the date at which the account was opened.
	 */
	public Date getDateOpened() {
		return this.dateOpened;
	}
	
	
	/**
	 * This is the accessor method for <code> maxTransferable </code>
	 * @return It returns the maximum allowed amount that can be withdrawn from this account in one transaction.
	 */
	public double getMaxTransferable() {
		return this.maxTransferable;
	}
	
	
	
	
	
	/**
	 * This method compares two accounts. If the two accounts have the same values
	 * for all the instance variables, they are considered, equal and this 
	 * method returns 0. If two objects were not equal, the account whose accountNo is less, 
	 * is the smaller object so this method returns -1. Otherwise it returns 1.
	 * @param object is an object of type account. 
	 * @return<pre> It returns 0, if the two objects are equal. 
	 * It returns -1, if this object is less than the object that is passed as a parameter into the method. 
	 * It returns 1, if this object is greater than the object that is passed as a parameter into the method<pre>. 
	 */
	@Override
	public int compareTo(Account object) {
		if (this.accountNo == object.accountNo && this.balance == object.balance && this.fullName == object.fullName && this.dateOpened == object.dateOpened && this.maxTransferable == object.maxTransferable) {
			return 0;
		} else if (this.accountNo < object.accountNo) {
			return -1;
		} else {
			return 1;
		}
		
	}
}

	
// Implement class Current based on the given UML in the description. 
	class Current extends Account {
		
		public Current(int accountNo, double balance, String fullName, Date dateOpened, double maxTransferable) {
			this.accountNo = accountNo;
			this.balance = balance;
			this.fullName = fullName;
			this.dateOpened = dateOpened;
			this.maxTransferable = maxTransferable;
		}
		
		public boolean equals(Object acc) {
			if (!(acc instanceof Account)) {
				return false;
			}
			
			return super.compareTo((Account) acc) == 0;
		}
		
		public int hashCode() {
			
			return super.hashCode();
		}
 
	

		@Override
		public void deposit(double amount) {
			this.balance += amount;
			
		}
		
		
		/**
		 * This method withdraw <code> amount </code> from this account.
		 * @param amount is the amount that should be withdrawn from this account
		 * @return It returns true if the transaction is done successfully. 
		 * @throws Exception This methods may throw either <code> NotEnoughMoneyException </code> or
		 * <code> TransferNotAllowedException </code>.
		 */
		@Override
		public boolean withdraw(double amount) throws TransferNotAllowedException {
			// TODO Auto-generated method stub
			if (balance < amount) {
				throw new NotEnoughMoneyException();
			} else if (amount > this.maxTransferable) {
				throw new TransferNotAllowedException();
			} else {
				balance -= amount;
				return true;
			}
			
			
		}
		
		/**
		 * This method compares two accounts. If the two accounts have the same values
		 * for all the instance variables, they are considered, equal and this 
		 * method returns 0. If two objects were not equal, the account whose accountNo is less, 
		 * is the smaller object so this method returns -1. Otherwise it returns 1.
		 * @param object is an object of type account. 
		 * @return<pre> It returns 0, if the two objects are equal. 
		 * It returns -1, if this object is less than the object that is passed as a parameter into the method. 
		 * It returns 1, if this object is greater than the object that is passed as a parameter into the method<pre>. 
		 */
		
	}

//Define the Exception classes here
class TransferNotAllowedException extends Exception {
	public TransferNotAllowedException() {
		
	}
	
	public TransferNotAllowedException(String message) {
		super(message);
	}
}

class NotEnoughMoneyException extends TransferNotAllowedException {
	public NotEnoughMoneyException() {
		
	}
	
	public NotEnoughMoneyException(String message) {
		super(message);
	}
}



