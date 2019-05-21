package vo.voManager;


public class BusinessSituationVO {
	//起止时间
	private String FDate;
	private String EDate;
	//销售收入
	private double Shou;
	//商品收入
	private double Duo;
	//销售成本
	private double Chen;
	//商品支出
	private double Shao;
	//总利润
	private double Li;
	
	public String getFDate() {
		return FDate;
	}
	public void setFDate(String fDate) {
		FDate = fDate;
	}
	public String getEDate() {
		return EDate;
	}
	public void setEDate(String eDate) {
		EDate = eDate;
	}
	public double getShou() {
		return Shou;
	}
	public void setShou(double shou) {
		Shou = shou;
	}
	public double getDuo() {
		return Duo;
	}
	public void setDuo(double duo) {
		Duo = duo;
	}
	public double getChen() {
		return Chen;
	}
	public void setChen(double chen) {
		Chen = chen;
	}
	public double getShao() {
		return Shao;
	}
	public void setShao(double shao) {
		Shao = shao;
	}
	public double getLi() {
		return Li;
	}
	public void setLi(double li) {
		Li = li;
	}
}
