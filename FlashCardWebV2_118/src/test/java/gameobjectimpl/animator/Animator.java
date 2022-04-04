package gameobjectimpl.animator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import idv.tool.Debug;

public class Animator {
	private List<KeyFrame> keyFrames = new ArrayList<>();

	public List<KeyFrame> getKeyFrames() {
		return keyFrames;
	}

	public void setKeyFrames(List<KeyFrame> keyFrames) {
		this.keyFrames = keyFrames;
	}

	public void addKeyFrame(KeyFrame keyFrame) {
		Optional<KeyFrame> findAny = keyFrames.stream()
				.filter(key -> key.getKeyName().equals(keyFrame.getKeyName()))
				.findAny();
		if (findAny.isPresent()) {
			keyFrames.remove(findAny.get());
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

	}

}
