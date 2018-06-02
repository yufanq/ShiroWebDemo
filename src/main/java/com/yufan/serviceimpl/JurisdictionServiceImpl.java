package com.yufan.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yufan.bean.JurisdictionBean;
import com.yufan.bean.Page;
import com.yufan.dao.JurisdictionMapper;
import com.yufan.entity.Jurisdiction;
import com.yufan.service.JurisdictionService;
@Service
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
			if(jurisdiction.isRootNode()){
				continue;
			}
			if(jurisdiction.getlType() != Jurisdiction.ResourceType.menu){
				continue;
			}
			if(!hasPermission(permissions, jurisdiction)){
				continue;
			}
			memus.add(jurisdiction);
			
		}
		
		return memus;
	}

    private boolean hasPermission(Set<String> permissions, Jurisdiction jurisdiction) {
        if(StringUtils.isEmpty(jurisdiction.getlPermission())) {
            return true;
        }
        for(String permission : permissions) {
            WildcardPermission p1 = new WildcardPermission(permission);
            WildcardPermission p2 = new WildcardPermission(jurisdiction.getlPermission());
            if(p1.implies(p2) || p2.implies(p1)) {
                return true;
            }
        }
        return false;
    }
	@Override
	public List<Jurisdiction> queryJurisdictionByParentid(Integer parentid) {
		return jurisdictionMapper.selectJurisdictionByParentid(parentid);
		}
	@Override
	public List<Jurisdiction> findLists(Set<String> permissions,
			Integer parentid) {
		// 根据父id 查询到子项
		List<Jurisdiction> lists = new ArrayList<Jurisdiction>();
		List<Jurisdiction> queryJurisdictionByParentid = queryJurisdictionByParentid(parentid);
		for (Jurisdiction jurisdiction : queryJurisdictionByParentid) {
			// 不是列表项
			if(jurisdiction.getlType() != Jurisdiction.ResourceType.list){
				continue;
			}
			if(!hasPermission(permissions, jurisdiction)){
				continue;
			}
			lists.add(jurisdiction);
		}
		return lists;
	}
	@Override
	public JurisdictionBean queryJurisdictionByPage(Page page) {
		// 分页查询容器
		JurisdictionBean jurisdictionBean = new JurisdictionBean();
		// 设置列表
		jurisdictionBean.setJurisdictionList(jurisdictionMapper.selectAllJurisdictionByPage(page.getStart(), page.getEnd()));
		// 设置 总条数
		jurisdictionBean.setTotalPage(jurisdictionMapper.selectjurisdictionCount());
		
		page.setTotalCount(jurisdictionBean.getTotalPage());
		
		return jurisdictionBean;
	}

}
