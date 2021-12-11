package com.btec.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.btec.dto.UserDTO;
import com.btec.service.IUserService;
import com.btec.util.MessageUtil;

@Controller(value = "accControllerOfAdmin")
public class AccountController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/admin/manageaccount", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, 
								 @RequestParam("limit") int limit) {
		UserDTO model = new UserDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/manageaccount");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(userService.findAll(pageable));
		model.setTotalItem(userService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		mav.addObject("model", model);
		return mav;
	}
}
