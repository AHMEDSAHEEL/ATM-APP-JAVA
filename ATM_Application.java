import java.util.*;

class ATM_Application {
  public static void main(String[] args) {

    ArrayList<Integer> userAccNo=new ArrayList<>();
    ArrayList<String> userName=new ArrayList<>();
    ArrayList<String> userPass=new ArrayList<>();
    ArrayList<Integer> userAccBal=new ArrayList<>();
    ArrayList<Integer> checkHistoryMoney=new ArrayList<>();
    ArrayList<Integer> checkHistoryNumber=new ArrayList<>();
    ArrayList<String> checkHistoryName=new ArrayList<>();
    
    userAccNo.add(43795); userName.add("ahmed");userPass.add("12Ac");userAccBal.add(101231);
    userAccNo.add(43695);userName.add("sarvesh");userPass.add("12Bc");userAccBal.add(101222);
    userAccNo.add(43895);userName.add("tariq");userPass.add("12Mc");userAccBal.add(102212);
    userAccNo.add(43995);userName.add("besanto");userPass.add("12Nc");userAccBal.add(102231);
   
    Scanner s = new Scanner(System.in);
    Scanner c = new Scanner(System.in);
    Random r = new Random();
    
    int max=99999;
    String pass="",C_userName="",C_userPass="",Change_pass="";
    int continu=0,sendMoney=0,count=0,find=0,rece=0,choice=0,login=0,AccNum=0,num=0;

 menu1:
 do{
    System.out.println("\n   ****************** Select the Option ********************     \n");
    System.out.println("     1.Login \t2.Create New Account\t3.Change Password\n");
    System.out.println("Enter the option: ");
    login=s.nextInt();
    
   if(login==1){
    System.out.println("Enter ACCOUNT_NUMBER: ");
     AccNum=s.nextInt();

     aa:
    for(int i=0;i<userAccNo.size();i++){
         
        if(AccNum==userAccNo.get(i)) {
            find=userAccBal.get(i);

            while(pass!=userPass.get(i)){
                System.out.println();
                System.out.println("Enter your Account Password: ");
                pass=c.nextLine();

                  if(pass.equals(userPass.get(i))){
                        break aa;
                    }
                    else{
                        System.out.println();
                        System.out.println("Wrong password");
                    }
                }
            }
        else{
           count++;
             if(count==userAccNo.size()){
                System.out.println("Invalid Account Number");
                break;
            }
        }
    }
    break menu1;
  }

   if(login==2){
    System.out.println("Create Username: ");
    C_userName=c.nextLine();
    System.out.println("Create Password: ");
    C_userPass=c.nextLine();
    userName.add(C_userName);
    userPass.add(C_userPass);
    AccNum=r.nextInt(max);
    userAccNo.add(AccNum);
    userAccBal.add(1000);
    find=userAccBal.get(userAccNo.indexOf(AccNum));
    System.out.println("\nCongrats "+C_userName+"!, You have successfully Created your Account,Account Number="+AccNum+" and 1000 as minimum balance Credited.");
   }

   if(login==3){
    do{
    System.out.println("Enter your Account Number: ");
    AccNum=s.nextInt();
    if(!userAccNo.contains(AccNum)){
        System.out.println("\nInvalid Account Number\n");
    }
   }while(!userAccNo.contains(AccNum));
    do{
    System.out.println("Enter your Account Password: ");
    pass=c.nextLine();
    if(!userPass.contains(pass)){
        System.out.println("\nInvalid Password\n");
    }
   }while(!userPass.contains(pass));
    System.out.println("Create New Password: ");
    Change_pass=c.nextLine();
    userPass.set(userPass.indexOf(pass), Change_pass);
    System.out.println("Password Changed Successfully");
  }

   if(login>3){
    System.out.println("\nSelect the Correct Option");
   }
    continu=login;
    }while(continu!=-988767);{
        System.out.println("Thank You and Welcome to payment option ");
    }

//                             ******************   user login finished ***************************** 

    if(count!=4 || login==1 || login==2||login==3||login==4){

        do{
            System.out.println();
            System.out.println("**************** Select the Payments Option ************************\n");
            System.out.println("\t1.Send Money \t2.Check Balance\n\n\t3.User Details \t4.Check History"+"  5.Exit\n");
            System.out.println("Enter the option no: ");
            choice=s.nextInt();

        if(choice==1){
            System.out.println("Receiver User-AccountNumber: ");
            num=s.nextInt();
        if(!userAccNo.contains(num)|| userAccNo.get(userAccNo.indexOf(num)).equals(AccNum)){
            System.out.println();
            System.out.println("Wrong Account Number,Enter again from the option..");
        }
        else{
        System.out.println();
        System.out.println("how much  money you want to send to "+userName.get(userAccNo.indexOf(num))+ ": ");
        sendMoney=s.nextInt();
        System.out.println();
        find=find-sendMoney;

            if(find<0){
                System.out.println();
                System.out.println("Insufficient Balance");
                find=find+sendMoney;
            }
            else{ 
            checkHistoryMoney.add(sendMoney);
            checkHistoryNumber.add(num);
            checkHistoryName.add(userName.get(userAccNo.indexOf(num)));
            userAccBal.set(userAccNo.indexOf(AccNum),find);
            rece=userAccBal.get(userAccNo.indexOf((num)))+sendMoney;
            userAccBal.set(userAccNo.indexOf(num),rece);   
            System.out.println(userName.get(userAccNo.indexOf(AccNum))+"'s Available Balance: "+find);
            System.out.println();
          //  System.out.println(userName.get(userAccNo.indexOf(num))+"'s Available balance: "+rece);  // *********** receiver Balance.*********
            }}
        }

        else if(choice==2){
            System.out.println();
            System.out.println(userName.get(userAccNo.indexOf(AccNum))+"'s Available Balance: "+find);
        }

        else if(choice==3){   
            System.out.println();
            System.out.println("User Name: "+userName.get(userAccNo.indexOf(AccNum))+"\n");
            System.out.println("User Account Number: "+userAccNo.get(userAccNo.indexOf(AccNum))+"\n");
            System.out.println("User Account balance: "+userAccBal.get(userAccNo.indexOf(AccNum)));    
        }

        else if(choice==4){
            System.out.println();
            if(checkHistoryMoney.isEmpty())
            {
                System.out.println("You didn't initiate the transaction");
            }
            else{
                System.out.println("Your last Five or less Transaction: ");
                System.out.println();
                int t=0;
            for(int i=checkHistoryMoney.size();i>0;i--){
                t++;
                if(t==6)
                {
                    break;
                }
                System.out.println("You send "+checkHistoryMoney.get(i-1)+" rupees to "+checkHistoryName.get(i-1));
            }
          }
        }

        else if(choice==5){
            System.out.print("");
        }
            System.out.println();
            System.out.println("do you want to continue payment press 1 or if not 0 to exit");
            continu=s.nextInt();
        }while(continu!=0);{
            System.out.println("Thank You");
        }   
    }
    
  s.close();
  c.close();
}
}  

