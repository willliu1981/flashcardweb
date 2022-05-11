package idv.fc.taglib.impl.list.holderdata;

import java.util.List;

import idv.fc.model.HolderData;
import idv.fc.taglib.impl.list.ListFacadeAdapter;
import idv.taglib.component.listgroup.ListGroup;
import idv.taglib.component.modal.Modal;
import idv.taglib.listgroup.listmodel.DefaultListGroupModel;

public class HolderDataListFacade extends ListFacadeAdapter<HolderData> {

	private final String pathForCRUD = "holderData";
	private final String pathForPager = "flashcards/hdManager";
	private static String title = "Holder Data";// 傳入 Renderer 的 Title
	private static String jumbotronTitle = "管理 Holder Data";//managedPage 顯示 巨屏 Title
	private static String active = "holderDataManager";//managedPage 導航欄 的 active

	public HolderDataListFacade(List<HolderData> datas) {
		super(datas);
	}

	@Override
	protected void configureListGroupAndModal(ListGroup<HolderData> listGroup,
			Modal<HolderData> modal) {

		DefaultListGroupModel<HolderData> model = new DefaultListGroupModel<>();
		this.getDatas().stream().forEach(item -> model.addItem(item));
		listGroup.setModel(model);

		HolderDataListGroupRenderer lgRenderer = new HolderDataListGroupRenderer(
				this, title);
		listGroup.setRenderer(lgRenderer);

		HolderDataDeleteModalRenderer dmRenderer = new HolderDataDeleteModalRenderer(
				this, title);
		modal.setRenderer(dmRenderer);
	}

	@Override
	public String getJumbotronTitle() {
		return this.jumbotronTitle;
	}

	@Override
	public String getActive() {
		return this.active;
	}

	@Override
	public String getPathForCRUD() {
		return this.pathForCRUD;
	}

	@Override
	public String getPathForPager() {
		return this.pathForPager;
	}

}
