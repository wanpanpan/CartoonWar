package Student;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class class2 {
	// ����һ�����������ѧ��
	static List<Class1> student1 = new ArrayList<Class1>();
	//static Class1[] student1 = {};
	// ɾ�����������
	static Class1[] deletedstudent1;
	
	public static void main(String[] args) {
		welcome();
	}
	public static void welcome() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("------------��ӭ��¼ѧ����Ϣ����ϵͳ------------");
		System.out.print("1.��¼      ");
		System.out.println("2.�˳�");
		System.out.println("------------------------------------");
		System.out.println("��ѡ��");
		int nextInt = scanner.nextInt();
		switch(nextInt) {
		case 1:
			// ִ�е�¼
			register();
			break;
		case 2:
			// ִ���˳�
			exit();
			break;
		default:
			System.out.println("������������������");
			welcome();
			break;
		}
	}
	// ������¼ѧ����Ϣ����ϵͳ�ķ���
	public static void register() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("�������û�����");
		String name = scanner.next();
		System.out.println("���������룺");
		String password = scanner.next();
		System.out.println("��½�ɹ�����");
		System.out.println("��ӭ����" + name);
		operation();
      }
	
	
    public static void exit() {
		System.exit(0);
	}
    //��½��ѡ�������ɾ�Ĳ�
    public static void operation() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("******************��ѡ��Ҫ��������Ϣ��Ӧ����********************");
    	System.out.print("*");
    	System.out.print("1.�鿴ѧ����Ϣ      ");
    	System.out.print("2.���ѧ����Ϣ      ");
    	System.out.print("3.ɾ��ѧ����Ϣ      ");
    	System.out.print("4.�޸�ѧ����Ϣ      ");
    	System.out.print("5.�˳�        ");
    	System.out.println("*");
    	int nextInt = scanner.nextInt();
    	switch(nextInt) {
    	case 1:
    		look("����");            // �鿴
    		break;
    	case 2:
    		add();                  // ���
    		break;
    	case 3:
    		delete();               // ɾ��
    		break;
    	case 4:
    		modification();         //�޸�
    		break;
    	case 5:
    		break;
    	default:
    		System.out.println("������������������");
    		operation();
    		break;
    	}
    }
    
    // �鿴ѧ����Ϣ
    public static void look(String name) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("������Ҫ��ѯ��������");
    	String name1 = scanner.next();
    	for(int i=0; i<student1.size();i++) {
    		if(student1.get(i).name.equals(name1)) {
    			System.out.println(student1.get(i).toString());
    		}
    	}
    	operation();
    }

    
    // ���ѧ����Ϣ
    public static void add() {
    	Scanner scanner = new Scanner(System.in);
        System.out.println("**********************���ѧ��*******************************");
        System.out.println("������ѧ��������");
        String name = scanner.next();
        System.out.println("������ѧ��id��");
        int id = scanner.nextInt();
        System.out.println("������ѧ���Ա�");
        char sex = scanner.next().charAt(0);
        System.out.println("������ѧ�����䣺");
        int age = scanner.nextInt();
        System.out.println("������ѧ�������꼶��");
        String class0 = scanner.next();
        System.out.println("������ѧ����ַ��");
        String address = scanner.next();
        System.out.println("������ѧ����ϵ��ʽ��");
        String phoneNum = scanner.next();
        System.out.println("������ѧ���������䣺");
        String email = scanner.next();
		// ����ѧ��
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
		// ѧ������������+1
	    student1.add(stu);
		//�ж��Ƿ�Ϊ��
		System.out.println(student1.get(0));
		if(student1 !=null) {
			System.out.println("���ݱ���ɹ�");
		}
		operation();

    }
    
    
    // ɾ��ѧ����Ϣ
    public static void delete() {
    	if((student1.size()-1)>=0){
    	    int index =student1.size()-1;
    	    deletedstudent1 = new Class1[student1.size()-1];
    	}
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("������Ҫɾ����ѧ������");
    	String name = scanner.next();
    	for(int i = 0;i<student1.size();i++) {
    		if(student1.get(i).name.equals(name)) {
    			student1.remove(name);
    			//student1[i]=student1[student1.size()-1];
    		   // student1 = Arrays.copyOf(student1, student1.si-1);
    		}
    	}
    	System.out.println("ɾ�������Ϣ��"+Arrays.toString(deletedstudent1));
    	operation();
    }
    
    
    //�޸�ѧ����Ϣ
    public static void modification() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("-----------------------------------------------------------");
    	System.out.print("1.����ID�޸�ѧ����ȫ����Ϣ      ");
    	System.out.print("2.����ID�޸�ѧ���Ĳ�����Ϣ      ");
    	System.out.print("3.�����ϼ�Ŀ¼      ");
    	System.out.print("4.ϵͳ�˳�      ");
    	System.out.println("-----------------------------------------------------------");
    	System.out.println("��ѡ��");
    	int nextInt = scanner.nextInt();
    	switch (nextInt) {
		case 1:
			allInformation();          //�޸�ȫ����Ϣ
			break;
		case 2:
			partialInformation();      //�޸Ĳ�����Ϣ
			break;
		case 3:
			returnUpOneLevel();
			break;
		case 4:
			dropOut();
			break;
		default:
			System.out.println("������������������");
			break;
		}
    }
    
    
    //�˳�
    public static void exit2() {
    	System.exit(0);
    }
    
    // ����ID�޸�ѧ����ȫ����Ϣ 
    public static void allInformation() {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("������Ҫ�޸ĵ�ѧ��id:");
        int id = scanner.nextInt();
        System.out.println("������Ҫ�޸ĵ�����:");
        int age = scanner.nextInt();
        System.out.println("������Ҫ�޸ĵ��Ա�:");
        char sex = scanner.next().charAt(0);
        System.out.println("������Ҫ�޸ĵİ༶:");
        String class0 = scanner.next();
        System.out.println("������Ҫ�޸ĵĵ�ַ:");
        String address = scanner.next();
        System.out.println("������Ҫ�޸ĵĵ绰����:");
        String phoneNum = scanner.next();
        System.out.println("������Ҫ�޸ĵĵ�������:");
        String email = scanner.next();
        for(int i=0;i<student1.size();i++){
    		if(student1.get(i).id == id ) {
    			// ���޸�
    			student1.get(i).age = age;
    			student1.get(i).sex = sex;
    			student1.get(i).class0 = class0;
    			student1.get(i).address = address;
    			student1.get(i).phoneNum = phoneNum;
    			student1.get(i).email = email;
    			System.out.println("�޸ĳɹ���");
    			System.out.println("�޸ĺ����Ϣ��"+ student1.size());
    		}
    		
    	}
        modification();
   
    }
    
    // ����ID�޸�ѧ���Ĳ�����Ϣ
    public static void partialInformation() {
     	Scanner scanner = new Scanner(System.in);
    	System.out.println("������Ҫ�޸ĵ�ѧ��id:");
        int id = scanner.nextInt();
        System.out.println("������Ҫ�޸ĵ�����:");
        int age = scanner.nextInt();
        for(int i=0;i<student1.size();i++){
    		if(student1.get(i).id == id) {
    			// ���޸�
    			student1.get(i).age = age;
    			System.out.println("�޸ĳɹ���");
    			System.out.println("�޸ĺ����Ϣ��"+ student1.size());
    		}
    		
    	}
        modification();
    }
    
    // �����ϼ�Ŀ¼ 
    public static void returnUpOneLevel() {
    	operation();
    }
    
    // ϵͳ�˳�
    public static void dropOut() {
    	System.exit(0);
    }
}


