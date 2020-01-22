package guessplayer;

import java.awt.Choice;
import java.util.Scanner;

public class GameRoom {
/**
 * 游戏房间
 */
	//属性：道具，参与游戏的玩家，房间号，方面名称，房间密码。
	//private String weapon;
	private Human_palyer player1= null;
	private Computer_player player2= null;
	//房间ID
	private long roomId;
	//房间名称
	private String roomName;
	//房间密码
	private String roomPass;
	//重新建了一个构造方法
	public GameRoom( String roomName,String roomPass) {

		if(!("admin".equals(roomName)&&"12345".equals(roomPass))) {
			System.out.println("输入错误,游戏退出");
			return;
			}
		this.setRoomName(roomName);
		initGame();
		startGame();
		endGame();
	}
	//方法：开始游戏，初始化游戏，显示菜单，选择人物，判断输赢（可以定义在裁判类中）
	public void initGame() {
		//1。实例化玩家对象
		player1 = new Human_palyer();
		player2 =new Computer_player();
		//2.初始化游戏里的其他属性
		for (int i = 0; i < 30; i++) {
			System.out.print("*");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		System.out.println("youxi loading.....");
	}
	public void startGame() {
		showMenu();
		choiceRole();
		gameplay();
		
	}
	/**
	 * 游戏大循环
	 */
	private void gameplay() {
		while (true) {
			//双方出拳
			System.out.println(player1.getName()+" please have your first");
			
			Scanner input = new Scanner(System.in);
			  player1.setFirst(input.nextInt());
			  int first1 = player1.getFirst();
			  player2.getFirst();
			  int first2= player2.getFirst();
			//判断输赢
			  int result = judge(first1,first2);
			  //如果返回-1，玩家1胜利；返回0，打平：返回1，玩家2胜利
			  if (result == -1) {
				  System.out.println("she say ;"+player1.getName()+"win");
				player1.sendMessage(Human_palyer.MessageTypeWin);
				player2.sendMessage(Computer_player.MessageTypeLoss);
			} if (result == 0) {
				System.out.println("she say ; same same");
				player1.sendMessage(Human_palyer.messageTypeFirst);
				player2.sendMessage(Computer_player.messageTypeFirst);
			} if (result == 1) {
				System.out.println("she say ;"+player2.getName()+"win");
				player1.sendMessage(Human_palyer.MessageTypeLoss);
				player2.sendMessage(Computer_player.MessageTypeWin);
			}
			System.out.print("是否继续游戏？y/n ");
			String answer = new Scanner(System.in).next();
			if("n".equalsIgnoreCase(answer)) {
				break;
			}
		}
		
	}
	public void showMenu() {
		System.out.println("welecome  "+roomName);
		System.out.println("the rule :1-sissor; 2-blank; 3-ston");
		
	}
	public void choiceRole() {
		System.out.println("对方角色：1-风间；2-倪妮；3-正男；4-阿呆");
		System.out.print("please choice:");
		int chioce = new Scanner(System.in).nextInt();
		String []nameArray = {"风间","倪妮","正男","阿呆"};
		//省略对用户输入的验证
		player2.setName(nameArray[chioce-1]);
		player1.setName("harper zhou");
		System.out.println(player1.getName()+"  .vs.  "+player2.getName());
		
	}
	/**
	 * 如果返回-1，玩家1胜利；返回0，打平：返回1，玩家2胜利
	 * @param first1
	 * @param first2
	 * @return
	 */
	public int judge(int first1, int first2) {
		if (first1==first2) return 0;
		if(first1 == 1&&first2==3||first1 == 2&&first2 == 1||first1 == 3&&first2==2) {
			//玩家1的分数加一，玩家二的分数减一
			player1.setScore(player1.getScore()+1);
			player2.setScore(player2.getScore()-1);
			return -1;//玩家1胜利
		}
		//玩家2胜利
		player1.setScore(player1.getScore()-1);
		player2.setScore(player2.getScore()+1);
		return 1;
		
	}
	public void endGame() {
		System.out.println("game ends");
	}
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomPass() {
		return roomPass;
	}
	public void setRoomPass(String roomPass) {
		this.roomPass = roomPass;
	}
	
	
	
}
