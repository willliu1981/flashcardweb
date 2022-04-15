package test1;

public class Test3 {

	public static void main(String[] args) {
		int C = 2, CC = 0;

		CC = (C++) + (++C);

		System.out.println("CC=" + CC);

		ObjectI ObjI1 = new ObjectI(2);

		System.out.println("ObjI1 do IPlus=" + IPlus(ObjI1).i);
		System.out.println("ObjI1=" + ObjI1.i);

		ObjectI ObjI2 = new ObjectI(2);

		System.out.println("ObjI2 do PlusI=" + PlusI(ObjI2).i);
		System.out.println("ObjI2=" + ObjI2.i);

		ObjectI ObjI3 = new ObjectI(2);
		int II = 0;
		II = PlusI(ObjI3).i + IPlus(ObjI3).i;
		System.out.println("II=" + II);
		
		Integer x=2;
		System.out.println("x=" + mplus(x));
		System.out.println("x=" + x);

	}

	static class ObjectI {
		int i;

		ObjectI(int i) {
			this.i = i;
		}
	}

	public static ObjectI IPlus(ObjectI objI) {
		ObjectI newI = new ObjectI(objI.i);
		objI.i = objI.i + 1;

		return newI;
	}

	public static ObjectI PlusI(ObjectI objI) {
		ObjectI newI = new ObjectI(objI.i);
		objI.i = objI.i + 1;

		newI.i = newI.i + 1;
		return newI;
	}

	public static  int mplus(Integer i) {
		int temp = i;
		i = i + 1;
		return temp;
	}

}
