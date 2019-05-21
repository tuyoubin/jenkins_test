package po.posale_purchase_client;

import java.io.Serializable;

import vo.vosale_purchase_client.ListOfGoodsVO;



public class ListOfGoodsPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] state;
	private String[] numbering;
	private String[] NameOfGoods;
	private String[] type;
	 private int[] num;
	 private double[] unit_price;
	private  double[] total;
	private String[] remark;
	private double all_total;
	 
	 
public ListOfGoodsPO(String[] state2, String[] numbering2, String[] nameOfGoods2, String[] type2, int[] num2,
			double[] unit_price2, double[] total2, String[] remark2, double all_total2) {
	
		state = state2;
		numbering = numbering2;
		NameOfGoods = nameOfGoods2;
		type = type2;
		num = num2;
		unit_price = unit_price2;
		total =total2;
		remark = remark2;
		all_total = all_total2;
	}

double get_alltotal(double[] total){
		 double result=0;
		 for(int i=0;i<total.length;i++){
			 result += total[i];
		 }
		 return result;
	 }
public String[] get_state(){
		 return this.state;
	 }
public String[] get_numbering(){
		 return numbering;
	 }
	 
 public String[] get_NameOfGoods(){
		 return NameOfGoods;
	 }
 public String[] get_type  (){
	 return type;
 }
 public int[] get_num  (){
	 return num;
 }
 public double[] get_unit_price  (){
	 return unit_price;
 }
 public double[] get_total  (){
	 return total;
 }
 
 public String[] get_remark  (){
	 return remark;
 }
 public double get_all_total  (){
	 return all_total;
 }
	 public ListOfGoodsVO toVO(){
		 ListOfGoodsVO vo = new ListOfGoodsVO(state,numbering,NameOfGoods,type,num,unit_price,total,remark,all_total);
		 return vo;
	 }
	 
}
