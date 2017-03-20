package CH0345C;

public class Lyric {
	public static void main(String[] args) {
		String words="长亭外 古道边 芳草碧连天 晚风扶柳 笛声残 夕阳山外山";
		String[] printword=words.split(" ");
		System.out.println("****原歌词格式****\n"+words);
		System.out.println("\n***拆分后的歌词格式***");
		for (int i = 0; i < printword.length; i++) {
			System.out.println(printword[i]);
		}
	}
}
