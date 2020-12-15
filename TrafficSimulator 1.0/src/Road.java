import java.util.ArrayList;

public class Road {
	ArrayList<Object> parts=new ArrayList<Object>();
	ArrayList<TrafficLight> trafficLights=new ArrayList<TrafficLight>();
	
	public void update() {
		for(TrafficLight e:trafficLights) {
			e.update();
		}
	}
	
	public Object get(int idx) {
		if(idx<0||idx>=parts.size()) {
			return null;
		}
		return parts.get(idx);
	}
	
	public void AddPart(Object part) {
		parts.add(part);
		if(TrafficLight.class.getName().equals(part.getClass().getName())) {
			trafficLights.add((TrafficLight) part);
		}
	}
}
