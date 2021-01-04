package javapractice;

public enum OO3EnumWithSwitchStmnt {

	US{
		public String getCurrency() {
			return "DOLLAR";
		}
	},
	INDIA{
		public String getCurrency() {
			return "RUPEES";
		}
	},
	RUSSIA{
		public String getCurrency() {
			return "RUBAL";
		}
	},
	NEPAL{
		public String getCurrency() {
			return "RUPAIYA";
		}
	};
	
	public abstract String getCurrency();	
	
	public static void main(String[] args) {
		OO3EnumWithSwitchStmnt e = OO3EnumWithSwitchStmnt.US;
		switch (e) {
		case US:
			System.out.println("OO3EnumAbstractMethod.main(): " + e.getCurrency());
			break;
		case INDIA:
			System.out.println("OO3EnumAbstractMethod.main(): " + e.getCurrency());
			break;
		case RUSSIA:
			System.out.println("OO3EnumAbstractMethod.main(): " + e.getCurrency());
			break;
		default:
			break;
		}

	}

}
