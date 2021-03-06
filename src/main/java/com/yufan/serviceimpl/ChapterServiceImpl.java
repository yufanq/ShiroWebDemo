package com.yufan.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yufan.dao.ChapterMapper;
import com.yufan.entity.Chapter;
import com.yufan.service.ChapterService;

/**
 * 
* @ClassName: ChapterServiceInpl  
* @Description:  章节 Service 实现类
* @author 雨ゆこ
* @date 2018年6月7日
* @version yuko1.0
 */
@Service
@Transactional
public class ChapterServiceImpl implements ChapterService{
	@Autowired
	private ChapterMapper chapterMapper; //chapter dao 
	
	@Override
	public List<Chapter> queryChapterByBookId(Integer id) {
			
		return chapterMapper.selectChapterByBookId(id); 
	}

	@Override
	public int updateChapter(Chapter chapter) {
		return chapterMapper.updateByPrimaryKeySelective(chapter);
		
	}

	@Override
	public int createChapter(Chapter chapter) {
		return chapterMapper.insert(chapter);
	}

	@Override
	public int deleteChapter(Integer id) {
		return chapterMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Chapter queryChapterById(Integer id) {
		return chapterMapper.selectByPrimaryKey(id);
	}

}
