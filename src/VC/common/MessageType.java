package VC.common;

public interface MessageType {
	//消息类型分为三类：命令CMD---数据DAT---结果RST
	
	//Command
	String CMD_QUY_BOOK = "CMD_QUY_BOOK";
	
	//Data
	String DAT_QUY_BOOK = "DAT_QUY_BOOK";
	
	//Result
	String RST_SUCCESS = "RST_SUCCESS";
	String RST_FAILURE = "RST_FAILURE";
	
}
