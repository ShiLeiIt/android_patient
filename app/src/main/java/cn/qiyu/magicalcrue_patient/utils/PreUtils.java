package cn.qiyu.magicalcrue_patient.utils;

import java.util.ArrayList;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * 本地持久化的工具类
 * 
 * @author lizhaoyong
 * 
 */
public class PreUtils {
	private static final String FILE_NAME = "config";

	//清除个人登录的用户信息
	public static void clearUserInfomation(Context context) {
		SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		editor.putString("uuid", "");
		editor.putString("token","");
		editor.putString("phone","");
		editor.commit();

	}

	// 存储到sp中
	public static void setParam(Context context, String key, Object object) {

		String type = object.getClass().getSimpleName();
		SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();
		if ("String".equals(type)) {
			editor.putString(key, (String) object);
		} else if ("Integer".equals(type)) {
			editor.putInt(key, (Integer) object);
		} else if ("Boolean".equals(type)) {
			editor.putBoolean(key, (Boolean) object);
		} else if ("Float".equals(type)) {
			editor.putFloat(key, (Float) object);
		} else if ("Long".equals(type)) {
			editor.putLong(key, (Long) object);
		}
		editor.commit();
	}

	// 获取sp中的值
	public static Object getParam(Context context, String key,
			Object defaultObject) {
		String type = defaultObject.getClass().getSimpleName();
		SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
				Context.MODE_PRIVATE);

		if ("String".equals(type)) {
			return sp.getString(key, (String) defaultObject);
		} else if ("Integer".equals(type)) {
			return sp.getInt(key, (Integer) defaultObject);
		} else if ("Boolean".equals(type)) {
			return sp.getBoolean(key, (Boolean) defaultObject);
		} else if ("Float".equals(type)) {
			return sp.getFloat(key, (Float) defaultObject);
		} else if ("Long".equals(type)) {
			return sp.getLong(key, (Long) defaultObject);
		}

		return null;
	}

	public static void saveArrayList(ArrayList<String> mList, Context context) {
		setParam(context, "Status_size", mList.size());

		for (int i = 0; i < mList.size(); i++) {
			mList.remove("Status_" + i);
			setParam(context, "Status_" + i, mList.get(i));
		}

	}

	/**
	 * 本地化存储list数据
	 * 
	 * @param mList
	 * @param context
	 * @param key
	 */
	public static void saveArrayListByKey(ArrayList<String> mList,
			Context context, String key) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < mList.size(); i++) {
			if (i == mList.size() - 1) {
				sb.append(mList.get(i));
			} else {
				sb.append(mList.get(i)).append(",");
			}

		}
		setParam(context, key, sb.toString());
	}

	/**
	 * 获取本地存储的String转化为字符串集合
	 * 
	 * @param context
	 * @param key
	 * @return
	 */
	public static ArrayList<String> loadArrayListByKey(Context context,
			String key) {
		ArrayList<String> list = new ArrayList<String>();
		String str = (String) getParam(context, key, "");
		if (str != null && str != "") {
			String[] arr = str.split(",");
			for (int i = 0; i < arr.length; i++) {
				list.add(arr[i]);
			}
			return list;
		} else {
			return null;
		}
	}

	public static ArrayList<String> loadArrayList(Context context) {
		ArrayList<String> list = new ArrayList<String>();
		int size = (Integer) getParam(context, "Status_size", 0);
		// System.out.println("size = " + size);
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				list.add((String) getParam(context, "Status_" + i, ""));
			}
		}

		return list;
	}
}
