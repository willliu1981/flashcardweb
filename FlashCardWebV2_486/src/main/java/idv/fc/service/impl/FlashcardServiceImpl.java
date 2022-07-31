package idv.fc.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import idv.CC;
import idv.debug.Debug;
import idv.fc.dao.itf.FlashcardDao;
import idv.fc.dao.itf.FlashcardHolderDao;
import idv.fc.model.Flashcard;
import idv.fc.model.dto.simpledto.SimplePageInfoDTO;
import idv.fc.model.dto.simpledto.SimpleVO;
import idv.fc.service.abstraction.IFlashcardService;

@Service("flashcardService")
public class FlashcardServiceImpl implements IFlashcardService {

	@Autowired
	private FlashcardDao flashcardDao;

	@Autowired
	private FlashcardHolderDao flashcardHolderDao;

	@Override
	public List<Flashcard> getAll() {
		return flashcardDao.selectAll();
	}

	@Override
	public Flashcard getById(String id) {
		try {
			return flashcardDao.selectById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Flashcard getByTerm(String term) {
		try {
			return this.flashcardDao.selectByTerm(term);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addNew(Flashcard model) {
		try {
			flashcardDao.create(model);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Flashcard model) {
		try {
			flashcardDao.update(model);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(String id) {
		try {
			flashcardDao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public SimplePageInfoDTO getAllWithSimplePageInfoDTO(Page<Object> startPage,
			int maxNavPageNums) {

		List<Flashcard> all = this.getAll();

		int[] citedNumsArray = all.stream().mapToInt(x -> {
			return flashcardHolderDao.selectCountByFCID(x.getId());
		}).toArray();

		PageInfo<Flashcard> pageInfo = new PageInfo<>(all, maxNavPageNums);

		SimplePageInfoDTO dto = new SimplePageInfoDTO();
		dto.setHasNextPage(pageInfo.isHasNextPage());
		dto.setHasPreviouPage(pageInfo.isHasPreviousPage());
		dto.setIsLastPage(pageInfo.isIsLastPage());
		dto.setPageNum(pageInfo.getPageNum());
		dto.setPages(pageInfo.getPages());
		dto.setCitedNums(citedNumsArray);

		List<SimpleVO> collect = pageInfo.getList().stream()
				.map(x -> new SimpleVO(x.getId().toString(), x.getTerm()))
				.collect(Collectors.toList());
		dto.setList(collect);
		dto.setNavigatepageNums(pageInfo.getNavigatepageNums());

		return dto;
	}

	@Override
	public Integer countByTermUsingLikeConditionLeadByPattern(String pattern) {
		Integer count = null;

		try {
			count = this.flashcardDao
					.countByTermUsingLikeLeadByPattern(pattern);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public SimplePageInfoDTO getByTermUsingLikeCondition(Page<Object> startPage,
			int maxNavPageNums, String pattern) {
		List<Flashcard> result = new ArrayList<>();

		try {
			result = this.flashcardDao.selectByTermUsingLike(pattern);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		PageInfo<Flashcard> pageInfo = new PageInfo<>(result, maxNavPageNums);

		SimplePageInfoDTO dto = new SimplePageInfoDTO();
		dto.setHasNextPage(pageInfo.isHasNextPage());
		dto.setHasPreviouPage(pageInfo.isHasPreviousPage());
		dto.setIsLastPage(pageInfo.isIsLastPage());
		dto.setPageNum(pageInfo.getPageNum());
		dto.setPages(pageInfo.getPages());

		List<SimpleVO> collect = pageInfo.getList().stream()
				.map(x -> new SimpleVO(x.getId().toString(), x.getTerm()))
				.collect(Collectors.toList());
		dto.setList(collect);
		dto.setNavigatepageNums(pageInfo.getNavigatepageNums());

		return dto;
	}

}
