package com.itheima17.mobileguard.utils;

import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author Administrator
 * @date 2015-11-26
 * @pagename com.itheima17.mobileguard.utils
 * @desc 服务的工具类

 * @svn author $Author: goudan $
 * @svn date $Date: 2015-11-26 15:30:04 +0800 (Thu, 26 Nov 2015) $
 * @Id  $Id: ServiceUtils.java 47 2015-11-26 07:30:04Z goudan $
 * @version $Rev: 47 $
 * @url $URL: https://188.188.2.100/svn/itheima17/trunk/MobileGuard/src/com/itheima17/mobileguard/utils/ServiceUtils.java $ 
 * 
 */
public class ServiceUtils {
	public static boolean isServiceRunning(String serviceName,Context context){
		boolean res = false;
		
		//判断服务 动态
		ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningServiceInfo> runningServices = am.getRunningServices(100);
		for (RunningServiceInfo info :runningServices) {
			if (info.service.getClassName().equals(serviceName) ) {
				res = true;
				break;
			}
		}
		return res;
	}
}
