package idv.kwl.handle.controller.concrete;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import idv.kwl.bean.factory.SpringUtil;
import idv.kwl.dao.concrete.CardDao;
import idv.kwl.model.Card;

@Controller
@RequestMapping(value = "word/card")
public class CardMultiController {

	@RequestMapping(value = "add")
	public String add(Model model, Card card) {
		CardDao dao = (CardDao) SpringUtil.getBean("CardDao");

		System.out.println(this.getClass() + ": "+card.getVid());
		
		card.setCreate_date(Date.valueOf(LocalDate.now()));

		dao.create(card);


		return "testresult";
	}

}
