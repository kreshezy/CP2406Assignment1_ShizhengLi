
public class RoadSegment {
	private String name;
	private float length;
	private float speedLimit;
	
	RoadSegment(int id,float length,float speedLimit){
		setName("road_segment_"+id);
		setLength(length);
		setSpeedLimit(speedLimit);
	}
	
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}
	public float getSpeedLimit() {
		return speedLimit;
	}
	public void setSpeedLimit(float speedLimit) {
		this.speedLimit = speedLimit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
