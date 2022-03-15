package idv.fc.enums;

public enum Authority {
	DEFAULT(0), ADMIN(2), COMMON(1);

	Integer value;

	Authority(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}
}
