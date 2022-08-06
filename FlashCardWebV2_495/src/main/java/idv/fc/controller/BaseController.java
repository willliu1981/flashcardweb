package idv.fc.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseController {
	protected static Logger logger = LoggerFactory
			.getLogger(FlashcardsController.class);

	private static String version = null;

	protected static String getStaticVersion(HttpServletRequest request) {
		if (version == null) {
			version = request.getServletContext().getInitParameter("version");
		}

		return version;
	}
}
