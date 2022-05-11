package idv.taglib.component.common;

public interface Renderable {
	/* String BODY = "${body}"
	 * 於宣染器中標註後,jap tag body 的內容將取代 這個佔位符的位置
	 * ex: <form method="post"> ${body} </form> ,
	 * jsp taglib : <xx:form> <button /> <xx:form> ,
	 * 渲染後: <form method="post"> <button /> </form>
	 */
	String BODY = "${body}";
}
