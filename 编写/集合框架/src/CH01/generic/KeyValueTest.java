package CH01.generic;

import java.util.Date;

public class KeyValueTest {
	public static void main(String[] args) {
		KeyValue kv=new KeyValue();
		kv.setKey("apple");
		kv.setValue("Æ»¹û");
		
		DateKeyValue kv2=new DateKeyValue();
		kv2.setKey("addtime");
		kv2.setDate(new Date());
		
		keyValueFan<String> kv3=new keyValueFan<String>();
		kv3.setKey("banana");
		kv3.setValue("Ïã½¶");
		
		System.out.println(kv3.getValue());
		
		keyValueFan<Date> kv4=new keyValueFan<Date>();
		kv4.setValue(new Date());
		kv4.setKey("nowtime");
		
	}
}
