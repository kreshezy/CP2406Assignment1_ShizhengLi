
public class Sedan extends Car {
	public Sedan(int id,float length,float speed,Road road) {
		super(length,speed,road);
		setName("sedan_"+id);
	}
}
