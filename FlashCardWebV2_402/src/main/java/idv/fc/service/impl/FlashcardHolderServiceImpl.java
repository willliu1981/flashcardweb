package idv.fc.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import idv.CC;
import idv.debug.Debug;
import idv.fc.dao.itf.FlashcardHolderDao;
import idv.fc.model.FlashcardHolder;
import idv.fc.model.dto.FlashcardHolderDTO;
import idv.fc.model.dto.simpledto.SimplePageInfoDTO;
import idv.fc.model.dto.simpledto.SimpleVO;
import idv.fc.service.abstraction.IFlashcardHolderService;

@Service("flashcardHolderService")
public class FlashcardHolderServiceImpl implements IFlashcardHolderService {

	@Autowired
	//@Resource
	private FlashcardHolderDao flashcardHolderDao;

	@Override
	public List<FlashcardHolder> getAll() {
		return flashcardHolderDao.selectAll();
	}

	@Override
	public FlashcardHolder getById(String id) {
		try {
			return flashcardHolderDao.selectById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addNew(FlashcardHolder model) {
		try {
			flashcardHolderDao.create(model);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(FlashcardHolder model) {
		try {
			flashcardHolderDao.update(model);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(String id) {
		try {
			flashcardHolderDao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<FlashcardHolderDTO> getAllJoinFc() {
		return this.flashcardHolderDao.selectAllJoinFc();
	}

	@Override
	public SimplePageInfoDTO getAllWithSimplePageInfoDTO(Page<Object> startPage,
			int maxNavPageNums) {

		List<FlashcardHolder> all = this.getAll();

		Debug.test(new CC() {
		}, "size", all.size());

		PageInfo<FlashcardHolder> pageInfo = new PageInfo<>(all,
				maxNavPageNums);

		SimplePageInfoDTO dto = new SimplePageInfoDTO();
		dto.setHasNextPage(pageInfo.isHasNextPage());
		dto.setHasPreviouPage(pageInfo.isHasPreviousPage());
		dto.setIsLastPage(pageInfo.isIsLastPage());
		dto.setPageNum(pageInfo.getPageNum());
		dto.setNavigateLastPage(pageInfo.getNavigateLastPage());

		List<SimpleVO> collect = pageInfo.getList().stream()
				.map(x -> new SimpleVO(x.getId().toString(), x.getName()))
				.collect(Collectors.toList());
		dto.setList(collect);
		dto.setNavigatepageNums(pageInfo.getNavigatepageNums());

		return dto;
	}

}
