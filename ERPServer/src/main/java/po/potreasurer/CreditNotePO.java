package po.potreasurer;

import java.io.Serializable;

import po.popublic.NotePO;
import vo.votreasurer.*;

/**
 * 付款单
 * @author CharlieLei
 *
 */
public class CreditNotePO extends NotePO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//单据编号（FKD-yyyyMMdd-xxxxx）
	private String noteNumber;
	//供应商
	private String supplierName;
	//操作员（当前登录用户）
	private String userID;
	//转账列表
	private int transferListItemNum;//转账列表项
	private String[] accountNameList;//银行账户
	private double[] transferAmountList;//转账金额
	private String[] remarkList;//备注
	//总额汇总
	private double totalAmount;
	//是否通过审批
	private boolean isPassed;
	//该单据是否通知过
	private boolean isInformed;
	
	public CreditNotePO(String noteNumber, String supplierName, String userID, 
			int transferListItemNum, String[] accountNameList, double[] transferAmountList, String[] remarkList,
			double totalAmount, boolean isPassed, boolean isInformed){
		super("CreditNote");
		this.noteNumber = noteNumber;
		this.supplierName = supplierName;
		this.userID = userID; 
		this.transferListItemNum = transferListItemNum;	
		this.accountNameList = accountNameList;	
		this.transferAmountList = transferAmountList;	
		this.remarkList = remarkList;	
		this.totalAmount = totalAmount;
		this.isPassed = isPassed;
		this.isInformed = isInformed;
	}
	
	public CreditNoteVO toVO() {
		return new CreditNoteVO(this.noteNumber, this.supplierName, this.userID, 
				this.transferListItemNum, this.accountNameList, this.transferAmountList, this.remarkList,
				this.totalAmount);
	}
	
	public String getNoteNumber() {return this.noteNumber;}
	public String getSupplierName() {return this.supplierName;}
	public String getUserID() {return this.userID;}
	public int getTransferListItemNum() {return this.transferListItemNum;}
	public String[] getAccountNameList() {return this.accountNameList;}
	public double[] getTransferAmountList() {return this.transferAmountList;}
	public String[] getRemarkList() {return this.remarkList;}
	public double getTotalAmount() {return this.totalAmount;}
	public boolean isPassed() {return this.isPassed;}
	public boolean isInformed() {return this.isInformed;}
	
	public void passTheApproval() {this.isPassed = true;}
	public void hasInformedTheNote() {this.isInformed = true;}
}
