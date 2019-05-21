package data.SaleListData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import po.posale_purchase_client.ListOfGoodsPO;
import po.posale_purchase_client.SaleListPO;

public class FileHelper {
	
	
//把string转化为listofgooodspo	
	public ListOfGoodsPO List_stringToPO(String str){
		ListOfGoodsPO po;
		 
		String eachGoods[] = str.split("隔");
		 String goods[][] =new String[eachGoods.length][8];
		 for(int i=0;i<eachGoods.length;i++){
			 goods[i] = eachGoods[i].split("@");
		 }
		 
		 	String state[] = new String[eachGoods.length];
			String[] numbering =new String[eachGoods.length];
			String[] NameOfGoods = new String[eachGoods.length];
			String[] type  = new String[eachGoods.length];
			int[] num = new int[eachGoods.length];
			double[] unit_price =  new double[eachGoods.length];
			double[] total = new double[eachGoods.length];
			String[] remark = new String[eachGoods.length];
			double all_total =0;
		 
		 for(int i=0;i<eachGoods.length;i++){
			 state[i] = goods[i][0];
			 numbering[i] =goods[i][1];
			 NameOfGoods[i] =goods[i][2];
			 type[i]=goods[i][3];
			 num[i] =Integer.parseInt(goods[i][4]);
			 unit_price[i]=Double.parseDouble(goods[i][5]);
			 total[i]=Double.parseDouble(goods[i][6]);
			 remark[i]=goods[i][7];
		 }
		 
		 po =new ListOfGoodsPO(state,numbering,NameOfGoods,type,num,unit_price,total,remark,all_total);
		return po;
		
	}
	
//turn listofgoods 	 into string
	public String List_poToString(ListOfGoodsPO po){
		String str = "" ;
		String state[] =po.get_state();
		String[] numbering =po.get_numbering();
		String[] NameOfGoods = po.get_NameOfGoods();
		String[] type  = po.get_type();
		int[] num =po.get_num();
		double[] unit_price =po.get_unit_price();
		double[] total =po.get_total();
		String[] remark =po.get_remark();
	//	double all_total =po.get_all_total();
		//同一行商品分隔
		String split = "@";
		//不同行
		String spl = "隔";
		for(int i=0;i<state.length-1;i++){
			str =str +state[i]+split+numbering[i]+split+NameOfGoods[i]+split+type[i]+split+num[i]+split+unit_price[i]+
					split+total[i]+split+remark[i]+spl;
		}
		
		int i =state.length-1;
		str =str +state[i]+split+numbering[i]+split+NameOfGoods[i]+split+type[i]+split+num[i]+split+unit_price[i]+
				split+total[i]+split+remark[i];
				
		return str;
		
	}
	
	
//turn salelistpo into string 
	
	public String  SaleList_poToString(SaleListPO po){
		String result ="";
		
		
		String state =po.get_state();
		String ListNumbering =po.get_ListNumbering();
		String client =po.get_client();
		String storehouse =po.storehouse();
		String merchandiser = po.get_merchandiser();
		String operator_id =po.get_operator_id();
		String  remark =po.get_remark();
		
		double dis =po.get_dis();
		ListOfGoodsPO goodspo = po.get_ListOfGoodsPO();
		ListOfGoodsPO giftpo = po.get_gift();
		
		double Total_Before_Discount =po.get_total_Before_Discount();
		double discount = po.get_discount();
		double voucher =po.get_voucher();
		double Total =po.get_Total();
		
		String GoodsInString = this.List_poToString(goodspo);
		String giftInString  = this.List_poToString(giftpo);
		
		String split = ";;;";
		
		
		
		result = state+split+ListNumbering+ split +client+split+
				storehouse+split+merchandiser+split+operator_id+split+
				remark+split+dis+split+ Total_Before_Discount+split+
				discount+split+voucher+split+Total+split+GoodsInString+split
				+giftInString;
			
		return result;
	}
//turn string into po
	public  SaleListPO SaleList_stringToPO(String str){
		SaleListPO po;
		String info[] = str.split(";;;");
		String state =info[0];
		String ListNumbering =info[1];
		String client =info[2];
		String storehouse =info[3];
		String merchandiser = info[4];
		String operator_id =info[5];
		String  remark =info[6];
		double dis =Double.parseDouble(info[7]);
		double Total_Before_Discount =Double.parseDouble(info[8]);
		double discount = Double.parseDouble(info[9]);
		double voucher =Double.parseDouble(info[10]);
		double Total =Double.parseDouble(info[11]);	
		ListOfGoodsPO Goods = this.List_stringToPO(info[12]);
		ListOfGoodsPO gifts = this.List_stringToPO(info[13]);
		

		po=new SaleListPO(state,ListNumbering,client,storehouse,merchandiser,operator_id,remark,Total_Before_Discount
				,discount,voucher,Total,Goods,gifts,dis);
				
		return po;	
	}
	
	public boolean writeFile(String info,String numbering,String state) {
		
		File file;
		if(state.equals(""))
			 file = new File("销售单"+File.separator+numbering+"_"+"SaleList.txt");
			
		else
			file =new File("销售退货单"+File.separator+numbering+"_"+"SaleList.txt");
		
		
		BufferedWriter writer=null;
		try {
			
			writer=new BufferedWriter(new FileWriter(file));
			
			writer.write(info);
			writer.flush();
			writer.close();
			return true; 
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean write(String info,String numbering) {
		
			File file;
			file = new File("销售待审批单据"+File.separator+numbering+"_"+"SaleList.txt");

		BufferedWriter writer=null;
		try {
			
			writer=new BufferedWriter(new FileWriter(file));
			
			writer.write(info);
			writer.flush();
			writer.close();
			return true; 
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public String[] readFileList(String note) {
		
		
		String result[];
		String r[] ={"出错了逗比"};
		
		File file=new File(note);
		File[] list=file.listFiles();
		
		result = new String[list.length];
		try{
			for(int i=0;i<list.length;i++){
				result[i]=list[i].getName();
			}
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return r;
		}
	}
	
	
public String[] readPendingList() {
		
		
		String result[];
		String r[] ={"出错了逗比"};
		
		File file=new File("销售待审批单据");
		File[] list=file.listFiles();
		
		result = new String[list.length-1];
		try{
			for(int i=1;i<list.length;i++){
				result[i-1]=list[i].getName();
			}
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return r;
		}
	}
	
	
	
	
	public String readFile(String state,String numbering) {
		
		 File myfile;
		if(state.equals("")){
		 myfile =new File("销售单"+File.separator+numbering+"_"+"SaleList.txt")	;
		}
		
		else
			myfile =new File("销售退货单"+File.separator+numbering+"_"+"SaleList.txt")	;
		try{
			FileReader fileReader=new FileReader(myfile);
			BufferedReader reader=new BufferedReader(fileReader);
			String line=reader.readLine();
			reader.close();
			return line;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return "呵呵，出错了";
	}	
	
//读取待审批单据信息
	public String read(String numbering){
		
			File myfile;
			 myfile =new File("销售待审批单据"+File.separator+numbering+"_"+"SaleList.txt");	
			
			try{				
				FileReader fileReader=new FileReader(myfile);
				BufferedReader reader=new BufferedReader(fileReader);
				String line=reader.readLine();				
				reader.close();			
				return line;
			}catch(Exception ex){
				ex.printStackTrace();
			}
			return "呵呵，出错了";	
		
	}	
	
	
	
	
//删除待审批单据的信息	
	public void deleteNote(SaleListPO po){
		
		File myFile=new File("销售待审批单据"+File.separator+po.get_ListNumbering()+"_"+"SaleList.txt");	
		if(myFile.exists()){
			myFile.delete();
		}
			
	}
	
	
	
	
}
