package unit5;
//1.
class Vehicles{
	String name, color, seats;
	public Vehicles(String name, String color, String seats){
		this.name = name;
		this.color = color;
		this.seats = seats;
	}
	public void showMessages(){
		System.out.println(name);
		System.out.println(color);
		System.out.println(seats);
	}
}
public class car extends Vehicles{
	public car(String name, String color, String seats) {
		super(name, color, seats);
	}
	public void textcar(){
		System.out.println("≤‚ ‘÷–...");
	}
	public static void main(String[] args){
		car a = new car("yuncar", "white", "4");
		a.showMessages();
	}
}