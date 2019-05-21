package po.popublic;

import java.io.Serializable;

import vo.vopublic.NoteVO;

/**
 * 所有单据PO的父类
 * @author CharlieLei
 *
 */
abstract public class NotePO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//单据类型
	protected String noteType;
	
	public NotePO(String notetype) {
		this.noteType = notetype;
	}
	
	public String getNoteType() {return this.noteType;}
	
	abstract public NoteVO toVO();
}
