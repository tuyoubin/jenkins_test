package vo.vostock;

import po.postock.StockWarningNotePO;
import vo.vopublic.NoteVO;

/**
 * 库存报警单
 */
public class StockWarningNoteVO extends NoteVO{
	
	public StockWarningNoteVO(String noteNumber, String goodsId, String goodsName, int warningNum) {
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

	public StockWarningNotePO toPO() {
		StockWarningNotePO po = new StockWarningNotePO(noteNumber, goodsID, goodsName, warningNum);
		return po;
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

	@Override
	public void setModified(){
		noteNumber += "Modified";
	}
	

	
}
