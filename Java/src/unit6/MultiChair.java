package unit6;
//例6-21 集多种功能的音乐按摩椅的实现。
//实现类接口功能的椅子类
public class MultiChair extends Chair implements Music,Massage,Video{
	int sitMinute;
	public MultiChair(int time){
		sitMinute = time;
	}
	public void sit(){
		System.out.println("在椅子上休息"+sitMinute+"分钟！");
	}
	public void listenMusic(){
		System.out.println("让我们坐在椅子上听会音乐吧！");
	}
	public void getMassage(){
		System.out.println("让我们享受椅子的自动按摩服务吧！");
	}
	public void watchVideo(){
		System.out.println("让我们坐在椅子上看会儿影碟吧");
	}
}
