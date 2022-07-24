package idv.fc._depreciated;

import idv.fc.model.dto.FlashcardHolderDTO;
import idv.kw.tag.component.DefaultComponent;
import idv.kw.tag.facade.Editor;

public class FlashcardHolderEditor extends Editor<FlashcardHolderDTO> {
	private boolean isEdit = false;

	public FlashcardHolderEditor(FlashcardHolderDTO data) {
		super(data);
	}

	@Override
	public void init() {
		isEdit = this.getData().getId() != null;

		if (isEdit) {
			this.addAttribute("jumboTitle", "編輯 Flashcard Holder");
			this.addAttribute("formTitle", "編輯 Flashcard Holder");
		} else {
			this.addAttribute("jumboTitle", "新增 Flashcard Holder");
			this.addAttribute("formTitle", "新增 Flashcard Holder");
		}

		this.addAttribute("path", "flashcardHolder");
		this.addAttribute("formBody", this.getBody());

		//selected list  //***selected-list 修改這裡
		this.addAttribute("selectedModelRenderable", "true");//用於頁面判斷是否有 selected-list 功能
		this.addAttribute("selectedModelTitle", "Flashcard");
		this.addAttribute("selectedModelQueryPath", "flashcards");
	}

	public String getBody() {
		StringBuffer buffer = new StringBuffer();

		createName(buffer);
		createFCID(buffer);
		if (isEdit) {
			createHiddenForPut(buffer);
		}

		return buffer.toString();
	}

	protected void createName(StringBuffer buffer) {
		DefaultComponent cmptFormGroup = new DefaultComponent("div");
		cmptFormGroup.addHtmlClass("form-group");

		//term body
		StringBuffer bufBody = new StringBuffer();
		{
			DefaultComponent cmptLabel = new DefaultComponent("label");
			cmptLabel.addAttribute("for", "name");
			cmptLabel.addHtmlClass("col-lg-2 control-label");
			cmptLabel.addBody("Name");

			DefaultComponent cmptDiv = new DefaultComponent("div");
			cmptDiv.addHtmlClass("col-lg-10");
			{

				DefaultComponent cmptInput = new DefaultComponent("input");
				cmptInput.addHtmlClass("form-control");
				cmptInput.addAttribute("name", "name");
				cmptInput.addAttribute("id", "name");
				cmptInput.addAttribute("placeholder", "ex: apple");
				if (isEdit) {
					cmptInput.addAttribute("value", this.getData().getName());
				}
				//加入組件
				cmptDiv.addBody(cmptInput.toString());
			}
			//加入組件
			bufBody.append(cmptLabel.toString()).append(cmptDiv.toString());
		}

		//加入組件
		cmptFormGroup.addBody(bufBody.toString());
		buffer.append(cmptFormGroup.toString());
	}

	protected void createFCID(StringBuffer buffer) {
		DefaultComponent cmptFormGroup = new DefaultComponent("div");
		cmptFormGroup.addHtmlClass("form-group");

		//term body
		StringBuffer bufBody = new StringBuffer();
		{
			DefaultComponent cmptLabel = new DefaultComponent("label");
			cmptLabel.addAttribute("for", "fcId");
			cmptLabel.addHtmlClass("col-lg-2 control-label");
			cmptLabel.addBody("Flashcard Id");

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
							this.getData().getFlashcard().getTerm());
				}

				DefaultComponent cmptInputID = new DefaultComponent("input");
				cmptInputID.addHtmlClass("form-control");
				cmptInputID.addAttribute("type", "hidden");
				cmptInputID.addAttribute("name", "fcId");
				cmptInputID.addAttribute("id", "selectedId");
				cmptInputID.addAttribute("placeholder", "ex: 123");
				if (isEdit && this.getData().getFcId() != null) {
					cmptInputID.addAttribute("value",
							this.getData().getFcId().toString());
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
