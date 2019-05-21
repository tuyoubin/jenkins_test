package data.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * data
 * @author CharlieLei
 *
 */
public class DataStringHelper {

	private DataStringHelper() {}

	public static String getSeparator() {return ";;;";}
	
	public static String getAttributeSeparator() {return "&&&";}
	
	/**
	 * 导出销售明细表用的分隔符
	 * @return 分隔符
	 */
	public static String getSaleDetailSeparator() {return "\t\t";}
	
	/**
	 * 从单据编号获得时间
	 * @param noteNumber 单据编号
	 * @return 时间（格式：yyyyMMdd）
	 */
	public static String getTimeFromNoteNumber(String noteNumber) {
		String[] splitString = noteNumber.split("-");
		
		if(splitString.length < 2) return null;
		else return splitString[1];
	}
	
	/**
	 * 获得当前年份
	 * @return 当前年份
	 */
	public static String getThisYear() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(now);
	}
	
	/**
	 * 获得去年年份
	 * @return 去年年份
	 */
	public static String getlastYear() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		long temp = Long.parseLong(sdf.format(now)) - 1;
		return Long.toString(temp);
	}
	
	public static String getCurrentTime() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
		
		return sdf.format(now);
	}
	
	public static String getString(String[] array){
		if(array == null)				
			return null;
		else{
			int len = array.length;
			String ret = "";
			for(int i = 0; i < len; i++){
				ret = ret+array[i]+ getSeparator();
			}
			return ret;
		}
	}
	
	public static String getString(int[] array){
		if(array == null)				
			return null;
		else{
			int len = array.length;
			String ret = "";
			for(int i = 0; i < len; i++){
				ret = ret+array[i]+ getSeparator();
			}
			return ret;
		}
	}
	
	public static String getString(double[] array){
		if(array == null)				
			return null;
		else{
			int len = array.length;
			String ret = "";
			for(int i = 0; i < len; i++){
				ret = ret+array[i]+ getSeparator();
			}
			return ret;
		}
	}
	
	public static String[] getStringArray(String s){
		if(s == null)
			return null;
		String[] temp = s.split(getSeparator());
		return temp;		
	}
	
	public static int[] getIntArray(String s){
		if(s == null)
			return null;
		String[] temp = s.split(getSeparator());
		
		int len = temp.length;
		int ret[] = new int[len];
		for(int i = 0; i < len; i++){
			ret[i] = Integer.parseInt(temp[i]);			
		}
		return ret;		
	}
	
	public static double[] getDoubleArray(String s){
		if(s == null)
			return null;
		String[] temp = s.split(getSeparator());
		
		int len = temp.length;
		double ret[] = new double[len];
		for(int i = 0; i < len; i++){
			ret[i] = Double.parseDouble(temp[i]);			
		}
		return ret;		
	}
}
