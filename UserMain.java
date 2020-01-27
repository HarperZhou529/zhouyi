package judgeUsersName;

import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		// 以下代码实现用户注册
		System.out.println("1.用户名最多25个字符串长度，不能包含空格，单双引号。问好等特殊符号\n" + "  2.密码6-18位，只能包含字母，数字，特殊符号（下划线，美元符号@#！）\n"
				+ "  3。纯数字，纯字母密码强度为弱（两颗心\n" + "  4.三个里面包含任意两个都是为中（四星\n" + "  5.同时存在三种密码为强满星（六星\n"
				+ "  6.用户要输入正确的email有且只有一个@符号（且@和。不能在开头和结尾");
		Scanner input = new Scanner(System.in);
		System.out.println("请输入用户名： ");
		String userName = input.next();
		if (StringUtil.isCorrectUserName(userName)) {
			System.out.println("用户名合法！");
			System.out.println("请输入密码： ");
			String password = input.next();
			System.out.println(StringUtil.validatePassword(password)); // 判断密码强度，和密码是否正确
			System.out.println("请输入邮箱： ");
			String email = input.next();
			if (StringUtil.vaildEmail(email)) {
				System.out.println("邮箱合法！");
			} else {
				System.exit(0);
				;
			}
		} else {
			System.exit(0);
		}

	}

}
