package hao;

public interface IVDAO {
	
		/**
		 * ��Ӻ�ѡ��
		 * @param person ��ѡ����Ϣ
		 * */

		public abstract void addPerson(String name);
		
		/**
		 * �����������Һ�ѡ��
		 * @param name ��ѡ������
		 * @return ����ҵ��˺�ѡ�ˣ��򷵻غ�ѡ����Ϣ�����򷵻�null
		 * */
		public abstract int getPerson(String name);
		
		/**
		 * �������к�ѡ����Ϣ������Ʊ����������
		 * @return ���к�ѡ����Ϣ
		 * */
		public abstract Ren[] find();
		
		
		public abstract void tou(String name);
	
}
