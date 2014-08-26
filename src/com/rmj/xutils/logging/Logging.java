package com.rmj.xutils.logging;

public class Logging {

    public static boolean TEST_VERSION = true;

	/**
	 * 输出日志信息
	 * @param tag
	 * @param msg
	 */
	public static void i(String tag,String msg) {
		if (TEST_VERSION) {
			android.util.Log.i(tag, msg);
		}
	}
	
	/**
	 * 输出错误信息
	 * @param tag
	 * @param msg
	 */
	public static void e(String tag,String msg) {
		if (TEST_VERSION) {
			android.util.Log.e(tag, msg);
		}
	}
	/**
	 * 输出异常详情
	 * @param e
	 */
	public static void exception(Exception e) {
		if (TEST_VERSION) {
			e.printStackTrace();
		}
	}

}
