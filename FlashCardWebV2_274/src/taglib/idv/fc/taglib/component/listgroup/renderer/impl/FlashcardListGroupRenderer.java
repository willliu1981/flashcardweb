package idv.fc.taglib.component.listgroup.renderer.impl;

import javax.servlet.http.HttpServletRequest;

import idv.fc.model.Flashcard;
import idv.fc.taglib.component.Badge;
import idv.fc.taglib.component.listgroup.ListGroupItemHeading;
import idv.fc.taglib.component.listgroup.ListGroupItemText;
import idv.fc.taglib.component.listgroup.renderer.ListGroupRenderer;

public class FlashcardListGroupRenderer
		implements ListGroupRenderer<Flashcard> {
	private final String pathForCRUD = "flashcard";
	private final String badgeSpanSheet = "text-align: center; padding-left: 20px;"
			+ " padding-right: 20px;";
	private HttpServletRequest request;

	public FlashcardListGroupRenderer(HttpServletRequest request) {
		this.request = request;
	}

	@Override
	public String getRenderedBefore() {
		StringBuilder scriptSB = new StringBuilder();
		scriptSB.append("location.href='").append(request.getContextPath())
				.append("/").append(pathForCRUD).append("'");

		Badge badge = new Badge();
		badge.addStyleSheet(badgeSpanSheet);
		badge.addStyleSheet("font-size:24px");
		badge.setText("ADD");
		badge.onClick(scriptSB.toString());

		return badge.getHtmlCode();
	}

	@Override
	public String getRenderedResult(Flashcard model) {
		//delete badge begin
		StringBuilder deleteScriptSB = new StringBuilder();
		deleteScriptSB.append("modelValues").append("('");//script begin
		deleteScriptSB.append(model.getId()).append("','")
				.append(model.getTerm()).append("','")
				.append(model.getDefinition());//script parameter
		deleteScriptSB.append("')");//script end

		Badge deleteBadge = new Badge();
		deleteBadge.addStyleSheet(badgeSpanSheet);
		deleteBadge.addStyleSheet("background:red");
		deleteBadge.addStyleSheet("font-size:18px");
		deleteBadge.addAttribute("data-target", "#listDeleteModal")
				.addAttribute("data-toggle", "modal");
		deleteBadge.setText("DELETE");
		deleteBadge.onClick(deleteScriptSB.toString());
		//delete badge end

		//edit badge begin
		StringBuilder editScriptSB = new StringBuilder();
		editScriptSB.append("location.href=").append("'");//href begin
		editScriptSB.append(request.getContextPath()).append("/");//context path
		editScriptSB.append(pathForCRUD).append("/").append(model.getId());//rest path
		editScriptSB.append("'");//herf end

		Badge editBadge = new Badge();
		editBadge.addStyleSheet(badgeSpanSheet);
		//editBadge.addStyleSheet("background:blue");//註解以使用預設藍色
		editBadge.addStyleSheet("font-size:17px");
		editBadge.setText("EDIT");
		editBadge.onClick(editScriptSB.toString());
		//edit badge end

		ListGroupItemHeading heading = new ListGroupItemHeading();
		heading.addHtmlClass("h3");
		heading.setText(model.getTerm());

		ListGroupItemText text = new ListGroupItemText();
		//text.addHtmlClass("h4");//改變font size , 但也改變了顏色
		text.addStyleSheet("font-size:22px");
		text.setText(model.getDefinition());

		//組合
		StringBuilder sb = new StringBuilder();
		sb.append(deleteBadge.getHtmlCode()).append(editBadge.getHtmlCode());//badge
		sb.append(heading.getHtmlCode()).append(" ").append(text.getHtmlCode());//heading & text

		return sb.toString();
	}

	@Override
	public String getRenderedAfter(Flashcard model) {
		return SKIP;
	}

}
