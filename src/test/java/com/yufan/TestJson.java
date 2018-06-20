package com.yufan;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.yufan.entity.Chapter;

public class TestJson {

	@Test
	public void testJson(){
		Chapter chapter = new Chapter();
		chapter.setbId(1);
		chapter.setcName("name");
		chapter.setcNumber(1);
		chapter.setKldpoints(null);
		System.out.println(chapter);
		System.out.println("JSON:");
		String jsonString = JSON.toJSONString(chapter);
		
		Chapter parseObject = JSON.parseObject("{'cId':'1','cNumber':'1','cName':'单例模式'}", Chapter.class);
		System.out.println(parseObject);
		
	}
}
