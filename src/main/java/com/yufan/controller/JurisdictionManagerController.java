package com.yufan.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yufan.bean.Page;
import com.yufan.service.JurisdictionService;


@Controller
@RequestMapping("/jurisdiction")
public class JurisdictionManagerController {
	
	@Autowired 
	private JurisdictionService jurisdictionService;
	
	@RequiresPermissions("jurisdiction:jurisdiction:view")
	@RequestMapping(method = RequestMethod.GET)
	public String jurisdictionList(Model model,Page page){
	
		model.addAttribute("jurisdictionList", jurisdictionService.queryJurisdictionByPage(page).getJurisdictionList());
		return "jurisdictionmanager";
	}
	
}
