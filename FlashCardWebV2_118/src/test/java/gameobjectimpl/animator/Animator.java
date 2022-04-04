package gameobjectimpl.animator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import idv.tool.Debug;

public class Animator {
	private List<KeyFrame> keyFrames = new ArrayList<>();
	private Integer maxNumberOfKey;

	public Integer getMaxNumberOfKey() {
		return maxNumberOfKey;
	}

	public void setMaxNumberOfKey(Integer maxKeys) {
		this.maxNumberOfKey = maxKeys;
	}

	public List<KeyFrame> getKeyFrames() {
		return keyFrames;
	}

	public void setKeyFrames(List<KeyFrame> keyFrames) {
		this.keyFrames = keyFrames;
	}

	public void addKeyFrame(KeyFrame keyFrame) {

		boolean contains = keyFrames.contains(keyFrame);

		if (contains) {
			keyFrames.remove(keyFrames.stream()
					.filter(key -> key.getKeyName().equals(keyFrame.getKeyName()))
					.findAny().get());
		}

		this.keyFrames.add(keyFrame);
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

		@Override
		public int hashCode() {
			int prime = 31;
			int res = 1;
			res = prime * res + this.getKeyName().hashCode();
			res = prime * res + this.getKeyIndex();

			return res;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == null) {
				return false;
			}

			if (this == obj) {
				return true;
			}

			if (!obj.getClass().equals(this.getClass())) {
				return false;
			}

			KeyFrame other = (KeyFrame) obj;
			if (other.getKeyName().equals(this.getKeyName())
					&& other.getKeyIndex().equals(this.getKeyIndex())) {
				return true;
			}

			return false;
		}

	}

}
