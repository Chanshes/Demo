package unit4;
//例4-6构造方法的重载
class Human {
//域定义
	String name;
	char sex;
	int age;
	//构造方法定义
	Human(String n){
		name = n;
	}
	Human(String n, char s){
		name = n;
		sex = s;
	}
	Human(String n, char s, int a){
		name = n;
		sex = s;
		age = a;
	}
	public static void main(String args[]){
		Human human1 = new Human("Liuis");
		Human human2 = new Human("Marry", '女');
		Human human3 = new Human("Henry", '男', 20);
		System.out.println("      姓名     "+"   性别    "+" 年龄   ");
		System.out.printf("%8s, %4c, %4d",human1.name,human1.sex,human1.age);
		System.out.println();
		System.out.printf("%8s, %4c, %4d",human2.name,human2.sex,human2.age);
		System.out.println();
		System.out.printf("%8s, %4c, %4d",human3.name,human3.sex,human3.age);
	}
}
