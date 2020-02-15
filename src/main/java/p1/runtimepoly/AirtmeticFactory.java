package p1.runtimepoly;

public class  AirtmeticFactory	{
	
	static Airthmetic ob[];
     static {
	ob= new Airthmetic[5];
	ob[0] =(x, y)->(x+y);
	ob[1] = (x, y)->(x-y);
	ob[2] = (x, y)->(x*y);
	ob[3] = (x, y)->(x/y);
	ob[4] = (x, y)->(x*(y/100));
	}
	
	public static Airthmetic getFactory(int n) {
		return ob[n];
	}

}
