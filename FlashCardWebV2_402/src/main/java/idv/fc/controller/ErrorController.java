package idv.fc.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
	@RequestMapping(value = "error")
	public String route(HashMap<String, String> model, HttpServletRequest request) {

		String errorMsg = "";
		switch ((Integer) request.getAttribute("javax.servlet.error.status_code")) {
		case 400:
			errorMsg = "400:Bad Request";
			break;
		case 401:
			errorMsg = "401:Unauthorized";
			break;
		case 404:
			errorMsg = "404:Resource not found";
			break;
		case 500:
			errorMsg = "500:Internal Server Error";
			break;
		default:
			errorMsg = "other error";
			break;
		}
		model.put("errorMsg", errorMsg);
		return "error/errorPage";
	}
}
