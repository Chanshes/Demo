package customize;

import java.io.Serializable;

public class Course implements Serializable{
	/**
	 * Serializable ：Java 序列化技术可以使你将一个对象的状态写入一个Byte 流里（系列化），
	 * 并且可以从其它地方把该Byte 流里的数据读出来（反序列化）
	 * https://blog.csdn.net/u011568312/article/details/57611440
	 * 序列化使用方法
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String name;
	
	private String term;
	
	private String Chinese;
	
	private String Math;
	
	private String English;
	
	private String IoT;
	
	private String Mhe;
	
	private String Java;
	
	public Course(){
		super();
	}
	public Course(String id, String name, String term, String Chinese, String Math, 
			String English, String IoT, String Mhe, String Java){
		super();
		this.id = id;
		this.name = name;
		this.term = term;
		this.Chinese = Chinese;
		this.Math = Math;
		this.English = English;
		this.IoT = IoT;
		this.Mhe = Mhe;
		this.Java = Java;
	}
	
	@Override
	public String toString(){
		return "Course [id="+ id +", name=" + name + ", term" + term + ", Chinese=" + Chinese +
				", Math=" + Math + ", English=" + English + "IoT=" + IoT +
				", Mhe=" + Mhe + ", Java=" + Java +"]";
	}
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getTerm(){
		return term;
	}
	
	public void setTerm(String term){
		this.term = term;
	}
	
	public String getChinese(){
		return Chinese;
	}
	
	public void setChinese(String Chinese){
		this.Chinese = Chinese;
	}
	
	public String getMath(){
		return Math;
	}
	
	public void setMath(String Math){
		this.Math = Math;
	}
	
	public String getEnglish(){
		return English;
	}
	
	public void setEnglish(String English){
		this.English = English;
	}
	
	public String getIoT(){
		return IoT;
	}
	
	public void setIoT(String IoT){
		this.IoT = IoT;
	}
	
	public String getMhe(){
		return Mhe;
	}
	
	public void setMhe(String Mhe){
		this.Mhe = Mhe;
	}
	
	public String getJava(){
		return Java;
	}
	
	public void setJava(String Java){
		this.Java = Java;
	}
}
