package javapractice;

enum IamOutside{TREE, PLANT, CAR, SKY}
public class OO2EnumOutSideClassInSameFile {
	enum IamEnum{BIPIN, GULIA, AASHVI, AAVISH};
	public static void main(String[] args) {
		System.out.println("OO2EnumInClass.main(): " + IamEnum.AASHVI);
		System.out.println("OO2EnumInClass.main(): " + IamOutside.CAR);
	}
}
