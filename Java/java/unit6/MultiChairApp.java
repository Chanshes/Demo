package unit6;
//例6-22 多功能按摩椅的应用。
public class MultiChairApp {
	public static void main(String[] args){
		MultiChair mc = new MultiChair(30);
		mc.sit();
		mc.listenMusic();
		mc.getMassage();
		mc.watchVideo();
	}
}