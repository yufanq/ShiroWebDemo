package com.yufan.service;

import java.util.List;

import com.yufan.entity.Chapter;

/**
 * 
* @ClassName: ChapterService  
* @Description:  章节Service
* @author 雨ゆこ
* @date 2018年6月7日
* @version yuko1.0
 */
public interface ChapterService {

	List<Chapter> queryChapterByBookId(Integer id);
	
	int updateChapter(Chapter chapter);
	
	int createChapter(Chapter chapter);
	
	int deleteChapter(Integer id);
	
	Chapter queryChapterById(Integer id);
}
