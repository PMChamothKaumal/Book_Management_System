import java.util.Scanner;
import java.util.Arrays; 

public class Assignment{
	public static Books book[] = new Books[10];
	public static void main(String args[]){
		LoginPage();
		}
	
	public static void ThemePart(String Theme){
		System.out.print("\t\t\t\t+");
		for(int i=0; i<87; i++){
			System.out.print("-");
			}
		System.out.println("+");
		System.out.print("\t\t\t\t|\t\t"+Theme);
		System.out.println("");
		System.out.print("\t\t\t\t+");
		for(int i=0; i<87; i++){
			System.out.print("-");
			}
		System.out.println("+");
		}
		
	public static void Validate(String type){
		Scanner input2 = new Scanner(System.in);
		boolean check = true;
		while(check){
					System.out.print("Do you want to "+type);
                    String answer = input2.next();
                    if((answer.toUpperCase()).equals("Y")){
						System.out.println("\n*****************************************************************\n");
						check = false;
						}
					else if((answer.toUpperCase()).equals("N")){
						int i=9;
						clearConsole();
						HomePage();
						check = false;
						}
					else{
						System.out.println("Invaid input please Try Again..!");
						
						}
					}
		}
		
		private final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.equals("Linux")) {
                System.out.print("\033\143");
            } else if (os.equals("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
			
            System.err.println(e.getMessage());
        }
    }
		
		
		
	public static void LoginPage(){
		boolean controller = true;
		String UserName = "chamoth@";
		String PassWord = "ch2002";
		
		Scanner input = new Scanner(System.in);
		ThemePart("\t\t\tLOGIN PAGE\t\t\t\t        |");	
		
		while(controller){
		System.out.print("\nEnter your Username: ");
		String username = input.next();
		System.out.print("Enter your Password: ");
		String password = input.next();
		
		if(UserName.equals(username)){
			if(PassWord.equals(password)){
				controller = false;
				clearConsole();
				HomePage();
				}
				else{
					System.out.println("Wrong Password..! Try again...");
					}
			}
			else if(PassWord.equals(password)){
					System.out.println("Wrong Username..! Try again...");
					}
					else{
						System.out.println("Wrong Username and Password..! Try again...");
						}
			}
		}
		
	public static void HomePage(){
			Scanner input1 = new Scanner(System.in);
			ThemePart("WELCOME TO SHI BOOK SHOP MANAGEMENT SYSTEM\t\t\t        |");
			System.out.println();
			String data[] = {"Add Book", "Delete Book", "Update Book", "Show All Book", "Log out", "Exit the system"};
			for(int i=0; i<data.length; i++){
				if(i%2==0){
				System.out.print("\t\t\t["+(i+1)+"] "+data[i]);
				System.out.println("\t\t\t\t\t["+(i+2)+"] "+data[i+1]);
					}
				}
				boolean hand = true;
		while(hand){
				hand = false;
			System.out.print("\n\t\t\tENTER AN OPTION TO CONTINUE: ");
			String option = input1.next();
			
			
			if(option.equals("1")){
				clearConsole();
					Addpage();
				}
				else if(option.equals("2")){	
					clearConsole();
					delete();
				}
				else if(option.equals("3")){
					clearConsole();
					Update();
				}
				else if(option.equals("4")){
					clearConsole();
					Show();
				}
				else if(option.equals("5")){
					clearConsole();
					LogOut();
				}
				else if(option.equals("6")){
					System.exit(0);
					break;
					}
				else{
					System.out.println("\t\t\tInvalid input try again..!\n");
					hand = true;					
						}
					}
					
				
			}
			
	public static void Addpage(){
		ThemePart("\t\t\tADD BOOK\t\t\t\t        |");
		Scanner input2 = new Scanner(System.in);
		
		boolean handler = true;
		
		for(int i=0; i<book.length; i++){
			
			book[i] = new Books();
			System.out.print("Book ID: ");
			book[i].ID = input2.next();
			
			boolean count = false;
            for (int j = 0; j < i; j++) {
                if (book[i].ID.equals(book[j].ID)) {
                    System.out.println("alrady exist in Sotre..!");
                    Validate("Add another Book (Y/N): ");
                    count = true;
                    break;
                }
            }
            
            if (!count) {
			System.out.print("Book Name: ");
			book[i].name = input2.next();
			System.out.print("Book price: ");
			book[i].price = input2.nextInt();
			System.out.print("Book Qty: ");
			book[i].qty = input2.nextInt();
			System.out.print("Book Authors: ");
			book[i].authors = input2.next();	
		}
            

            if (!count) {
                System.out.println("Added successfully.");
                Validate("Add another Book (Y/N): ");           
            }		
			}		
		}
		
	public static void delete(){
		Scanner input3 = new Scanner(System.in);
			ThemePart("\t\t\tDELETE BOOK\t\t\t\t        |");
			System.out.println();
			boolean handler = true;
		while(handler){
			System.out.print("Book ID: ");
			String id = input3.next();
			 boolean found = false;

    for (int i = 0; i < book.length; i++) {
        if (book[i] != null && id.equals(book[i].ID)) {
            // Book found, mark as null
            book[i] = null;
            found = true;
            System.out.print("after> [");
             for (Books element : book) {
            if (element != null) {
                System.out.print(element + "");
            }
        }
        	
			System.out.print("]");
            System.out.println("\nDeleted Successfully!\n");
            Validate("delete another Book (Y/N): ");
             boolean allNull = Arrays.stream(book).allMatch(element -> element == null);

        if (allNull) {
            System.out.println("Oops Book list is empty!! ");
            boolean em = true;
            while(em){
            System.out.print("Enter num '1' to go to Book Menu page: ");
            String empty = input3.next();
            if(empty.equals("1")){
				clearConsole();
				em = false;
				HomePage();
				}
				else{
					System.out.println("Invalid Input!! Try again..");
					}
			}
        }
			break;
						          
        }
    }

    if (!found) {
        System.out.println("Can't find Book!! Try again.");
    }
		}
	}
		
	public static void Update(){
		ThemePart("\t\t\tUPDATE BOOK\t\t\t\t        |");
		System.out.println();
		Scanner input = new Scanner(System.in);
		boolean handler = true;
		while(handler){
			System.out.print("Book ID: ");
			String id = input.next();
			 boolean found = false;

    for (int i = 0; i < book.length; i++) {
        if (book[i] != null && id.equals(book[i].ID)) {
           
            System.out.println("Book name: "+book[i].name);
            System.out.println(book[i]);
            System.out.print("Enter the new book name: ");
            String bname = input.next();
            book[i].name = bname;
            found = true;
            System.out.println(book[i]);
            System.out.println("Updated Successfully!");
            Validate("update another Book (Y/N): ");
			break;			          
        }
    }

    if (!found) {
        System.out.println("Can't find Book id!! Try again.");
    }
		}
		}
		
	public static void Show(){
		ThemePart("\t\tVIEW ALL BOOK\t\t\t\t\t        |");
		System.out.println();
		System.out.print("+");
		Loop();
		
		int mark3 = 8;
		int listCount =0;
		System.out.print("\n|");
		System.out.printf(" %14s        | %16s      | %16s      | %16s      | %18s    |", "BOOK ID", "BOOK NAME", "BOOK PRICE", "BOOK QTY", "BOOK AUTHORS");
			
		System.out.print("\n+");
		Loop();
			
		for(int j=0; j<book.length; j++){
			if(book[j]!=null){
				System.out.print("\n|");
				 System.out.printf(" %14s        | %16s      | %16s      | %16s      | %18s    |",
                    book[j].ID, book[j].name, book[j].price, book[j].qty, book[j].authors);
				System.out.print("\n+");
				Loop();
				
				}
			}	
				
			System.out.println("\n");	
			boolean checks = true;
			while(checks){
			System.out.print("Do you want to go Book Mange page (Y/N): ");
			Scanner input2 = new Scanner(System.in);
			String answer = input2.next();
                    if((answer.toUpperCase()).equals("Y")){
						clearConsole();
						HomePage();
						}
					else{
						System.out.println("Invaid input please Try Again..!");
						}
					}
		}
		
		
	public static void LogOut(){
		LoginPage();
		}
		
	public static void Exit(){
		}
	
	public static void Loop(){
		int mark = 24;
		for(int i=1; i<=120; i++){
			if(i==mark){
			System.out.print("+");
			mark+=24;
		}
		else{
			System.out.print("-");
			}
			}
		}

	}
	
class Books{
	String ID;
	String name;
	int price;
	int qty;
	String authors;
	
	public String toString(){
		return("[Book{bId="+ID+", bName="+name+", price="+price+", qty="+qty+", authors="+authors+"}]");
		}
	}
