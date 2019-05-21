package vo.vopublic;

import po.popublic.NotePO;

/**
 * 所有单据VO的父类
 * @author CharlieLei
 *
 */
abstract public class NoteVO {
	//单据类型
	protected String noteType;
	
	public NoteVO(String notetype) {
		this.noteType = notetype;
	}
	
	public String getNoteType() {return this.noteType;}
	
	abstract public NotePO toPO();
	
	abstract public void setModified();
}
