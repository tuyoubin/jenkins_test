package vo.vostock;

import vo.vopublic.NoteVO;
import po.postock.StockOverflowNotePO;

/**
 * 库存报溢单
 */
public class StockOverflowNoteVO extends NoteVO{
	
	public StockOverflowNoteVO(String noteNumber, String userID,  int goodsListItemNum, String[] goodsIDList,
			String[] goodsNameList, int[] stockAmounts, int[] realAmounts, boolean isPassed) {
		super("StockOverflowNote");
		this.noteNumber = noteNumber;
		this.userID = userID;
		this.isPassed = isPassed;
		this.goodsListItemNum = goodsListItemNum;
		this.goodsIDList = goodsIDList;
		this.goodsNameList = goodsNameList;
		this.stockAmounts = stockAmounts;
		this.realAmounts = realAmounts;
	}

	//单据编号 KCBYD-yyyyMMdd-HHmmss
	private String noteNumber;            

	//操作员
	private String userID;
	
	//是否通过审批
	boolean isPassed;

	//商品列表项数
	private int goodsListItemNum;
	
	//商品编号列表
	private String[] goodsIDList;
	
	//商品名称列表
	private String[] goodsNameList;
	
	//系统库存数量
	private int[] stockAmounts;
	
	//实际数量
	private int[] realAmounts;

	public StockOverflowNotePO toPO() {
		StockOverflowNotePO po = new StockOverflowNotePO(noteNumber, userID,  goodsListItemNum,
				goodsIDList, goodsNameList, stockAmounts, realAmounts, isPassed);
		return po;
	}
	
	public String getNoteNumber(){
		return noteNumber;
	}
	
	public String getUserID(){
		return userID;
	}
	
	public boolean isPassed(){
		return isPassed;
	}
	
	public int getGoodsListItemNum(){
		return goodsListItemNum;
	}
	
	public String[] getGoodsIDList(){
		return goodsIDList;
	}
	
	public String[] getGoodsNameList(){
		return goodsNameList;
	}
	
	public int[] getStockAmounts(){
		return stockAmounts;
	}
	
	public int[] getRealAmounts(){
		return realAmounts;
	}

	public void setModified(){
		noteNumber += "Modified";
	}
}
