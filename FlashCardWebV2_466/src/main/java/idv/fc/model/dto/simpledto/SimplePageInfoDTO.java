package idv.fc.model.dto.simpledto;

import java.util.ArrayList;
import java.util.List;

public class SimplePageInfoDTO {
	private Integer pageNum;
	private Integer navigateLastPage;
	private boolean isHasPreviouPage;
	private boolean isHasNextPage;
	private boolean isIsLastPage;
	private List<SimpleVO> list = new ArrayList<>();
	private int[] navigatepageNums;
	private int[] citedNums;

	public int[] getNavigatepageNums() {
		return navigatepageNums;
	}

	public void setNavigatepageNums(int[] navigatepageNums) {
		this.navigatepageNums = navigatepageNums;
	}

	public Integer getNavigateLastPage() {
		return navigateLastPage;
	}

	public void setNavigateLastPage(Integer navigateLastPage) {
		this.navigateLastPage = navigateLastPage;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public boolean isHasPreviouPage() {
		return isHasPreviouPage;
	}

	public void setHasPreviouPage(boolean isHasPreviouPage) {
		this.isHasPreviouPage = isHasPreviouPage;
	}

	public boolean isHasNextPage() {
		return isHasNextPage;
	}

	public void setHasNextPage(boolean isHasNextPage) {
		this.isHasNextPage = isHasNextPage;
	}

	public boolean isIsLastPage() {
		return isIsLastPage;
	}

	public void setIsLastPage(boolean isIsLastPage) {
		this.isIsLastPage = isIsLastPage;
	}

	public List<SimpleVO> getList() {
		return list;
	}

	public void setList(List<SimpleVO> list) {
		this.list = list;
	}

	public int[] getCitedNums() {
		return citedNums;
	}

	public void setCitedNums(int[] citedNums) {
		this.citedNums = citedNums;
	}

}
