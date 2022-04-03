package gameobjectimpl;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Animator {
	private List<KeyFrame> keyFrames = new ArrayList<>();

	public List<KeyFrame> getKeyFrames() {
		return keyFrames;
	}

	public void setKeyFrames(List<KeyFrame> keyFrames) {
		this.keyFrames = keyFrames;
	}

	public static class KeyFrame {
		private String keyName;
		private Integer KeyIndex;
		private Point position;

		public String getKeyName() {
			return keyName;
		}

		public void setKeyName(String keyName) {
			this.keyName = keyName;
		}

		public Integer getKeyIndex() {
			return KeyIndex;
		}

		public void setKeyIndex(Integer keyIndex) {
			KeyIndex = keyIndex;
		}

		public Point getPosition() {
			return position;
		}

		public void setPosition(Point position) {
			this.position = position;
		}

	}

}
