
public class Car {
	private String name;
	private float length;
	private float speed;
	private float position;
	private float nextPosition;
	private Road road;
	private int idx;
	
	public Car() {
		setLength(1.0f);
		setSpeed(30.0f);
		setRoad(null);
	}
	
	public Car(float length,float speed,Road road) {
		setLength(length);
		setSpeed(speed);
		setRoad(road);
	}
	
	public boolean update() {
		RoadSegment rs=(RoadSegment)road.get(idx);
		if(speed>rs.getSpeedLimit()) {
			speed=rs.getSpeedLimit();
		}
		nextPosition=position+speed*1/3600;
		if(nextPosition>=rs.getLength()) {
			Object part=road.get(idx+1);
			if(part==null) {
				if(nextPosition>=rs.getLength()+length*0.001) {
					System.out.println(String.format("%s passed %s and reached  destination", this.name,rs.getName()));
					return true;
				}else {
					position=nextPosition;
				}
			}else {
				if(part.getClass().getName().equals(TrafficLight.class.getName())) {
					TrafficLight tl=(TrafficLight)part;
					if(tl.getColor()==TrafficLight.RED||tl.getNextSecColor()==TrafficLight.RED) {
						System.out.println(String.format("%s stop at %s, cause %s is red", this.name,rs.getName(),tl.getName()));
					}else {
						System.out.println(String.format("%s passed %s", this.name,tl.getName()));
						position=nextPosition-rs.getLength();
						idx+=2;
					}
				}else {
					System.out.println(String.format("%s passed %s", this.name,rs.getName()));
					position=nextPosition-rs.getLength();
					idx+=1;
				}
			}
		}else {
			position=nextPosition;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getPosition() {
		return position;
	}

	public void setPosition(float position) {
		this.position = position;
	}

	public Road getRoad() {
		return road;
	}

	public void setRoad(Road road) {
		this.road = road;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}
	
}
