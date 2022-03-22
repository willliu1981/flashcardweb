package idv.fc.proxy.interceptor;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import idv.fc.annotation.AnnotationFactory;
import idv.fc.proxy.interceptor.InterceptHandlerWrap.ParamWrap;
import idv.tool.Debug;

/**
 * 應用於 InterceptorImpl
 * @author KuanWei
 *
 */
public abstract class InterceptHandler {
	protected String name = "base";
	private MethodFilter methodFilter = new MethodFilter();

	public static class MethodFilter {
		private List<String> methodNames = new ArrayList<>();

		public MethodFilter filter(String filed) {
			methodNames.add(filed);
			return this;
		}

		protected boolean isContain(String name) {
			if (methodNames.contains(name)) {
				return true;
			}

			if (name.startsWith("set") || name.startsWith("get")) {
				char head = name.charAt(3);

				if (Character.isUpperCase(head)) {

					return methodNames
							.contains(Character.toLowerCase(head) + name.substring(4));
				}
			}

			return false;
		}

	}

	public InterceptHandler() {
		this.name = this.getClass().getSimpleName();
		init(this.methodFilter);
	}

	abstract protected void init(MethodFilter methodFilter);

	public String getName() {
		return name;
	}

	/*
	 * notice:使用 MethodFilter 會與 annotation 疊加過瀘
	 */
	protected MethodFilter filterMethod(String name) {
		return methodFilter.filter(name);
	}

	protected abstract boolean preHandle(ParamWrap paramWrap);

	public boolean doPreHandle(ParamWrap paramWrap) {
		boolean matchAnnotation = false;
		for (Annotation anno : paramWrap.getMethod().getAnnotations()) {
			matchAnnotation = anno.annotationType().getCanonicalName()
					.equals(AnnotationFactory.getAnnotationPathString("Authorized"));
			break;
		}

		//Debug.test(this, paramWrap.getMethodProxy().getSignature().getName());

		boolean methodFilterContain = methodFilter
				.isContain(paramWrap.getMethodProxy().getSignature().getName());

		if (matchAnnotation || methodFilterContain) {
			return preHandle(paramWrap);
		}

		return true;

	}

	public abstract void postHandle(ParamWrap paramWrap);

	public void doPostHandle(ParamWrap paramWrap) {
		postHandle(paramWrap);
	}
}
