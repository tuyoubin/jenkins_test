package po.potreasurer;

import java.io.Serializable;
import java.util.ArrayList;

import po.posale_purchase_client.ClientPO;
import po.postock.GoodsClassPO;
import po.postock.GoodsPO;
import vo.vosale_purchase_client.ClientVO;
import vo.vostock.GoodsClassVO;
import vo.vostock.GoodsVO;
import vo.votreasurer.BookVO;
import vo.votreasurer.CompanyAccountVO;


/**
 * 期初账单
 * @author CharlieLei
 *
 */
public class BookPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//商品分类信息
	private ArrayList<GoodsClassPO> goodsClassInfo;
	//商品信息
	private ArrayList<GoodsPO> goodsInfo;
	//客户信息
	private ArrayList<ClientPO> clientInfo;
	//银行账户信息
	private ArrayList<CompanyAccountPO> companyAccountInfo;
	
	public BookPO(ArrayList<GoodsClassPO> goodsclass, ArrayList<GoodsPO> goodsInfo, ArrayList<ClientPO> clientInfo, ArrayList<CompanyAccountPO> companyAccountInfo) {
		this.goodsClassInfo = goodsclass;
		this.goodsInfo = goodsInfo; 
		this.clientInfo = clientInfo; 
		this.companyAccountInfo = companyAccountInfo;
	}
	
	public BookVO toVO() {
		ArrayList<GoodsClassVO> goodsclassvolist = new ArrayList<GoodsClassVO>();
		ArrayList<GoodsVO> goodsvolist = new ArrayList<GoodsVO>();
		ArrayList<ClientVO> clientvolist = new ArrayList<ClientVO>();
		ArrayList<CompanyAccountVO> accountvolist = new ArrayList<CompanyAccountVO>();
		
		if(this.goodsClassInfo != null) {
			for(int i = 0; i < this.goodsClassInfo.size(); i++)
				goodsclassvolist.add(this.goodsClassInfo.get(i).toVO());
		}
		
		if(this.goodsInfo != null) {
			for(int i = 0; i < this.goodsInfo.size(); i++)
				goodsvolist.add(this.goodsInfo.get(i).toVO());
		}
		
		if(this.clientInfo != null) {
			for(int i = 0; i < this.clientInfo.size(); i++)
				clientvolist.add(this.clientInfo.get(i).toVO());
		}
		
		if(this.companyAccountInfo != null) {
			for(int i = 0; i < this.companyAccountInfo.size(); i++)
				accountvolist.add(this.companyAccountInfo.get(i).toVO());
		}
		
		BookVO bookvo = new BookVO(goodsclassvolist, goodsvolist, clientvolist, accountvolist);
		
		return bookvo;
	}
	
	public ArrayList<GoodsClassPO> getGoodsClass() {return this.goodsClassInfo;}
	public ArrayList<GoodsPO> getGoodsInfo() {return this.goodsInfo;}
	public ArrayList<ClientPO> getClientInfo() {return this.clientInfo;}
	public ArrayList<CompanyAccountPO> getCompanyAccountInfo() {return this.companyAccountInfo;}
}
