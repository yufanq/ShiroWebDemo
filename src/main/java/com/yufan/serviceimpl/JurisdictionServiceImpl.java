package com.yufan.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.yufan.dao.JurisdictionMapper;
import com.yufan.entity.Jurisdiction;
import com.yufan.service.JurisdictionService;

public class JurisdictionServiceImpl implements JurisdictionService{
	@Autowired
	private JurisdictionMapper jurisdictionMapper;
	@Override
	public void createJurisdiction(Jurisdiction jurisdiction) {
		jurisdictionMapper.insert(jurisdiction);
		
	}
	@Override
	public void updateJurisdiction(Jurisdiction jurisdiction) {
		jurisdictionMapper.updateByPrimaryKeySelective(jurisdiction);
	}

	@Override
	public void deleteJurisdiction(Jurisdiction jurisdiction) {
		jurisdictionMapper.deleteByPrimaryKey(jurisdiction.getjId());
	}

	@Override
	public List<Jurisdiction> queryAllJurisdiction() {
		return jurisdictionMapper.selectAllJurisdiction();
	}
	
	@Override
	public List<Jurisdiction> findMenus(Set<String> permissions) {
		List<Jurisdiction> queryAllJurisdiction = queryAllJurisdiction(); // 所有资源
		List<Jurisdiction> memus = new ArrayList<Jurisdiction>();
		for (Jurisdiction jurisdiction : queryAllJurisdiction) {
			
			
		}
		
		return null;
	}

}
