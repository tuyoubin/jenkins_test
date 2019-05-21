package vo.voLog;

import java.util.List;

import po.poLog.LogPO;

/**
 * 日志VO
 * @author CharlieLei
 *
 */
public class LogVO {

	private List<String> logInfo;
	
	public LogVO(List<String> loginfo) {
		this.logInfo = loginfo;
	}
	
	public LogPO toPO() {
		LogPO logpo = new LogPO(this.logInfo);
		return logpo;
	}
	
	public List<String> getLogInfo(){
		return logInfo;
	}

}
