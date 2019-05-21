package po.poLog;

import java.io.Serializable;
import java.util.List;

import vo.voLog.LogVO;

/**
 * 日志PO
 * @author CharlieLei
 *
 */
public class LogPO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<String> logInfo;
	
	public LogPO(List<String> loginfo) {
		this.logInfo = loginfo;
	}
	
	public LogVO toVO() {
		LogVO logvo = new LogVO(this.logInfo);
		return logvo;
	}
	
	public List<String> getLogInfo(){
		return this.logInfo;
	}

}
