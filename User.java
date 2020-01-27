package judgeUsersName;
/**
 * 1.用户名最多25个字符串长度，不能包含空格，单双引号。问好等特殊符号
 * 2.密码6-18位，只能包含字母，数字，特殊符号（下划线，美元符号@#！）
 * 3。纯数字，纯字母密码强度为弱（两颗心
 * 4.三个里面包含任意两个都是为中（四星
 * 5.同时存在三种密码为强满星（六星
 * 6.用户要输入正确的email有且只有一个@符号（且@和。不能在开头和结尾
 * @author zhouharper
 *
 */
public class User {
private String userName;
private String password;
private String email;
public User() {
	super();//以防万一就是要写一个继承默认的
}
public User(String userName, String password,String email) {
	setEmail(email);
	setPassword(password);
	setUserName(userName);
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
}
