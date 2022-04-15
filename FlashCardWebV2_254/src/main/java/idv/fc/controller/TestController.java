package idv.fc.controller;

import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import idv.fc.dao.abstraction.Dao;
import idv.fc.exception.FindErrorException;
import idv.fc.model.User;
import idv.fc.model.Vocabulary;
import idv.fc.proxy.ProxyFactory;
import idv.fc.proxy.concretion.UserFaker;
import idv.fc.proxy.interceptor.Shuttle;
import idv.test.Car;
import idv.tool.Debug;
import idv.tool.spring.SpringUtil;

@Controller
@RequestMapping(value = "test")
public class TestController {

	@RequestMapping(value = "test1")
	public String query() {

	System.out.println("test1");
		return "test/test1";
	}

	
}
