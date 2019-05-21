package vo.votreasurer;

import po.potreasurer.*;

/**
 * 公司的银行账户
 * @author CharlieLei
 *
 */
public class CompanyAccountVO {
	//银行账户名称
	private String accountName;
	//余额
	private double accountBalance;

	public CompanyAccountVO(String accountName, double accountBalance) {
		this.accountName = accountName; 
		this.accountBalance = accountBalance;
	}
	
	public CompanyAccountPO toPO() {
		return new CompanyAccountPO(this.accountName, this.accountBalance);
	}
	
	public String getAccountName() {return this.accountName;}
	public double getAccountBalance() {return this.accountBalance;}	
}
