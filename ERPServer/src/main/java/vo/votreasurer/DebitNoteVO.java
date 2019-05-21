package vo.votreasurer;

import po.potreasurer.DebitNotePO;
import vo.vopublic.NoteVO;

/**
 * 收款单
 * @author CharlieLei
 *
 */
public class DebitNoteVO extends NoteVO{
	//单据编号
	private String noteNumber;
	//销售商
	private String sellerName;
	//操作员
	private String userID;
	//转账列表
	private int transferListItemNum;//转账列表项
	private String[] accountNameList;//银行账户
	private double[] transferAmountList;//转账金额
	private String[] remarkList;//备注
	//总额汇总
	private double totalAmount;
	
	public DebitNoteVO(String noteNumber, String sellerName, String currentUserID, 
			int transferListItemNum, String[] accountNameList, double[] transferAmountList, String[] remarkList,
			double totalAmount){
		super("DebitNote");
		this.noteNumber = noteNumber; 
		this.sellerName = sellerName; 
		this.userID = currentUserID; 
		this.transferListItemNum = transferListItemNum;	
		this.accountNameList = accountNameList;	
		this.transferAmountList = transferAmountList;	
		this.remarkList = remarkList;
		this.totalAmount = totalAmount;		
	}
	
	public DebitNotePO toPO() {
		return new DebitNotePO(this.noteNumber, this.sellerName, this.userID, 
				this.transferListItemNum, this.accountNameList, this.transferAmountList, this.remarkList, 
				this.totalAmount, false, false);
	}
	
	public String getNoteNumber() {return this.noteNumber;}
	public String getSellerName() {return this.sellerName;}
	public String getUserID() {return this.userID;}
	public int getTransferListItemNum() {return this.transferListItemNum;}
	public String[] getAccountNameList() {return this.accountNameList;}
	public double[] getTransferAmountList() {return this.transferAmountList;}
	public String[] getRemarkList() {return this.remarkList;}
	public double getTotalAmount() {return this.totalAmount;}
	
	public void setModified() {this.noteNumber = this.noteNumber + "Modified";}
}
