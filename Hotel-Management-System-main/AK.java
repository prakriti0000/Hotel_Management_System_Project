import java.util.*;
import java.io.Console;
import java.io.*;

class Customer{
        Date d1 = new Date();
        String C_Name,City,State;
        long mob;
        int no_of_person,no_of_day;
        Scanner s = new Scanner(System.in);

        void add_detail()
        {
          System.out.print("\nEnter the name of the person: - ");
          C_Name=s.next();
          System.out.print("\nEnter the Contact no of the person: - ");
          mob=s.nextLong();
          System.out.print("\nEnter the total no of person: - ");
          no_of_person=s.nextInt();
          System.out.print("\nEnter the total no of days of stay: - ");
          no_of_day=s.nextInt();
          System.out.print("\nEnter the city of the person: - ");
          City=s.next();
          System.out.print("\nEnter the State of the person: - ");
          State =s.next();
          Room r = new Room();
          try {
            File f=new File("Details.txt");
            PrintWriter p=new PrintWriter(new FileOutputStream(f,true));
            p.append("\n"+d1+"  "+C_Name+"  "+mob+"  "+City+"  "+State+"  "+no_of_day+"  "+no_of_person);
            p.close();

        } catch (Exception a) {}
          r.rent(no_of_person, no_of_day);
        }


}

class Room{
  int map[]=new int[50];
  void add_detail(){
    int i=0;
    try {
      while(i<50)
      {
        map[i]=0;
        i++;
      }
    }
    catch(Exception a){System.out.print("\nError while allocating the map");}
  }
  void check(){
    int i=0,flag=0;
    while(i<50)
    {
      if(map[i]==0){
          System.out.print("\nRoom is available");
          flag=1;
          break;
      }
      i++;
    }
    if(flag==0){
      System.out.print("\nSorry No room is available");
    }
  }
    void check(int a){
      int i=0;
        if(map[a-50]==0){
            System.out.print("\nRoom no "+a+" is available\n");
        }
        else{
        System.out.print("Sorry this room is not available\n");
        try{
        if(map[a-50+1]==0)
        {
          System.out.print("but room no "+(a+1)+" is available\n");
        }
        if(map[a-50-1]==0)
        {
          System.out.print("but room no "+(a-1)+" is available\n");
        }}catch(Exception ab){}//This Exception is for Error in  boundry condition for searchin the room
  }
    }

void rent(int p, int d){
      System.out.print("\nYou have to pay "+(1000+(200*p)+(500*d)));
}


  }

class Book extends Room{
  int book_room(){
    int i=0,flag=0;
    while(i<50)
    {
      if(map[i]==0){
          map[i]=1;
          System.out.print("\nYour booked room no is: "+(50+i));
          flag=1;
          break;
      }
      i++;
    }
    if(flag==0){
      System.out.print("\nSorry No room is available");
    }
    return flag;
  }

  int book_room(int a){
    int i=0,flag=0,rf=0;
    Scanner s= new Scanner(System.in);
      if(map[a-50]==0){
          map[a-50]=1;
          rf=1;
          System.out.print("\nYour booked room no is: "+a);
      }
      else{
      System.out.print("\nSorry this room is not available");
      if(a-50+1!=50)
      if(map[a-50+1]==0)
      {
        System.out.print("\nbut room no "+(a+1)+" is available want to book press 1");
        flag = s.nextInt();
        if(flag==1){
        map[a-50+1]=1;
        rf=1;
        System.out.print("\nYour booked room no is: "+(a+1));
        }
      }
      if(a-50-1!=-1)
      if( (map[a-50-1]==0 ) & (flag==0))
      {
        System.out.print("\nroom no "+(a-1)+" is available want to book press 1");
        flag = s.nextInt();
        if(flag==1){
        map[a-50-1]=1;
        rf=1;
        System.out.print("\nYour booked room no is: "+(a-1));
      }
  }
}
return rf;
  }

}

class Checkout extends Book{
  void cancel_room(int c){
    try{
      if(map[c-50]==1){
      map[c-50]=0;
      System.out.print("\nThank You Please Visit again");
}
else{
  System.out.print("\nPlease Try again");
}
}catch(Exception f){
  System.out.print("\nRoom is not in the list please try again");

}
}
}

class Manager{
  String username;
  String pass;

  int check(){
    Scanner s =new Scanner(System.in);
    System.out.print("\nUsername:  ");
    username = s.next();
    //Obtaining a reference to the console.
    Console con = System.console();
    // Checking If there is no console available, then exit.
    if(con == null)
    {
        System.out.print("\nNo console available");
        return 0;
    }
    System.out.println("\nEnter the password: ");
    char[] ch=con.readPassword();
    pass = String.valueOf(ch);
    if(username.equals("Prakriti") & pass.equals("1234567890")){
      return 1;
    }else{
      return 0;
    }
  }
}

class AK{
    public static void main(String[] args) {
        System.out.print("             Hotel Management System               \n");
        System.out.print("              Welcome to Hotel AK                  \n");
        Manager m =new Manager();
        do{
          System.out.print("Please enter the login Credentials\n");

      }while(m.check()==0);
      Checkout r = new Checkout();
      Customer c= new Customer();
      r.add_detail();
      while(true)
      {
	    System.out.println("Please enter the required field accordingly\n");
      System.out.println("Press 1 to check room availability\n");
	    System.out.println("Press 2 to check for paricular room\n");
      System.out.println("Press 3 to book a room\n");
      System.out.println("Press 4 to book a paricular room\n");
      System.out.println("Press 5 to checkout\n");
      System.out.println("else any no to exit the program\n");
      Scanner s =new Scanner(System.in);
      int n =s.nextInt();
      if(n==1){
        r.check();
      }
      else if(n==2)
      {
        System.out.println("\nPlease enter the room no. : ");
        n= s.nextInt();
        r.check(n);
      }else if(n==3)
      {
        int k=r.book_room();
        if(k==1)
        c.add_detail();

      }else if(n==4){
        System.out.println("\nPlease enter the room no. : ");
        n= s.nextInt();
        int k=r.book_room(n);
        if(k==1)
        c.add_detail();
      }else if(n==5){
        System.out.println("\nPlease enter the room no. : ");
        n= s.nextInt();
        r.cancel_room(n);
      }
      else
      System.exit(0);

}

}
}
