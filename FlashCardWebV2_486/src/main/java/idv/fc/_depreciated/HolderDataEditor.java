package idv.fc._depreciated;

import idv.fc.model.dto.HolderDataDTO;
import idv.kw.tag.component.DefaultComponent;
import idv.kw.tag.facade.Editor;

public class HolderDataEditor extends Editor<HolderDataDTO> {
	private boolean isEdit;

	public HolderDataEditor(HolderDataDTO data) {
		super(data);
	}

	@Override
	public void init() {
		isEdit = this.getData().getId() != null;

		if (isEdit) {
			this.addAttribute("jumboTitle", "編輯 Holder Data");
			this.addAttribute("formTitle", "編輯 Holder Data");
		} else {
			this.addAttribute("jumboTitle", "新增 Holder Data");
			this.addAttribute("formTitle", "新增 Holder Data");
		}

		this.addAttribute("path", "holderData");
		this.addAttribute("formBody", this.getBody());

		//selected list   //***selected-list 修改這裡
		this.addAttribute("selectedModelRenderable", "true");//用於頁面判斷是否有 selected-list 功能
		this.addAttribute("selectedModelTitle", "FlashcardHolder");
		this.addAttribute("selectedModelQueryPath", "flashcardHolders");
	}

	public String getBody() {
		StringBuffer buffer = new StringBuffer();

		createFHID(buffer);
		if (isEdit) {
			createHiddenForPut(buffer);
		}

		return buffer.toString();
	}

	protected void createFHID(StringBuffer buffer) {
		DefaultComponent cmptFormGroup = new DefaultComponent("div");
		cmptFormGroup.addHtmlClass("form-group");

		//body
		StringBuffer bufBody = new StringBuffer();
		{
			DefaultComponent cmptLabel = new DefaultComponent("label");
			cmptLabel.addAttribute("for", "fhId");
			cmptLabel.addHtmlClass("col-lg-2 control-label");
			cmptLabel.addBody("Flashcard Holder name");

			DefaultComponent cmptDiv = new DefaultComponent("div");
			cmptDiv.addHtmlClass("col-lg-10");
			{
				DefaultComponent cmptInputValue = new DefaultComponent("input");
				cmptInputValue.addHtmlClass("form-control");
				cmptInputValue.addAttribute("type", "text");
				cmptInputValue.addAttribute("id", "selectedValue");
				cmptInputValue.addAttribute("placeholder", "ex: 123");
				if (isEdit) {
					cmptInputValue.addAttribute("value",
							this.getData().getFlashcardHolderDTO().getName());
				}

				DefaultComponent cmptInputID = new DefaultComponent("input");
				cmptInputID.addHtmlClass("form-control");
				cmptInputID.addAttribute("type", "hidden");
				cmptInputID.addAttribute("name", "fhId");
				cmptInputID.addAttribute("id", "selectedId");
				cmptInputID.addAttribute("placeholder", "ex: 123");
				if (isEdit) {
					cmptInputID.addAttribute("value",
							this.getData().getFhId().toString());
				}
				//加入組件
				cmptDiv.addBody(cmptInputValue.toString())
						.addBody(cmptInputID.toString());
			}
			//加入組件
			bufBody.append(cmptLabel.toString()).append(cmptDiv.toString());
		}

		//加入組件
		cmptFormGroup.addBody(bufBody.toString());
		buffer.append(cmptFormGroup.toString());
	}

	protected void createHiddenForPut(StringBuffer buffer) {
		DefaultComponent cmpMethod = new DefaultComponent("input");
		cmpMethod.addAttribute("type", "hidden");
		cmpMethod.addAttribute("name", "_method");
		cmpMethod.addAttribute("value", "put");

		DefaultComponent cmptId = new DefaultComponent("input");
		cmptId.addAttribute("type", "hidden");
		cmptId.addAttribute("name", "id");
		cmptId.addAttribute("value", this.getData().getId().toString());

		buffer.append(cmpMethod.toString()).append(cmptId);
	}

}
