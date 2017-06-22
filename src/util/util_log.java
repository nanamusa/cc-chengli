package util;

public class util_log {

	public enum LOG_METHOD {
		LOG_MSG_NONE, LOG_MSG_DEBUG
	}

	int opt;
	String msg;

	public boolean DEBUG_LOG(String msg, int opt) {
		boolean ret = true;

		switch (opt) {
		case 1:
			System.out.println(msg);
			break;

		default:
			break;
		}

		return ret;

	}

	public void setLog(String msg, int opt) {
		this.msg = msg;
		this.opt = opt;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
