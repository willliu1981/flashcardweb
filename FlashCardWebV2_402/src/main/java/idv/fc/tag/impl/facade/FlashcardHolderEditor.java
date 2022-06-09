package idv.fc.tag.impl.facade;

import idv.fc.model.FlashcardHolder;
import idv.kw.tag.component.DefaultComponent;
import idv.kw.tag.facade.Editor;

public class FlashcardHolderEditor extends Editor<FlashcardHolder> {
	private boolean isAdd = false;
	//html class : 使能接受 setected-list 的 value   //***selected-list 修改這裡
	private static final String FORM_CONTROL_ACCEPTABLE = "form-control-acceptable";

	public FlashcardHolderEditor(FlashcardHolder data) {
		super(data);
	}

	@Override
	public void init() {
		isAdd = this.getData().getId() == null;

		if (isAdd) {
			this.addAttribute("jumboTitle", "新增 Flashcard Holder");
			this.addAttribute("formTitle", "新增 Flashcard Holder");
		} else {
			this.addAttribute("jumboTitle", "編輯 Flashcard Holder");
			this.addAttribute("formTitle", "編輯 Flashcard Holder");
		}

		this.addAttribute("path", "flashcardHolder");
		this.addAttribute("formBody", this.getBody());

		//selected list  //***selected-list 修改這裡
		this.addAttribute("selectedModelRenderable", "true");//用於頁面判斷是否有 selected-list 功能
		this.addAttribute("selectedModelTitle", "Flashcard");
		this.addAttribute("selectedModelQueryPath", "flashcards");
		this.addAttribute("selectedModelAccept", FORM_CONTROL_ACCEPTABLE);//和頁面約定的class name
	}

	public String getBody() {
		StringBuffer buffer = new StringBuffer();

		createName(buffer);
		createFCID(buffer);
		if (!isAdd) {
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
			cmptLabel.setBody("Name");

			DefaultComponent cmptDiv = new DefaultComponent("div");
			cmptDiv.addHtmlClass("col-lg-10");
			{
				DefaultComponent cmptInput = new DefaultComponent("input");
				cmptInput.addHtmlClass("form-control");
				cmptInput.addAttribute("name", "name");
				cmptInput.addAttribute("id", "name");
				cmptInput.addAttribute("placeholder", "ex: apple");
				if (!isAdd) {
					cmptInput.addAttribute("value", this.getData().getName());
				}
				//加入組件
				cmptDiv.setBody(cmptInput.toString());
			}
			//加入組件
			bufBody.append(cmptLabel.toString()).append(cmptDiv.toString());
		}

		//加入組件
		cmptFormGroup.setBody(bufBody.toString());
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
			cmptLabel.setBody("Flashcard Id");

			DefaultComponent cmptDiv = new DefaultComponent("div");
			cmptDiv.addHtmlClass("col-lg-10");
			{
				DefaultComponent cmptInput = new DefaultComponent("input");
				cmptInput.addHtmlClass("form-control")
						.addHtmlClass(FORM_CONTROL_ACCEPTABLE); //***selected-list 修改這裡
				cmptInput.addAttribute("name", "fcId");
				cmptInput.addAttribute("id", "fcId");
				cmptInput.addAttribute("placeholder", "ex: 123");
				if (!isAdd && this.getData().getFcId() != null) {
					cmptInput.addAttribute("value",
							this.getData().getFcId().toString());
				}
				//加入組件
				cmptDiv.setBody(cmptInput.toString());
			}
			//加入組件
			bufBody.append(cmptLabel.toString()).append(cmptDiv.toString());
		}

		//加入組件
		cmptFormGroup.setBody(bufBody.toString());
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
