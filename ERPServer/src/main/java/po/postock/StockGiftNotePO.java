package po.postock;

import java.io.Serializable;

import po.popublic.NotePO;
import vo.vostock.StockGiftNoteVO;

/**
 * 库存赠送单
 */
public class StockGiftNotePO extends NotePO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public StockGiftNotePO(String noteNumber, String userID, int goodsListItemNum, 
			String[] goodsIDList, String[] goodsNameList, String[] typeList, int[] amounts, String state) {
		super("StockGiftNote");
		this.noteNumber = noteNumber;
		this.userID = userID;
		this.goodsListItemNum = goodsListItemNum;
		this.goodsIDList = goodsIDList;
		this.goodsNameList = goodsNameList;
		this.typeList = typeList;
		this.amounts = amounts;
		this.state = state;
		// TODO Auto-generated constructor stub
	}

	//单据编号 KCZSD-yyyyMMdd-HHmmss
	private String noteNumber;            

	//操作员
	private String userID;
	
	//商品列表项数
	private int goodsListItemNum;
	
	//商品编号列表
	private String[] goodsIDList;
	
	//商品名称列表
	private String[] goodsNameList;
	
	//赠品型号
	private String[] typeList;
	
	//赠送数量
	private int[] amounts;
	
	//表示库存赠送单的状态，区分是销售单触发的，还是销售退货单触发的
	private String state;

	public StockGiftNoteVO toVO() {
		StockGiftNoteVO vo = new StockGiftNoteVO(noteNumber, userID, goodsListItemNum, goodsIDList, goodsNameList, typeList, amounts, state);
		return vo;
	}
	
	public String getNoteNumber(){
		return noteNumber;
	}
	
	public String getUserID(){
		return userID;
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
	
	public String[] getTypeList(){
		return typeList;
	}
	
	public int[] getAmounts(){
		return amounts;
	}
	
	public String getState(){
		return state;
	}

}
