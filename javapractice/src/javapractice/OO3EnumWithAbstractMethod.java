package javapractice;

public enum OO3EnumWithAbstractMethod {

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
		System.out.println("OO3EnumAbstractMethod.main(): " + OO3EnumWithAbstractMethod.INDIA.getCurrency());

	}

}
