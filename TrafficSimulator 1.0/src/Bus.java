
public class Bus extends Car {
	public Bus(int id,float length,float speed,Road road) {
		super(length,speed,road);
		setName("bus_"+id);
	}
}
