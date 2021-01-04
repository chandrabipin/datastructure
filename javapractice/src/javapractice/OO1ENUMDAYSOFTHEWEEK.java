package javapractice;

public enum OO1ENUMDAYSOFTHEWEEK {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
	
	//Main method inside enum
	public static void main(String[] args) {
		OO1ENUMDAYSOFTHEWEEK a = OO1ENUMDAYSOFTHEWEEK.SUNDAY;
		System.out.println("OO1ENUMDAYSOFTHEWEEK.main(): " + a);
		
		//Loop through an enum using enum.value()
		for(OO1ENUMDAYSOFTHEWEEK day : OO1ENUMDAYSOFTHEWEEK.values()) {
			System.out.println("OO1ENUMDAYSOFTHEWEEK.main(): " + day);
		}
		
		//testing valueOf(String)
		System.out.println("OO1ENUMDAYSOFTHEWEEK.main(): " + valueOf("TUESDAY"));
		
		//testing ordinal() // order of teh enum 
		System.out.println("OO1ENUMDAYSOFTHEWEEK.main(): " + OO1ENUMDAYSOFTHEWEEK.FRIDAY.ordinal());
		
	}

}
