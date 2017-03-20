package hao;

public interface IVDAO {
	
		/**
		 * 添加候选人
		 * @param person 候选人信息
		 * */

		public abstract void addPerson(String name);
		
		/**
		 * 根据姓名查找候选人
		 * @param name 候选人姓名
		 * @return 如果找到了候选人，则返回候选人信息，否则返回null
		 * */
		public abstract int getPerson(String name);
		
		/**
		 * 返回所有候选人信息，按得票数升序排序
		 * @return 所有候选人信息
		 * */
		public abstract Ren[] find();
		
		
		public abstract void tou(String name);
	
}
