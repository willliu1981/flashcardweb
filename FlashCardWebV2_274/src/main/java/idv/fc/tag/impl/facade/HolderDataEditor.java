package idv.fc.tag.impl.facade;

import idv.fc.model.HolderData;
import idv.kw.tag.component.DefaultComponent;
import idv.kw.tag.facade.Editor;
import idv.kw.tag.factory.TagBuilder;

public class HolderDataEditor extends Editor<HolderData> {
	private boolean isAdd = false;

	public HolderDataEditor(HolderData data) {
		super(data);
	}

	@Override
	public void init() {
		isAdd = this.getData().getId() == null;

		if (isAdd) {
			this.addAttribute("jumboTitle", "新增 Holder Data");
			this.addAttribute("formTitle", "新增 Holder Data");
		} else {
			this.addAttribute("jumboTitle", "編輯 Holder Data");
			this.addAttribute("formTitle", "編輯 Holder Data");
		}

		this.addAttribute("path", "holderData");
		this.addAttribute("formBody", this.getBody());
	}

	public String getBody() {
		StringBuffer buffer = new StringBuffer();

		createFHID(buffer);
		if (!isAdd) {
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
			cmptLabel.setBody("Flashcard Holder Id");

			DefaultComponent cmptDiv = new DefaultComponent("div");
			cmptDiv.addHtmlClass("col-lg-10");
			{
				DefaultComponent cmptInput = new DefaultComponent("input");
				cmptInput.addHtmlClass("form-control");
				cmptInput.addAttribute("name", "fhId");
				cmptInput.addAttribute("id", "fhId");
				cmptInput.addAttribute("placeholder", "ex: 123");
				if (!isAdd) {
					cmptInput.addAttribute("value",
							this.getData().getFhId().toString());
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
