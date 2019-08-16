package Student;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class class2 {
	// 创建一个容器来存放学生
	static List<Class1> student1 = new ArrayList<Class1>();
	//static Class1[] student1 = {};
	// 删除后的新数组
	static Class1[] deletedstudent1;
	
	public static void main(String[] args) {
		welcome();
	}
	public static void welcome() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("------------欢迎登录学生信息管理系统------------");
		System.out.print("1.登录      ");
		System.out.println("2.退出");
		System.out.println("------------------------------------");
		System.out.println("请选择");
		int nextInt = scanner.nextInt();
		switch(nextInt) {
		case 1:
			// 执行登录
			register();
			break;
		case 2:
			// 执行退出
			exit();
			break;
		default:
			System.out.println("输入有误，请重新输入");
			welcome();
			break;
		}
	}
	// 创建登录学生信息管理系统的方法
	public static void register() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String name = scanner.next();
		System.out.println("请输入密码：");
		String password = scanner.next();
		System.out.println("登陆成功！！");
		System.out.println("欢迎您，" + name);
		operation();
      }
	
	
    public static void exit() {
		System.exit(0);
	}
    //登陆后选择进行增删改查
    public static void operation() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("******************请选择要操作的信息对应数字********************");
    	System.out.print("*");
    	System.out.print("1.查看学生信息      ");
    	System.out.print("2.添加学生信息      ");
    	System.out.print("3.删除学生信息      ");
    	System.out.print("4.修改学生信息      ");
    	System.out.print("5.退出        ");
    	System.out.println("*");
    	int nextInt = scanner.nextInt();
    	switch(nextInt) {
    	case 1:
    		look("张三");            // 查看
    		break;
    	case 2:
    		add();                  // 添加
    		break;
    	case 3:
    		delete();               // 删除
    		break;
    	case 4:
    		modification();         //修改
    		break;
    	case 5:
    		break;
    	default:
    		System.out.println("输入有误，请重新输入");
    		operation();
    		break;
    	}
    }
    
    // 查看学生信息
    public static void look(String name) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("请输入要查询的姓名：");
    	String name1 = scanner.next();
    	for(int i=0; i<student1.size();i++) {
    		if(student1.get(i).name.equals(name1)) {
    			System.out.println(student1.get(i).toString());
    		}
    	}
    	operation();
    }

    
    // 添加学生信息
    public static void add() {
    	Scanner scanner = new Scanner(System.in);
        System.out.println("**********************添加学生*******************************");
        System.out.println("请输入学生姓名：");
        String name = scanner.next();
        System.out.println("请输入学生id：");
        int id = scanner.nextInt();
        System.out.println("请输入学生性别：");
        char sex = scanner.next().charAt(0);
        System.out.println("请输入学生年龄：");
        int age = scanner.nextInt();
        System.out.println("请输入学生所属年级：");
        String class0 = scanner.next();
        System.out.println("请输入学生地址：");
        String address = scanner.next();
        System.out.println("请输入学生联系方式：");
        String phoneNum = scanner.next();
        System.out.println("请输入学生电子邮箱：");
        String email = scanner.next();
		// 构建学生
		Class1 stu = new Class1();
		stu.name = name;
		stu.id = id;
		stu.address = address;
		stu.sex = sex;
		stu.age =age;
		stu.class0 = class0;
		stu.address = address;
		stu.phoneNum = phoneNum;
		stu.email = email;
		// 学生数容器长度+1
	    student1.add(stu);
		//判断是否为空
		System.out.println(student1.get(0));
		if(student1 !=null) {
			System.out.println("数据保存成功");
		}
		operation();

    }
    
    
    // 删除学生信息
    public static void delete() {
    	if((student1.size()-1)>=0){
    	    int index =student1.size()-1;
    	    deletedstudent1 = new Class1[student1.size()-1];
    	}
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("请输入要删除的学生姓名");
    	String name = scanner.next();
    	for(int i = 0;i<student1.size();i++) {
    		if(student1.get(i).name.equals(name)) {
    			student1.remove(name);
    			//student1[i]=student1[student1.size()-1];
    		   // student1 = Arrays.copyOf(student1, student1.si-1);
    		}
    	}
    	System.out.println("删除后的信息："+Arrays.toString(deletedstudent1));
    	operation();
    }
    
    
    //修改学生信息
    public static void modification() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("-----------------------------------------------------------");
    	System.out.print("1.根据ID修改学生的全部信息      ");
    	System.out.print("2.根据ID修改学生的部分信息      ");
    	System.out.print("3.返回上级目录      ");
    	System.out.print("4.系统退出      ");
    	System.out.println("-----------------------------------------------------------");
    	System.out.println("请选择：");
    	int nextInt = scanner.nextInt();
    	switch (nextInt) {
		case 1:
			allInformation();          //修改全部信息
			break;
		case 2:
			partialInformation();      //修改部分信息
			break;
		case 3:
			returnUpOneLevel();
			break;
		case 4:
			dropOut();
			break;
		default:
			System.out.println("输入有误，请重新输入");
			break;
		}
    }
    
    
    //退出
    public static void exit2() {
    	System.exit(0);
    }
    
    // 根据ID修改学生的全部信息 
    public static void allInformation() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("请输入要修改的学生id:");
        int id = scanner.nextInt();
        System.out.println("请输入要修改的年龄:");
        int age = scanner.nextInt();
        System.out.println("请输入要修改的性别:");
        char sex = scanner.next().charAt(0);
        System.out.println("请输入要修改的班级:");
        String class0 = scanner.next();
        System.out.println("请输入要修改的地址:");
        String address = scanner.next();
        System.out.println("请输入要修改的电话号码:");
        String phoneNum = scanner.next();
        System.out.println("请输入要修改的电子邮箱:");
        String email = scanner.next();
        for(int i=0;i<student1.size();i++){
    		if(student1.get(i).id == id ) {
    			// 做修改
    			student1.get(i).age = age;
    			student1.get(i).sex = sex;
    			student1.get(i).class0 = class0;
    			student1.get(i).address = address;
    			student1.get(i).phoneNum = phoneNum;
    			student1.get(i).email = email;
    			System.out.println("修改成功！");
    			System.out.println("修改后的信息："+ student1.size());
    		}
    		
    	}
        modification();
   
    }
    
    // 根据ID修改学生的部分信息
    public static void partialInformation() {
     	Scanner scanner = new Scanner(System.in);
    	System.out.println("请输入要修改的学生id:");
        int id = scanner.nextInt();
        System.out.println("请输入要修改的年龄:");
        int age = scanner.nextInt();
        for(int i=0;i<student1.size();i++){
    		if(student1.get(i).id == id) {
    			// 做修改
    			student1.get(i).age = age;
    			System.out.println("修改成功！");
    			System.out.println("修改后的信息："+ student1.size());
    		}
    		
    	}
        modification();
    }
    
    // 返回上级目录 
    public static void returnUpOneLevel() {
    	operation();
    }
    
    // 系统退出
    public static void dropOut() {
    	System.exit(0);
    }
}


