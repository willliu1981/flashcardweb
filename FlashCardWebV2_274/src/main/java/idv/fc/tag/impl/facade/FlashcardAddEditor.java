package idv.fc.tag.impl.facade;

import idv.fc.model.Flashcard;
import idv.kw.tag.component.DefaultComponent;
import idv.kw.tag.facade.Editor;

public class FlashcardAddEditor extends Editor<Flashcard> {

	public FlashcardAddEditor(Flashcard data) {
		super(data);
	}

	@Override
	public void init() {
		this.addAttribute("formTitle", "新增 Flashcard");
		this.addAttribute("formBody", this.getBody());
	}

	public String getBody() {
		StringBuffer buffer = new StringBuffer();

		createTerm(buffer);
		createDefinition(buffer);

		return buffer.toString();
	}

	/*
	 *  Term 格式
	 *  <div class="form-group">
	        <label for="term" class="col-lg-2 control-label">Term</label>
	        <div class="col-lg-10">
	            <frm:input path="term" id="term" cssClass="form-control" placeholder="ex: apple" />
	        </div>
	    </div>
	 */
	private void createTerm(StringBuffer buffer) {
		DefaultComponent cmptFormGroup = new DefaultComponent("div");
		cmptFormGroup.addHtmlClass("form-group");

		//term body
		StringBuffer bufBody = new StringBuffer();
		{
			DefaultComponent cmptLabel = new DefaultComponent("label");
			cmptLabel.addAttribute("for", "term");
			cmptLabel.addHtmlClass("col-lg-2 control-label");
			cmptLabel.setBody("Term");

			DefaultComponent cmptDiv = new DefaultComponent("div");
			cmptDiv.addHtmlClass("col-lg-10");
			{
				DefaultComponent cmptInput = new DefaultComponent("input");
				cmptInput.addHtmlClass("form-control");
				cmptInput.addAttribute("name", "term");
				cmptInput.addAttribute("id", "term");
				cmptInput.addAttribute("placeholder", "ex: apple");
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

	private void createDefinition(StringBuffer buffer) {
		DefaultComponent cmptFormGroup = new DefaultComponent("div");
		cmptFormGroup.addHtmlClass("form-group");

		//term body
		StringBuffer bufBody = new StringBuffer();
		{
			DefaultComponent cmptLabel = new DefaultComponent("label");
			cmptLabel.addAttribute("for", "definition");
			cmptLabel.addHtmlClass("col-lg-2 control-label");
			cmptLabel.setBody("Definition");

			DefaultComponent cmptDiv = new DefaultComponent("div");
			cmptDiv.addHtmlClass("col-lg-10");
			{
				DefaultComponent cmptInput = new DefaultComponent("input");
				cmptInput.addHtmlClass("form-control");
				cmptInput.addAttribute("name", "definition");
				cmptInput.addAttribute("id", "definition");
				cmptInput.addAttribute("placeholder", "ex: 蘋果");
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

}
