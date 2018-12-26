package com.yufan.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yufan.bean.Bean;
import com.yufan.bean.Page;
import com.yufan.bean.SpecialtyBean;
import com.yufan.dao.ProfessionBookMapper;
import com.yufan.dao.ProfessionMapper;
import com.yufan.entity.Profession;
import com.yufan.entity.ProfessionBook;
import com.yufan.service.BookService;
import com.yufan.service.SpecialtyService;
/**
 * 
* @ClassName: SpecialtyServiceImpl  
* @Description:  专业 Service 实现类
* @author 雨ゆこ
* @date 2018年6月5日
* @version yuko1.0
 */

@Service
@Transactional
public class SpecialtyServiceImpl implements SpecialtyService{
	private static final boolean ProfessionBook = false;

	@Autowired
	private ProfessionMapper professionMapper; // 专业dao
	
	@Autowired
	private BookService bookService ; // 图书 Service
	@Autowired
	private ProfessionBookMapper professionBookMapper;
	
	@Override
	public void createSpecialty(Profession profession) {
		 //插入专业数据
		professionMapper.insert(profession);
		
	}

	@Override
	public void updateSpecialty(Profession profession) {
		// 更新专业数据
		professionMapper.updateByPrimaryKeySelective(profession);
	}

	@Override
	public void deleteSpecialty(Integer pId) {
		// 删除专业数据
		professionMapper.deleteByPrimaryKey(pId);
		
	}

	@Override
	public Bean<Profession> querySpecialtyByPage(Page page) {
		// 分页bean
		Bean<Profession> bean = new Bean<Profession>();
		// 该页的数据
		bean.setList(professionMapper.selectProfessionByBean(page.getStart(), page.getEnd()));
		// 图书的总条数
		bean.setTotalCount(professionMapper.selectProfessionCount());
		page.setTotalCount(bean.getTotalCount());
		return bean;
	}

	@Override
	public List<Profession> queryAllSpecialty() {
		
		return professionMapper.selectALLProfession();
	}
	@Override
	public Profession querySpecialtyById(Integer id) {
		
		return professionMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer createSpeacialtyAndBook(Integer sid, int[] bIds) {
		ProfessionBook professionBook = new ProfessionBook();
		professionBook.setpId(sid);
		int insert = 0;
		for (int i : bIds) {
			professionBook.setPbId(i);
		 insert = professionBookMapper.insert(professionBook);
		}
		return insert;
	}

}
