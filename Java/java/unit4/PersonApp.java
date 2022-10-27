package unit4;
//��4-15 ˽�����ʹ��
class Person{
	private String name;  //����
	private int sex;      //�Ա�
	private int age;      //����
	
	public Person(String name, String sex, int age){
		this.name = name;
		this.age = age;
		setSex(sex);
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	public String getSex(){
		if (sex == 0)
			return "��";
		else
			return "Ů";
	}
	public void setSex(String sex){
		if(sex.equals("��"))
			this.sex = 0;
		else if(sex.equals("Ů"))
			this.sex = 1;
	}
}

public class PersonApp {
	public static void main(String[] args){
		Person p = new Person("luise","��",18);
		//System.out.println("����Ϊ: "+p.name);//����
		//ֱ��ͨ��p.name��ȡ����p��˽����name��ֵ ����ֱ�ӷ���
		System.out.println("����Ϊ��"+p.getName());
		p.setAge(20);
	}
}
