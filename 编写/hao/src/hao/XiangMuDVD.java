package hao;

import java.util.Scanner;

public class XiangMuDVD {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] count = new int[6];
		int[] date = new int[6];
		String[] name = new String[] { "稻香", "龙卷风", "夏夕空", "卡农", "亡灵序曲", "夜曲" };
		String[] state = new String[] { "可借", "可借", "可借", "可借", "可借", "可借" };
		String newName;
		int newDay = 0;
		int Shuru;
		do {
			System.out.println("欢  迎  使  用  迷  你   DVD 管  理  器");
			System.out.println("----------------------");
			System.out.println("1. 新 增 DVD");
			System.out.println("2. 查 看 DVD");
			System.out.println("3. 删 除 DVD");
			System.out.println("4. 借 出 DVD");
			System.out.println("5. 归 还 DVD");
			System.out.println("6. 退 出 DVD");
			System.out.println("----------------------");
			System.out.println("请选择");
			Shuru = input.nextInt();
			switch (Shuru) {
			// 增加
			case 1:
				System.out.println("---->新增DVD");
				System.out.println("请输入DVD名称");
				newName = input.next();
				if (name[5] != null) {
					System.out.println("DVD货架以满增加失败");
					System.out.println("返回主界面");
					break;
				} else {
					int index1 = -1;
					for (int i = 0; i < name.length; i++) {
						if (name[i] == null) {
							index1 = i;
							break;
						}
					}
					if (index1 != -1) {
						name[index1] = newName;
						count[index1] = 0;
						date[index1] = 0;
						state[index1] = "可借";
						System.out.println("增加《" + newName + "》成功");
					}
				}
				System.out.println("----------------------");
				System.out.println("输入0返回");
				int a1 = input.nextInt();
				if (a1 == 0) {
					break;
				} else {
					System.out.println("输入错误返回主界面");
					break;
				}
				// 查看
			case 2:
				System.out.println("--->查看DVD");
				System.out.println("序号\t状态\t名称\t\t借出日期\t借出次数");
				int index2 = 0;
				for (int i = 0; i < name.length; i++) {
					if (name[i] != null) {
						index2++;
					}
				}
				for (int i = 0; i < index2; i++) {
					System.out.println(i + 1 + "\t" + state[i] + "\t" + name[i]
							+ "\t\t" + date[i] + "\t" + count[i]);
				}
				System.out.println("----------------------");
				System.out.println("输入0返回");
				int a2 = input.nextInt();
				if (a2 == 0) {
					break;
				} else {
					System.out.println("输入错误返回主界面");
					break;
				}
				// 删除
			case 3:
				System.out.println("---->删除DVD");
				System.out.println("请输入DVD名称");
				newName = input.next();
				int index3 = -1;
				for (int i = 0; i < name.length; i++) {
					if (name[i].equals(newName)) {
						index3 = i;
						break;
					}
				}
				if (index3 == -1) {
					System.out.println("没有找到匹配信息!");
				} else {
					if (state[index3].equals("已借出")) {
						System.out.println("已借出不可以删除!");
					} else {
						for (int i = index3; i < name.length - 1; i++) {
							name[i] = name[i + 1];
							count[i] = count[i + 1];
							date[i] = date[i + 1];
							state[i] = state[i + 1];
						}
						name[5] = null;
						state[5] = null;
						count[5] = 0;
						date[5] = 0;
						System.out.println("删除成功！");
					}
				}

				System.out.println("----------------------");
				System.out.println("输入0返回");
				int a3 = input.nextInt();
				if (a3 == 0) {
					break;
				} else {
					System.out.println("输入错误返回主界面");
					break;
				}
				// 借出
			case 4:
				System.out.println("---->借出DVD");
				System.out.println("请输入DVD名称");
				newName = input.next();
				int index4 = -1;

				for (int i = 0; i < name.length; i++) {
					if (newName.equals(name[i])) {
						index4 = i;
					}
				}
				if (index4 == -1) {
					System.out.println("没有找到匹配信息!");
				} else if (state[index4].equals("已借出")) {
					System.out.println("该DVD已借出!");
				} else {
					System.out.println("请输入借出日期:");
					newDay = input.nextInt();
					if (newDay > 31 || newDay < 1) {
						System.out.println("必须输入大于等于1且小于等于31的数字，请重新输入!");
						newDay = input.nextInt();
					}
					state[index4] = "已借出";
					date[index4] = newDay;
					count[index4]++;
					System.out.println("借出《" + name[index4] + "》成功!");
				}
				System.out.println("----------------------");
				System.out.println("输入0返回");
				int a4 = input.nextInt();
				if (a4 == 0) {
					break;
				} else {
					System.out.println("输入错误返回主界面");
					break;
				}
				// 归还
			case 5:
				System.out.println("---->归还DVD");
				System.out.println("请输入DVD名称");
				newName = input.next();
				int index5 = -1;
				for (int i = 0; i < name.length; i++) {
					if (newName.equals(name[i])) {
						index5 = i;
					}
				}
				if (index5 == -1) {
					System.out.println("没有找到匹配信息!");
				} else if (state[index5].equals("可借")) {
					System.out.println("该DVD已归还");
				} else {
					System.out.println("请输入归还日期:");
					newDay = input.nextInt();
					System.out.println("归还" + name[index5] + "成功");
					System.out.println("借出日期为:" + date[index5]);
					System.out.println("归还日期为:" + newDay);
					if (newDay < date[index5]) {
						System.out.println("应付租金(元):"
								+ (newDay + (31 - date[index5])));
					} else {
						System.out
								.println("应付租金(元):" + (newDay - date[index5]));
					}
					state[index5] = "可借";
					date[index5] = 0;

				}
				System.out.println("----------------------");
				System.out.println("输入0返回");
				int a5 = input.nextInt();
				if (a5 == 0) {
					break;
				} else {
					System.out.println("输入错误返回主界面");
					break;
				}
				// 其他
			default:
				if (Shuru == 6) {
					System.out.println("欢迎再次使用！");
				} else {
					System.out.println("请重新选择:");
				}
				break;
			}
		} while (Shuru != 6);
	}
}
