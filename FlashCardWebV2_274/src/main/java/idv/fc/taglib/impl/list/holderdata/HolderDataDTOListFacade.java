package idv.fc.taglib.impl.list.holderdata;

import java.util.List;

import idv.fc.dto.HolderDataDTO;
import idv.taglib.component.listgroup.ListGroup;
import idv.taglib.component.modal.Modal;
import idv.taglib.factory.lister.ListFacadeAdapter;
import idv.taglib.listgroup.listmodel.DefaultListGroupModel;

public class HolderDataDTOListFacade extends ListFacadeAdapter<HolderDataDTO> {

	private final String pathForCRUD = "holderData";
	private final String pathForPager = "flashcards/hdManager";
	private static String title = "Holder Data";// 傳入 Renderer 的 Title
	private static String jumbotronTitle = "管理 Holder Data";//managedPage 顯示 巨屏 Title
	private static String active = "holderDataManager";//managedPage 導航欄 的 active

	public HolderDataDTOListFacade(List<HolderDataDTO> datas) {
		super(datas);
	}

	@Override
	protected void configureListGroupAndModal(ListGroup<HolderDataDTO> listGroup,
			Modal<HolderDataDTO> modal) {

		DefaultListGroupModel<HolderDataDTO> model = new DefaultListGroupModel<>();
		this.getDatas().stream().forEach(item -> model.addItem(item));
		listGroup.setModel(model);

		HolderDataDTOListGroupRenderer lgRenderer = new HolderDataDTOListGroupRenderer(
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
