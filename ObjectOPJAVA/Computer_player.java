package guessplayer;

public class Computer_player {
	//静态常量：出拳的类型
		public static final int messageTypeFirst=1;
		//静态常量：出拳的信息
		public static final int MessageTypeWin= 2;
		public static final int MessageTypeLoss=3;
		
		
		//静态常量：出拳类型的信息
	//属性：名称，分数，所出的拳，角色的台词
		private String name;
		private int score;
		private int first;
		//角色在出拳时说的话
		private String[] firstwords={
			"balalalalalalla",
			"hahhhahhahahaha"
		};
		private String []winwords={
			"hahhahahaha",
			"kakakakkaak"
		};
		private String []losewords= {
		"baabbababaabababab",
		"jajajajajaajajajaj"
		};
		//方法：设置和得到名称，分数，说词，出拳
		/** 对应humanplayer中定义的静态变量  
		 * @param msgType */
		//根据传入的消息类型，随机打印对应类型的消息
		public void sendMessage(int msgType) {
			//生成一个0-2之间的随机数（对应你有几句输出时的话语）
			int index =(int)(Math.random()*2);
			String message = null;
			switch(msgType) {
			case messageTypeFirst:
			message=firstwords[index];
			break;
			case MessageTypeWin:
			message=winwords[index];
			break;
			case MessageTypeLoss:
			message=losewords[index];
			break;
			}
			System.out.println(message);
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getScore() {
			return score;
		}
		public void setScore(int score) {
			this.score = score;
		}
		public int getFirst() {
			//电脑的出拳实际上是生成了1-3之间的随机数字
			first=((int)(Math.random()*30000))%3+1;
			return first;
		}
//		public void setFirst(int first) {
//			this.first = first;
//		}
//		
		
}
