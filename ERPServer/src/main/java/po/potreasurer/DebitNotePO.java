package po.potreasurer;

import java.io.Serializable;

import po.popublic.NotePO;
import vo.votreasurer.DebitNoteVO;

/**
 * 收款单
 * @author CharlieLei
 *
 */
public class DebitNotePO extends NotePO implements Serializable {
	private static final long serialVersionUID = 1L;
	//单据编号（SKD##-yyyyMMdd-xxxxx）
	private String noteNumber;
	//销售商
	private String sellerName;
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
	
	public DebitNotePO(String noteNumber, String sellerName, String userID, 
			int transferListItemNum, String[] accountNameList, double[] transferAmountList, String[] remarkList,
			double totalAmount, boolean isPassed, boolean isInformed){
		super("DebitNote");
		this.noteNumber = noteNumber;
		this.sellerName = sellerName;
		this.userID = userID; 
		this.transferListItemNum = transferListItemNum;	
		this.accountNameList = accountNameList;	
		this.transferAmountList = transferAmountList;	
		this.remarkList = remarkList;		
		this.totalAmount = totalAmount;
		this.isPassed = isPassed;
		this.isInformed = isInformed;
	}
	
	public DebitNoteVO toVO() {
		return new DebitNoteVO(this.noteNumber, this.sellerName, this.userID, 
				this.transferListItemNum, this.accountNameList, this.transferAmountList, this.remarkList, 
				this.totalAmount);
	}
	
	public String getNoteNumber() {return this.noteNumber;}
	public String getSellerName() {return this.sellerName;}
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
