package view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import controller.Myworking;
import model.Dept;
import model.Student;
import model.Teacher;

public class College {

	String panel;
	Scanner inputKeyword;
	Student student;
	Dept dept;
	Teacher teacher;
	int choice;
	char innerProcess;
	int loadpanel=0;
	
	public College() {
		// TODO Auto-generated constructor stub
		System.out.println("Welcome My College Application");
		
		inputKeyword=new Scanner(System.in);
		
		
	}
	public void verifyPanel()
	{
		do {
					System.out.println("Department");
					System.out.println("Teacher");
					System.out.println("Student");
					System.out.print("Enter your Panel Name :- ");
					panel=inputKeyword.next();
					
					switch (panel) 
					{
					case "Department":
					case "department":
								dept=new Dept();
								do {	
											System.out.println("Press 1 for Add Department");
											System.out.println("Press 2 for View Department");
											System.out.println("Press 3 for Delete Department");
											System.out.println("Press 4 for Update Department Head");
											System.out.println("Press 5 for Add Teacher Profile");
											System.out.println("Press 6 for Logout From Department");
											System.out.println("Enter your Choice");
											choice=inputKeyword.nextInt();
										
											switch(choice)
											{
												case 1:
													
													System.out.print("Enter Department Id ");
													dept.setDeptId(inputKeyword.next());
													System.out.print("Enter Department Name ");
													dept.setDeptName(inputKeyword.next());
													System.out.print("Enter Department Head Name ");
													dept.setDeptHead(inputKeyword.next());
													boolean status=Myworking.storeDept(dept);
													if(status)
													{
														System.out.println("Data Store in Department Table");
													}
													break;
												case 2:
													ResultSet rst=Myworking.viewDeptdetails("dept");
												try {
													System.out.println("Dept Id     Dept Name        Dept Head");
														while(rst.next())
														{
															System.out.print(rst.getString(1)+"     ");
															System.out.print(rst.getString(2)+"     ");
															System.out.print(rst.getString(3));
															System.out.println();
														}
												} catch (SQLException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
													break;
												case 3:
													System.out.print("Enter Department Id  that you want to delete ");
													dept.setDeptId(inputKeyword.next());
													boolean statusDel=Myworking.deleteData(dept,"dept");
													if(statusDel)
													{
														System.out.println("Data Deleted");
													}
													else
													{
														System.out.println("Data not Deleted");
													}
													break;
												case 4:
													System.out.print("Enter Department Id  that you want to update ");
													dept.setDeptId(inputKeyword.next());
													boolean statusUp=Myworking.updateDatadept(dept,"dept",inputKeyword);
													if(statusUp)
													{
														System.out.println("Data Update");
													}
													else
													{
														System.out.println("Data not Update");
													}
													break;
												case 5:
													teacher=new Teacher();
													System.out.print("Enter Teacher Id ");
													teacher.setTeachId(inputKeyword.next());
													System.out.print("Enter Teacher Name ");
													teacher.setTeachname(inputKeyword.next());
													System.out.print("Enter Teacher Email Id ");
													teacher.setTeachEmail(inputKeyword.next());
													System.out.print("Enter Teacher Email Password ");
													teacher.setTeachPassword(inputKeyword.next());
											
													
													
													break;
												
												
											}
											if(!(choice==6))
											{
												System.out.println("Do you want to continue the process press Y other wise press any key ");
												innerProcess=inputKeyword.next().charAt(0);
												
											}
											else {
												innerProcess='N';
												loadpanel=1;
												System.out.println("Your Department panel is logged out");
											}
											
								       }while(innerProcess=='y'||innerProcess=='Y');
									if(!(innerProcess=='y'||innerProcess=='Y'))
									{
										loadpanel=1;
									}
								
								
						break;
					case "Teacher":
					case "teacher":
								System.out.println("Press 1 for Add Profile");
								System.out.println("Press 2 for View Profile");
								System.out.println("Press 3 for Delete Department");
								System.out.println("Press 4 for Update Department");
								System.out.println("Press 5 for Logout From Department");
								System.out.println("Enter your Choice");
								choice=inputKeyword.nextInt();
								teacher=new Teacher();
								System.out.print("Enter Teacher Id");
						break;
					case "Student":
					case "student":
								System.out.println("Press 1 for Add Department");
								System.out.println("Press 2 for View Department");
								System.out.println("Press 3 for Delete Department");
								System.out.println("Press 4 for Update Department");
								System.out.println("Press 5 for Logout From Department");
								System.out.println("Enter your Choice");
								choice=inputKeyword.nextInt();
								student=new Student();
								System.out.print("Enter Student Id");
						break;
			
					default:
							System.out.println("Invalid Panel");
						break;
					}
		}while(loadpanel==1);		
	}
	public static void main(String[] args) {
		College college=new College();
		college.verifyPanel();
	}
}
