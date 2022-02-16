public class Test3 {

	interface IKey {
		void setKey(IKey k);

		IKey getKey();

		boolean process(int v);

		Keys.Key loopProcess(int v);
	}

	static IKey aKey = null;
	static IKey bKey = null;
	static IKey cKey = null;
	static IKey dKey = null;

	public static void main(String[] args) {
		initKey();
		int v = 155;

		Keys.Key key = getKey(v);
		System.out.println("key=" + key);

		switch (key) {
		case A:
			System.out.println("A is processing");
			break;
		case B:
			System.out.println("B is processing");
			break;
		case C:
			System.out.println("C is processing");
			break;
		case D:
			System.out.println("D is processing");
			break;

		default:
			break;
		}

	}

	public static Keys.Key getKey(int value) {

		return aKey.loopProcess(value);
	}

	public static void initKey() {
		dKey = new KeyD();
		cKey = new KeyC(dKey);
		bKey = new KeyB(cKey);
		aKey = new KeyA(bKey);
		dKey.setKey(aKey);
	}

	public static abstract class Keys {
		public static enum Key {
			A, B, C, D, E
		}

		Key key;
		IKey k;

		public Keys() {
		}

		public Keys(IKey k) {
			setKey(k);
		}

		public void setKey(IKey k) {
			this.k = k;
		}

		public IKey getKey() {
			return k;
		}

		public abstract boolean process(int v);

		public Key loopProcess(int v) {
			if (this.process(v)) {
				return key;
			} else {
				return k.loopProcess(v);
			}
		}

	}

	static class KeyA extends Keys implements IKey {

		public KeyA() {
		}

		public KeyA(Test3.IKey k) {
			super(k);
		}

		@Override
		public boolean process(int v) {
			System.out.println("process KeyA...");
			if (v >= 1 && v <= 100) {
				key = Key.A;
				return true;
			}
			return false;
		}

	}

	static class KeyB extends Keys implements IKey {

		public KeyB() {
		}

		public KeyB(Test3.IKey k) {
			super(k);
		}

		@Override
		public boolean process(int v) {
			System.out.println("process KeyB...");
			if (v >= 101 && v <= 200) {
				key = Key.B;
				return true;
			}
			return false;
		}

	}

	static class KeyC extends Keys implements IKey {

		public KeyC() {
		}

		public KeyC(Test3.IKey k) {
			super(k);
		}

		@Override
		public boolean process(int v) {
			System.out.println("process KeyC...");
			if (v >= 201 && v <= 250) {
				key = Key.C;
				return true;
			}
			return false;
		}

	}

	static class KeyD extends Keys implements IKey {

		public KeyD() {
		}

		public KeyD(Test3.IKey k) {
			super(k);
		}

		@Override
		public boolean process(int v) {
			System.out.println("process KeyD...");
			if (v >= 251) {
				key = Key.D;
				return true;
			}
			return false;
		}

	}

}
