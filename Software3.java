import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;

public  class Software3 {
    int choice;
    //to compare 
  static  ArrayList<user> Accounts = new ArrayList<>();
  static ArrayList<item> Items = new ArrayList<>();
  static  ArrayList<item> Listofposts = new ArrayList<>();
  //orginal accounts
 static  ArrayList<user> Listofaccounts = new ArrayList<>();



public static class database{
    UserInterface userinfo;
      public static void savedata(ArrayList<user> account ,item T) throws IOException{
        File file = new File("database.txt");
FileWriter fr = new FileWriter(file, true);
BufferedWriter writer2 = new BufferedWriter(fr);
     Accounts=account;
     writer2.write("[Name]" + " \t"+ "[password]"+"\t"+"[Age]"+"\t"+"[Gender]" );
      writer2.write("     " + " \t"+ "       "+"\t"+"   "+"\t"+"     " );
     for (int i=0 ;i<Accounts.size();i++){
     writer2.write(Accounts.get(i).Name + " \t "+ Accounts.get(i).Password +" \t "+"\t"+Accounts.get(i).Age + " \t "+ Accounts.get(i).Gender);
      writer2.newLine();
      writer2.newLine();
       
     }
     if(T!=null){
      writer2.write(" [ your post ]" );
       writer2.write("( description of item is" + "::"+ T.description+":: "+" and date that found it is "+"::"+ T.date+"::"+
               " and the location that found it is  "+"::"+ T.location +
               " and type of it is "+"::"+ T.type+")");
        writer2.newLine();
      writer2.close();
      fr.close();
   }
      }
       
    
 public static boolean checkdata(UserInterface user,item i) throws FileNotFoundException, IOException{
 BufferedReader br = new BufferedReader(new FileReader("database.txt"));
String line;
boolean nameFound = false;
Post d=new Post();
while ((line = br.readLine()) != null) {
    if (line.contains(user.data.Name) && line.contains(user.data.Password) ) {
        out.println("VALID username and password");
        System.out.println(" WELCOME in OUR APPLICATION >>>>> ");
       System.out.println(" << 1-DO post >> "+ "\t"+" << 2-search post >> ");
           Scanner inn=new Scanner(System.in);
        int choice=inn.nextInt();
         if(choice==1){
            
             d.WritePost();
         }
         if(choice==2){
            System.out.println(" describe your lost item to search for: ");
               String c=inn.next();
               d.search(c);
             
         }
        nameFound = true;
        break;
}
}
if (!nameFound) {
    out.println("INVALID username and password ..... Please enter the valid username and password");
}
br.close();
    
        return false;
    
    
    
    
    }
    
    }
public static class deliever{
    public detection detect=new detection();
    public String place;
    public String address;
    public item i=new item();
    public message m;
    public void request(detection detect,item i){
        if(detect.messagestate==true){
        System.out.println("Enter your address and place to help us to deliver your item: ");
         System.out.println("THE PLACE:: ");
        Scanner y=new Scanner(System.in);
        place=y.next();
         System.out.println("THE ADDRESS:: ");
        address=y.next();
        meeting(place,address,i);
    }
        
    
    }
    public static void meeting(String place,String address,item i){
        
        System.out.println("we will meet at("+place+")"+"\t"+" at address(" +address+")"+"\t"+" to give your (" +i.description+i.type+")");
    }
    }


public static class user{
 String Name;
 int Age;
 String Gender;
 String Password;

public void setname(String n){
    Name=n;
}
public void setage(int a){
    Age=a;
}
public void setgender(String g){
    Gender=g;
}
public void setpassword(String p){
    Password=p;
}
public String getname(){
    return Name;
}
public int getage(){
    return Age;
}
public String getgender(){
    return Gender;
}
public String getpassword(){
    return Password;
}
/////////////////
public static boolean login(String username, String password) throws FileNotFoundException, IOException{ 
    UserInterface object=new UserInterface();
    database x=new database();
 object.data.Name=username;
 object.data.Password=password;
 x.checkdata(object, null);

return false;
}
//////////////////
public static void Signup(String username, String password,int age,String gender) throws IOException{
    Post d = new Post();
       database b=new database();
 BufferedReader br = new BufferedReader(new FileReader("database.txt"));
String line;
boolean nameFound = false;

while ((line = br.readLine()) != null) {
    if (line.contains(username) && line.contains(password) ) {
        out.println(" WARNING >>>......the username and password are already used ");
        nameFound = true;
        break;
}
}
if (!nameFound) {
  
       System.out.println(" WELCOME in OUR APPLICATION >>>>> your data are saved successfully");
       System.out.println(" << 1-DO post >> "+ "\t"+" << 2-search post >> ");
           Scanner inn=new Scanner(System.in);
        
        int choice=inn.nextInt();
         if(choice==1){
              
            d.WritePost();
         }
         if(choice==2){
            
              System.out.println(" describe your lost item to search for: ");
               String c=inn.next();
               d.search(c);
               b.savedata(Listofaccounts, null);
         }
}
br.close();

}
/////////////////
public void Run(){
    
}
    }
 /**
     *
     * @param args
     */
    public static void main(String[] args) throws IOException,FileNotFoundException {
        
       
UserInterface y = new UserInterface();
y.DisplayHomePage();
     
        
        
        
    }
     }
    