package test.injection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MenuDocument {
	enum ControlType {
		MAX_INFINITY, MIN_INFINITY, INFINITY
	}

	static public class Document {
		AttributeSet set;
		Integer minLimit;
		Integer maxLimit;

		public boolean isSmaller(int input) {
			if (maxLimit == null) {
				return true;
			} else {
				return input <= maxLimit;
			}
		}

		public boolean isLarger(int input) {
			if (minLimit == null) {
				return true;
			} else {
				return input >= minLimit;
			}
		}

		public Object getObject() {
			Object obj = Stream.generate(set.getComparator()).limit(1).findAny()
					.orElse(null);
			return obj;
		}

		public String getName() {
			return set.getName();
		}

	}

	List<Document> docs = new ArrayList<>();

	public Document getDocument(int age) {

		Document doc = docs.stream()
				.filter(x -> x.isSmaller(age) && x.isLarger(age)).findFirst()
				.orElse(null);
		return doc;
	}

	public void setComparatorAttributes(Integer minLimit, Integer maxLimit,
			AttributeSet set, boolean replace) {
		Document doc = new Document();
		doc.set = set;
		doc.maxLimit = maxLimit;
		doc.minLimit = minLimit;
		this.docs.add(doc);
	}

	public void setComparatorAttributes(ControlType limitType, int otherLimit,
			AttributeSet set, boolean replace) {
		Integer maxLimit = null;
		Integer minLimit = null;
		switch (limitType) {
		case MAX_INFINITY:
			minLimit = otherLimit;
			break;
		case MIN_INFINITY:
			maxLimit = otherLimit;
			break;
		case INFINITY:
			break;
		default:
			break;
		}

		setComparatorAttributes(minLimit, maxLimit, set, replace);
	}

}
