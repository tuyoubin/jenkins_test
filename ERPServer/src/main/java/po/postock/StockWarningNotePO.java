package po.postock;

import java.io.Serializable;

import po.popublic.NotePO;
import vo.vostock.StockWarningNoteVO;

/**
 * 库存报警单
 */
public class StockWarningNotePO extends NotePO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public StockWarningNotePO(String noteNumber, String goodsId, String goodsName, int warningNum) {
		super("StockWarningNote");
		this.noteNumber = noteNumber;
		this.goodsID = goodsId;
		this.goodsName = goodsName;
		this.warningNum = warningNum;
	}

	//单据编号 KCBJD-yyyyMMdd-HHmmss
	private String noteNumber;            
	
	//商品编号
	private String goodsID;
	
	//商品名称
	private String goodsName;
	
	//库存警戒数量
	private int warningNum;

	public StockWarningNoteVO toVO() {
		StockWarningNoteVO vo = new StockWarningNoteVO(noteNumber, goodsID, goodsName, warningNum);
		return vo;
	}
	
	public String getNoteNumber(){
		return noteNumber;
	}
	
	
	public String getGoodsID(){
		return goodsID;
	}
	
	public String getGoodsName(){
		return goodsName;
	}
	
	public int getWarningNum(){
		return warningNum;
	}
	

	
}
