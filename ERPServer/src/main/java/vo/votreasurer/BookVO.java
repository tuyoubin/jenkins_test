package vo.votreasurer;

import java.util.ArrayList;

import po.posale_purchase_client.ClientPO;
import po.postock.GoodsClassPO;
import po.postock.GoodsPO;
import po.potreasurer.BookPO;
import po.potreasurer.CompanyAccountPO;
import vo.vosale_purchase_client.ClientVO;
import vo.vostock.GoodsClassVO;
import vo.vostock.GoodsVO;

/**
 * 期初账单
 * @author CharlieLei
 *
 */
public class BookVO {
	//商品分类信息
	ArrayList<GoodsClassVO> goodsClassInfo;
	//商品信息
	ArrayList<GoodsVO> goodsInfo;
	//客户信息
	ArrayList<ClientVO> clientInfo;
	//银行账户信息
	ArrayList<CompanyAccountVO> companyAccountInfo;
	
	public BookVO(ArrayList<GoodsClassVO> goodsclass, ArrayList<GoodsVO> goodsInfo, ArrayList<ClientVO> clientInfo, ArrayList<CompanyAccountVO> companyAccountInfo) {
		this.goodsClassInfo = goodsclass;
		this.goodsInfo = goodsInfo; 
		this.clientInfo = clientInfo; 
		this.companyAccountInfo = companyAccountInfo;
	}
	
	public BookPO toPO() {
		ArrayList<GoodsClassPO> goodsclasspolist = new ArrayList<GoodsClassPO>();
		ArrayList<GoodsPO> goodspolist = new ArrayList<GoodsPO>();
		ArrayList<ClientPO> clientpolist = new ArrayList<ClientPO>();
		ArrayList<CompanyAccountPO> accountpolist = new ArrayList<CompanyAccountPO>();
		
		if(this.goodsClassInfo != null) {
			for(int i = 0; i < this.goodsClassInfo.size(); i++)
				goodsclasspolist.add(this.goodsClassInfo.get(i).toPO());
		}
		
		if(this.goodsInfo != null) {
			for(int i = 0; i < this.goodsInfo.size(); i++)
				goodspolist.add(this.goodsInfo.get(i).toPO());
		}
		
		if(this.clientInfo != null) {
			for(int i = 0; i < this.clientInfo.size(); i++)
				clientpolist.add(this.clientInfo.get(i).toPO());
		}
		
		if(this.companyAccountInfo != null) {
			for(int i = 0; i < this.companyAccountInfo.size(); i++)
				accountpolist.add(this.companyAccountInfo.get(i).toPO());
		}
		
		BookPO bookpo = new BookPO(goodsclasspolist, goodspolist, clientpolist, accountpolist);
		
		return bookpo;	
	}
	
	public ArrayList<GoodsClassVO> getGoodsClass() {return this.goodsClassInfo;}
	public ArrayList<GoodsVO> getGoodsInfo() {return this.goodsInfo;}
	public ArrayList<ClientVO> getClientInfo() {return this.clientInfo;}
	public ArrayList<CompanyAccountVO> getCompanyAccountInfo() {return this.companyAccountInfo;}
}
