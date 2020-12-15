import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static Scanner sc=new Scanner(System.in);
	public static Random rand=new Random(8636);
	
	public static void test(Road road,List<Car> cars) {
		int carNum=cars.size();
		int finishedCarNum=0;
		while(finishedCarNum<carNum) {
			int size=cars.size();
			int counter=0;
			int idx=0;
			road.update();
			while(counter<size) {
				counter++;
				Car car=cars.get(idx);
				if(car.update()) {
					cars.remove(idx);
					finishedCarNum++;
				}else {
					idx++;
				}
			}
		}
		System.out.println("Simulation finished.");
	}
	
	public static void testAuto() {
		Road road=new Road();
		road.AddPart(new RoadSegment(0, 1.3f, 40.0f));
		road.AddPart(new TrafficLight(0, TrafficLight.GREEN, 20, 35));
		road.AddPart(new RoadSegment(1, 0.8f, 30.0f));
		int carNum=rand.nextInt(60);
	 	LinkedList<Car> cars=new LinkedList<Car>();
		for(int i=0;i<carNum;i++) {
			if(rand.nextBoolean()) {
				cars.add(new Sedan(i,rand.nextFloat()+1.0f,rand.nextInt(35)+10.0f,road));
			}else {
				cars.add(new Bus(i,rand.nextFloat()+4.0f,rand.nextInt(22)+10.0f,road));
			}
		}
		test(road,cars);
	}
	
	public static void main(String[] args) {
		testAuto();
	}
}
