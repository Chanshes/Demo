package unit7;
//例7-4 数组类型为对象的应用实例。
class Worker{
	private int workNum;
	private  double salary;
	public Worker(int workNum,double salary){
		this.workNum = workNum;
		this.salary = salary;
	}
	public int getWorkNum(){
		return workNum;
	}
	public double getSalary(){
		return salary;
	}
	public void setSalary(double salary){
		this.salary = salary;;
	}
}
public class WorkerApp{
	public static void main(String[] args){
		Worker[] worker = new Worker [8];
		for(int i = 0; i<worker.length;i++){
			worker[i] = new Worker(i+100,2000.00);
		}
		worker[1].setSalary(5000);
		worker[7].setSalary(1000);
		for(int i = 0;i<worker.length;i++){
			System.out.println("职工"+worker[i].getWorkNum()+"的工资为:"+worker[i].getSalary()+"元");
		}
	}
}