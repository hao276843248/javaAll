package CH0345C;

public class Lyric {
	public static void main(String[] args) {
		String words="��ͤ�� �ŵ��� ���ݱ����� ������ ������ Ϧ��ɽ��ɽ";
		String[] printword=words.split(" ");
		System.out.println("****ԭ��ʸ�ʽ****\n"+words);
		System.out.println("\n***��ֺ�ĸ�ʸ�ʽ***");
		for (int i = 0; i < printword.length; i++) {
			System.out.println(printword[i]);
		}
	}
}
