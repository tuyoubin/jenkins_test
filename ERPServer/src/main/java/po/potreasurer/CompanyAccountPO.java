package po.potreasurer;

import java.io.Serializable;

import vo.votreasurer.*;

/**
 * 银行账户
 * @author CharlieLei
 *
 */
public class CompanyAccountPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//银行账户名称
	private String accountName;
	//余额
	private double accountBalance;

	public CompanyAccountPO(String accountName, double accountBalance) {
		this.accountName = accountName; 
		this.accountBalance = accountBalance;
	}
	
	public CompanyAccountVO toVO() {
		return new CompanyAccountVO(this.accountName, this.accountBalance);
	}
	
	public String getAccountName() {return this.accountName;}
	public double getAccountBalance() {return this.accountBalance;}	
	public void setAccountName(String accountName) {this.accountName = accountName;}
	public void setAccountBalance(int newAccountBalance) {this.accountBalance = newAccountBalance;}
}
