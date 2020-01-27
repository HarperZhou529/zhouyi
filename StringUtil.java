package judgeUsersName;

/**
 * 字符串工具类，封装类常用的字符串判断方法
 * 
 * @author zhouharper
 *
 */
public class StringUtil {

 
	/**
	 * 判断是否是正确的用户名
	 * 用户名最多25个字符串长度，不能包含空格，单双引号。问好等特殊符号 
	 * @param userName
	 * @return
	 */
	public static boolean isCorrectUserName(String userName) {
		boolean isCorecct = true;
		if (userName == null) {
			return false;
		}
		if (userName.length() > 25) {
			return false;
		}
		char[] unValidChar = { ' ', '\'', '"', '?', '<', '>', ',' };
		for (char c : unValidChar) {
			if (userName.contains(Character.toString(c))) {
				isCorecct = false;
				break;
			}

		}
		return isCorecct;
	}

	/**
	 * 2.密码6-18位，只能包含字母，数字，特殊符号（下划线，美元符号@#！） 3。纯数字，纯字母密码强度为弱（两颗心 4.三个里面包含任意两个都是为中（四星
	 * 5.同时存在三种密码为强满星（六星
	 * 
	 * @param password
	 * @return 如果返回值为“验证失败，请查看自己是否有填入正确的符号”，那么密码的验证失败；如果验证成功，则返回星号表示密码的强度
	 */
	public static String validatePassword(String password) {
		String power = "验证失败，请查看自己是否有填入正确的符号";// 密码的强度及有效的判断
		if (password == null) {
			return power;
		}
		if (password.length() < 6 || password.length() > 18)
			return power = "输入长度应为6～18之间";
		// 密码中的合法组成部分
		String part = "_@#$!";
		for (int i = 0; i < password.length(); i++) {
			if (!Character.isLetterOrDigit(password.charAt(i))) {
				// 如果不是字母或者数字，并且也不是合法的特殊符号，就证明是非法的格式
				if (!part.contains(Character.toString(password.charAt(i)))) {
					return power="非法字符！";
				}

			}

		}
		// 开始判断密码强度
		if (isLetter(password)||isDigit(password)) {
			power = "密码强度为：**....";
		} else if (isDigitAndLetter(password)) {
			power = "密码强度为：****..";
		} else if (isContainsSymble(password)) {
			power = "密码强度为：******";
		}
		return power;
	}
	/**
	 * 用户要输入正确的email有且只有一个@符号（且@和。不能在开头和结尾）
	 * @param eMail
	 * @return 如果正确没有返回，如果错误返回
	 */
	public static boolean vaildEmail(String eMail) {
		boolean jugde =true;
		int count=0;
		for (int i = 0; i < eMail.length(); i++) {
			if (eMail.charAt(i)=='@') {
				count++;
			}
		}
		if (!(count==1)) {
			 jugde=false;
		}
		if (eMail.charAt(0)=='@'||eMail.charAt(0)=='.') {
			jugde=false;
		}
		return jugde;
	}
	
	
	
	
	
//	private static boolean isDigitAndLetterAndSymble(String value) {
//		for (int i = 0; i <value.length(); i++) {
//			if (!(Character.isDigit(value.charAt(i))||Character.isLetter(value.charAt(i))||"_@#$!".contains(Character.toString(value.charAt(i))))) {
//				return false;
//			}
//		}
//		return true;
//	}
	
	
	
	
	
	
	
	
	/**
	 * 判断是否为纯数字
	 * 
	 * @param value
	 * @return
	 */
	private static boolean isDigit(String value) {
		for (int i = 0; i < value.length(); i++) {
			if (!Character.isDigit(value.charAt(i))) {
				return false;
			}
			
		}
		
		return true;
	}

	/**
	 * 字符串中包含合法的字母和数字
	 * 
	 * @param value
	 * @return
	 */
	private static boolean isDigitAndLetter(String value) {
		for (int i = 0; i < value.length(); i++) {
			if (Character.isLetterOrDigit(value.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	

	/**
	 * 判断是不是纯字符组成的
	 * 
	 * @param value
	 * @return
	 */
	private static boolean isLetter(String value) {
		for (int i = 0; i < value.length(); i++) {
			if (!Character.isLetter(value.charAt(i))) {
				return false;
			}
		}
		return true;

	}

	/**
	 * 判断是否有特殊符号
	 * 
	 * @param value
	 * @return
	 */
	private static boolean isContainsSymble(String value) {
		String part = "_@#$!";
		for (int i = 0; i < value.length(); i++) {
			if (part.contains(Character.toString(value.charAt(i)))) {
				return true;
			}
		}
		return false;
	}

//	  6.用户要输入正确的email有且只有一个@符号（且@和。不能在开头和结尾
//	 

}
