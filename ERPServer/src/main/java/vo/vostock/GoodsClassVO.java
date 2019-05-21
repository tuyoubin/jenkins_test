package vo.vostock;

import java.util.ArrayList;

import po.postock.GoodsClassPO;

/**
 * 商品分类
 */
public class GoodsClassVO {
	
	//商品分类编号
	private String ID;
	
	//商品分类名称
	private String name;	
	
	//父类	
	private String parentID;
	
	// 该分类在树状图的层数	 
	private int level;
	
	// 属于该分类的商品编号列表
	private ArrayList<String> GoodsIDList;	
	
	
	//下面的方法用于修改商品分类的各项属性
	
	public void setID(String iD) {
		ID = iD;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setGoodsIDList(ArrayList<String> goodsIDList) {
		GoodsIDList = goodsIDList;
	}
	
	
	// 提供了增添分类下商品项的方法
	public void AddGoods(String GoodsID){
		GoodsIDList.add(GoodsID);
	}
	
	// 提供了删除分类下商品项的方法
	public void DeleteGoods(String GoodsID){
		for(String s: GoodsIDList){
			if(s.equals(GoodsID))
				GoodsIDList.remove(s);
			break;
		}
	}
	
	
	//下面的方法用于获取商品分类的各项属性
		
	public String getID(){
		return ID;
	}
	public String getName(){
		return name;
	}
	public String getParentID(){
		return parentID;
	}
	public int getLevel(){
		return level;
	}
	public ArrayList<String> getGoodsIDList(){
		return GoodsIDList;
	}
	
	//商品分类值对象构造方法
	public GoodsClassVO(String ID, String name, String parentID, int level, ArrayList<String> GoodsIDList){
		this.ID = ID;
		this.name = name;
		this.parentID = parentID;
		this.level = level;
		this.GoodsIDList = GoodsIDList;
	}
	
	public GoodsClassPO toPO(){
    	GoodsClassPO po = new GoodsClassPO(ID, name, parentID, level, GoodsIDList);
    	return po;
    }
	
}
