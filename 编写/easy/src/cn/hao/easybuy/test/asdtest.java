package cn.hao.easybuy.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.hao.easybuy.entity.EasybuyProductCategory;
import cn.hao.easybuy.service.productcategory.IProductCategoryService;

import com.fasterxml.jackson.core.JsonProcessingException;

public class asdtest {

	public static void main(String[] args) throws JsonProcessingException {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		IProductCategoryService a = (IProductCategoryService) ac
				.getBean("productCategoryService");

		List<EasybuyProductCategory> c = a.find(null);
		System.out.println(c.get(c.size() - 1).getLevel());
		List<List<EasybuyProductCategory>> e = new ArrayList();
		for (int i = 0; i < c.get(c.size() - 1).getLevel() + 1; i++) {
			List<EasybuyProductCategory> z = a.find(i);
			e.add(z);
		}
		System.out.println();

		
//突破历史的一刻。。
		List<EasybuyProductCategory> x = new ArrayList<EasybuyProductCategory>();
		for (int i = 0; i < e.size(); i++) {
			for (int j = 0; j < e.get(i).size(); j++) {
				if (i == 0) {
					x.add(e.get(i).get(j)); // 把第一层加入集合中
				}
				if (i != 0) { // 判断是否不是一层
					// 二层与前一层比较父ID等于子ID则输出在他爹所在集合位置的后面
					for (int k = 0; k < x.size(); k++) {
						if (e.get(i).get(j).getEpcParentId()
								.equals(x.get(k).getEpcId())) {
							x.add(k + 1, e.get(i).get(j));

						}
					}
				}
			}
		}
		
		System.out.println(x.size());
		for (int asd = 0; asd < x.size(); asd++) {
			System.out.println(x.get(asd).getEpcId() + "\t"
					+ x.get(asd).getEpcName() + "\t"
					+ x.get(asd).getEpcParentId() + "\t"
					+ x.get(asd).getLevel());
		}

	}
}
