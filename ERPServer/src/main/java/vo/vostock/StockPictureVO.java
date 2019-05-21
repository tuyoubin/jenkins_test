package vo.vostock;

public class StockPictureVO {
	
	private String[] goodsIDList;
	
	private String[] goodsNameList;
	
	private String[] typeList;
	
	private int[] amounts;
    
	
	
    public String[] getGoodsIDList() {
		return goodsIDList;
	}



	public String[] getGoodsNameList() {
		return goodsNameList;
	}



	public String[] getTypeList() {
		return typeList;
	}



	public int[] getAmounts() {
		return amounts;
	}



	public StockPictureVO(String[] goodsIDList, String[] goodsNameList, String[] typeList, int[] amounts){   	
    	this.goodsIDList = goodsIDList;
    	this.goodsNameList = goodsNameList;
    	this.typeList = typeList;
    	this.amounts = amounts;
    }
    
}
