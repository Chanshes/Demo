package unit7;
//��7-4 ��������Ϊ�����Ӧ��ʵ����
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
			System.out.println("ְ��"+worker[i].getWorkNum()+"�Ĺ���Ϊ:"+worker[i].getSalary()+"Ԫ");
		}
	}
}