
public class TrafficLight {
	public static final int RED=0;
	public static final int GREEN=1;
	
	private String name;
	private int color;
	private int redTime;
	private int greenTime;
	
	private int redTimeRemain;
	private int greenTimeRemain;
	
	public TrafficLight(int id,int color,int redTime,int greenTime) {
		setName("traffic_light_"+id);
		setColor(color);
		setRedTime(redTime);
		setGreenTime(greenTime);
	}
	
	public int getNextSecColor() {
		if(color==RED) {
			if(redTimeRemain==1) {
				return GREEN;
			}else {
				return RED;
			}
		}else {
			if(greenTimeRemain==1) {
				return RED;
			}else {
				return GREEN;
			}
		}
	}
	
	public void update() {
		if(color==RED) {
			redTimeRemain--;
			if(redTimeRemain<=0) {
				redTimeRemain=redTime;
				color=GREEN;
			}
		}else {
			greenTimeRemain--;
			if(greenTimeRemain<=0) {
				greenTimeRemain=greenTime;
				color=RED;
			}
		}
	}
	
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public int getRedTime() {
		return redTime;
	}
	public void setRedTime(int redTime) {
		this.redTime = redTime;
	}
	public int getGreenTime() {
		return greenTime;
	}
	public void setGreenTime(int greenTime) {
		this.greenTime = greenTime;
	}

	public int getRedTimeRemain() {
		return redTimeRemain;
	}

	public void setRedTimeRemain(int redTimeRemain) {
		this.redTimeRemain = redTimeRemain;
	}

	public int getGreenTimeRemain() {
		return greenTimeRemain;
	}

	public void setGreenTimeRemain(int greenTimeRemain) {
		this.greenTimeRemain = greenTimeRemain;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
