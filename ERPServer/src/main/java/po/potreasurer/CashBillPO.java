package po.potreasurer;

import java.io.Serializable;

import po.popublic.NotePO;
import vo.votreasurer.*;

/**
 * 现金费用单
 * @author CharlieLei
 *
 */
public class CashBillPO extends NotePO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//单据编号（XJFYD-yyyyMMdd-xxxxx）
	private String noteNumber;            
	//操作员（当前登录用户）
	private String userID;
	//银行账户
	private String companyAccountName;
	//转账列表(报销单据)
	private int expenseAccountItemNum;//列表项数
	private String[] itemNameList;//条目名
	private double[] amountList;//金额
	private String[] remarkList;//备注
	//总额
	private double totalAmount;
	//是否通过审批
	private boolean isPassed;
	//该单据是否通知过
	private boolean isInformed;
	
	public CashBillPO() {
		super("CashBill");
	}
	public CashBillPO(String noteNumber, String userID, String companyAccountName, 
			int expenseAccountItemNum, String[] itemNameList, double[] amountList, String[] remarkList, 
			double totalAmount, boolean isPassed, boolean isInformed){
		super("CashBill");
		this.noteNumber = noteNumber;
		this.userID = userID; 
		this.companyAccountName = companyAccountName; 
		this.expenseAccountItemNum = expenseAccountItemNum;
		this.itemNameList = itemNameList;
		this.amountList = amountList;
		this.remarkList = remarkList;
		this.totalAmount = totalAmount;
		this.isPassed = isPassed;
		this.isInformed = isInformed;
	}
	
	public CashBillVO toVO() {
		return new CashBillVO(this.noteNumber, this.userID, this.companyAccountName, 
				this.expenseAccountItemNum, this.itemNameList, this.amountList, this.remarkList, 
				this.totalAmount);
	}
	
	public String getNoteNumber() {return this.noteNumber;}
	public String getUserID() {return this.userID;}
	public String getCompanyAccountName() {return this.companyAccountName;}
	public int getExpenseAccountItemNum() {return this.expenseAccountItemNum;}
	public String[] getItemNameList() {return this.itemNameList;}
	public double[] getAmountList() {return this.amountList;}
	public String[] getRemarkList() {return this.remarkList;}
	public double getTotalAmount() {return this.totalAmount;}
	public boolean isPassed() {return this.isPassed;}
	public boolean isInformed() {return this.isInformed;}
	
	public void passTheApproval() {this.isPassed = true; this.isInformed = false;}
	public void hasInformedTheNote() {this.isInformed = true;}
}
