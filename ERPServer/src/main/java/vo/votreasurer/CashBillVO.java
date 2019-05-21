package vo.votreasurer;

import po.potreasurer.CashBillPO;
import vo.vopublic.NoteVO;

/**
 * 现金费用单
 * @author CharlieLei
 *
 */
public class CashBillVO extends NoteVO{
	//单据编号
	private String noteNumber;            
	//操作员
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
	
	public CashBillVO(String noteNumber,String currentUserID, String companyAccountName, 
			int expenseAccountItemNum, String[] itemNameList, double[] amountList, String[] remarkList, 
			double totalAmount){
		super("CashBill");
		this.noteNumber = noteNumber;
		this.userID = currentUserID; 
		this.companyAccountName = companyAccountName;
		this.expenseAccountItemNum = expenseAccountItemNum;
		this.itemNameList = itemNameList;
		this.amountList = amountList;
		this.remarkList = remarkList;
		this.totalAmount = totalAmount;
	}
	
	public CashBillPO toPO() {
		return new CashBillPO(this.noteNumber, this.userID, this.companyAccountName, 
				this.expenseAccountItemNum, this.itemNameList, this.amountList, this.remarkList, 
				this.totalAmount, false, false);
	}
	
	public String getNoteNumber() {return this.noteNumber;}
	public String getUserID() {return this.userID;}
	public String getCompanyAccountName() {return this.companyAccountName;}
	public int getExpenseAccountItemNum() {return this.expenseAccountItemNum;}
	public String[] getItemNameList() {return this.itemNameList;}
	public double[] getAmountList() {return this.amountList;}
	public String[] getRemarkList() {return this.remarkList;}
	public double getTotalAmount() {return this.totalAmount;}
	
	public void setModified() {this.noteNumber = this.noteNumber + "Modified";}
}
