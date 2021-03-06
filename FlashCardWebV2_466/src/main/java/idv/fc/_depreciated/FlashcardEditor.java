package idv.fc._depreciated;

import idv.fc.model.Flashcard;
import idv.kw.tag.component.DefaultComponent;
import idv.kw.tag.facade.Editor;
import idv.kw.tag.factory.TagBuilder;

public class FlashcardEditor extends Editor<Flashcard> {
	private boolean isEdit = false;

	public FlashcardEditor(Flashcard data) {
		super(data);
	}

	@Override
	public void init() {
		isEdit = this.getData().getId() != null;

		if (isEdit) {
			this.addAttribute("jumboTitle", "編輯 Flashcard");
			this.addAttribute("formTitle", "編輯 Flashcard");
		} else {
			this.addAttribute("jumboTitle", "新增 Flashcard");
			this.addAttribute("formTitle", "新增 Flashcard");
		}

		this.addAttribute("path", "flashcard");
		this.addAttribute("formBody", this.getBody());
	}

	public String getBody() {
		StringBuffer buffer = new StringBuffer();

		createTerm(buffer);
		createDefinition(buffer);
		if (isEdit) {
			createHiddenForPut(buffer);
		}

		return buffer.toString();
	}

	protected void createTerm(StringBuffer buffer) {
		DefaultComponent cmptFormGroup = new DefaultComponent("div");
		cmptFormGroup.addHtmlClass("form-group");

		//term body
		StringBuffer bufBody = new StringBuffer();
		{
			DefaultComponent cmptLabel = new DefaultComponent("label");
			cmptLabel.addAttribute("for", "term");
			cmptLabel.addHtmlClass("col-lg-2 control-label");
			cmptLabel.addBody("Term");

			DefaultComponent cmptDiv = new DefaultComponent("div");
			cmptDiv.addHtmlClass("col-lg-10");
			{
				DefaultComponent cmptInput = new DefaultComponent("input");
				cmptInput.addHtmlClass("form-control");
				cmptInput.addAttribute("name", "term");
				cmptInput.addAttribute("id", "term");
				cmptInput.addAttribute("placeholder", "ex: apple");
				if (isEdit) {
					cmptInput.addAttribute("value", this.getData().getTerm());
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

	protected void createDefinition(StringBuffer buffer) {
		DefaultComponent cmptFormGroup = new DefaultComponent("div");
		cmptFormGroup.addHtmlClass("form-group");

		//term body
		StringBuffer bufBody = new StringBuffer();
		{
			DefaultComponent cmptLabel = new DefaultComponent("label");
			cmptLabel.addAttribute("for", "definition");
			cmptLabel.addHtmlClass("col-lg-2 control-label");
			cmptLabel.addBody("Definition");

			DefaultComponent cmptDiv = new DefaultComponent("div");
			cmptDiv.addHtmlClass("col-lg-10");
			{
				DefaultComponent cmptInput = new DefaultComponent("input");
				cmptInput.addHtmlClass("form-control");
				cmptInput.addAttribute("name", "definition");
				cmptInput.addAttribute("id", "definition");
				cmptInput.addAttribute("placeholder", "ex: 蘋果");
				if (isEdit) {
					cmptInput.addAttribute("value",
							this.getData().getDefinition());
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
