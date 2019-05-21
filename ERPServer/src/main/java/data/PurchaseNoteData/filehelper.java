package data.PurchaseNoteData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import po.posale_purchase_client.ListOfGoodsPO;
import po.posale_purchase_client.PurchaseNotePO;
//po与String的转化

public class filehelper {
		
	
	public String PurchaseNote_poToString(PurchaseNotePO po){
		String str ="";
		
		 String state = po.get_state();
		 String ListNumbering  =po.get_ListNumbering();
		 String provider =po.get_provider();
		 String storehouse  =  po.get_storehouse();
		 String operator_id  =po.operator_id();
	
		ListOfGoodsPO goodspo  = po.get_ListOfGoodsPO();
		String remark  = po.get_remark();
		double total  = po.get_total();
		
		
		
		String split =";;;";
		str  = str+state+split+ListNumbering+split+provider+split+storehouse+split+operator_id+split+remark+split+total
				+split+List_poToString(goodspo);
		return str;
	}
	
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
//double all_total =po.get_all_total();
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
		 
		 for(int i=0;i<eachGoods.length;i++)
		 {
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
	
//	str+state+split+ListNumbering+split+provider+split+storehouse+split+operator_id+split+remark+split+total
//	+split+List_poToString(goodspo);
	public PurchaseNotePO PurchaseNote_stringToPO(String str){
		PurchaseNotePO po;
//System.out.println(str);
		
		String info[] = str.split(";;;");
		
		String state = info[0];
		 String ListNumbering  =info[1];
		 String provider = info[2];
		 String storehouse  =  info[3];
		 String operator_id  = info[4];
		String remark  = info[5];
		double total  =  Double.parseDouble(info[6]);
		ListOfGoodsPO goodspo = List_stringToPO(info[7]);
		po =new PurchaseNotePO(ListNumbering,provider,storehouse,operator_id,remark,
				total,state,goodspo);
		
		return po;
	}
	
//已经审批过得单据保存	
	public boolean writeFile(String info,String numbering,String state,String provider,
			String operator_id, String storehouse) {
		
		File file;
		if(state.equals(""))
			 file = new File("进货单"+File.separator+numbering+"_"+provider+"_"+operator_id+"_"
		+storehouse+"_"+"PurchaseNote.txt");
			
		else
			file =new File("进货退货单"+File.separator+File.separator+numbering+"_"+provider+"_"+
		operator_id+"_"+storehouse+"_"+"PurchaseNote.txt");
		
		
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
//待审批单据保存	
	public boolean write(String info,String numbering,String state,String provider,
			String operator_id, String storehouse) {
		
			File file;
			 file = new File("进货待审批单据"+File.separator+numbering+"_"+provider+"_"+operator_id+"_"
		+storehouse+"_"+"PurchaseNote.txt");
			

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
	
	
	
	public String readFile(String state,String numbering,String provider,
			String operator_id, String storehouse) {
		// TODO Auto-generated method stub
		 File myfile;
		if(state.equals("")){
		 myfile =new File("进货单"+File.separator+numbering+"_"+provider+"_"+operator_id+"_"
					+storehouse+"_"+"PurchaseNote.txt")	;
		}
		
		else
			myfile =new File("进货退货单"+File.separator+numbering+"_"+provider+"_"+operator_id+"_"
						+storehouse+"_"+"PurchaseNote.txt")	;
			
		
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
	public String read(String numbering,String provider,
			String operator_id, String storehouse){
		
			File myfile;
			 myfile =new File("进货待审批单据"+File.separator+numbering+"_"+provider+"_"+operator_id+"_"
						+storehouse+"_"+"PurchaseNote.txt")	;	
			
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
	
	
	public void deleteNote(PurchaseNotePO po){
		File myFile=new File("进货待审批单据"+File.separator+po.get_ListNumbering()+"_"+po.get_provider()+"_"+
				po.operator_id()+"_"+po.get_storehouse()+"_"+"PurchaseNote.txt");	
		
		if(myFile.exists()){
			myFile.delete();
		}
			
	}
	
//
	public String[] readFileList(String note) {
		// TODO Auto-generated method stub
		String result[]=null;
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
	
	
	
	public String[]  readPendingList(){
		String result[]=null;
		String r[] ={"出错了逗比"};
		File file = new File("进货待审批单据");
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
	
	
}
