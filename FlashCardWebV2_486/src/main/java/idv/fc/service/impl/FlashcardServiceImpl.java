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
	public SimplePageInfoDTO getAllWithSimplePageInfoDTORequireCitedNumsArray(
			Page<Object> startPage, int maxNavPageNums) {

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
				.map(x -> new SimpleVO(x.getId().toString(),
						new String[] { x.getTerm() }))
				.collect(Collectors.toList());
		dto.setList(collect);
		dto.setNavigatepageNums(pageInfo.getNavigatepageNums());

		return dto;
	}

	//no require citedNumsArray
	@Override
	public SimplePageInfoDTO getAllWithSimplePageInfoDTO(Page<Object> startPage,
			int maxNavPageNums) {

		List<Flashcard> all = this.getAll();

		PageInfo<Flashcard> pageInfo = new PageInfo<>(all, maxNavPageNums);

		SimplePageInfoDTO dto = new SimplePageInfoDTO();
		dto.setHasNextPage(pageInfo.isHasNextPage());
		dto.setHasPreviouPage(pageInfo.isHasPreviousPage());
		dto.setIsLastPage(pageInfo.isIsLastPage());
		dto.setPageNum(pageInfo.getPageNum());
		dto.setPages(pageInfo.getPages());

		List<SimpleVO> collect = pageInfo.getList().stream()
				.map(x -> new SimpleVO(x.getId().toString(),
						new String[] { x.getTerm(), x.getDefinition() }))
				.collect(Collectors.toList());
		dto.setList(collect);
		dto.setNavigatepageNums(pageInfo.getNavigatepageNums());

		return dto;
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
				.map(x -> new SimpleVO(x.getId().toString(),
						new String[] { x.getTerm(), x.getDefinition() }))
				.collect(Collectors.toList());
		dto.setList(collect);
		dto.setNavigatepageNums(pageInfo.getNavigatepageNums());

		return dto;
	}

	@Override
	public Integer getSearchPageNum(int pageSize, String pattern) {
		int total = 0, totalOfLeadBy = 0, pageNum = 0;
		try {
			total = this.flashcardDao.countByTermUsingLike(pattern);
			totalOfLeadBy = this.flashcardDao
					.countByTermUsingLikeLeadByPattern(pattern);

			/*
			 * 原始應為 total - totalOfLeadBy + 1 - 1
			 * +1 表示:前面為不包含,因此+1 即為下一筆資料
			 * -1 表示:剛好整除時會進行+1,因此-1可防止這個問題
			 * 
			 * 補充: pageSize + 1 的+1: 因為 navigate的第一頁從1開始
			 */
			pageNum = (total - totalOfLeadBy) / pageSize + 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		Debug.test(new CC() {
		}, "page num " + total, totalOfLeadBy);
		return pageNum;
	}

}
