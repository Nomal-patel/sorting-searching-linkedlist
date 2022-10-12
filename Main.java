import java.util.Scanner;

public class Main {

    public static void main(String args[])  //static method
    {
        Assingment5.Linkedlist StormList = new Assingment5.Linkedlist();

        Assingment5.Storm S1 = new Assingment5.Storm("Hurricane Chantal",80,"July",1);
        Assingment5.Storm S2 = new Assingment5.Storm("Hurricane Gabrielle",145,"August",4);
        Assingment5.Storm S3 = new Assingment5.Storm("Hurricane Hugo",160,"September",5);
        Assingment5.Storm S4 = new Assingment5.Storm("Hurricane Felix",85,"August",1);
        Assingment5.Storm S5 = new Assingment5.Storm("Hurricane Erin",105,"August",2);

        StormList.push_back(S1);
        StormList.push_back(S2);
        StormList.insert(S3,1);
        StormList.push_back(S4);
        StormList.push_back(S5);

        StormList.printListData();


        StormList.printListDataReverse();


        Scanner myObj = new Scanner(System.in);
        boolean exit = true;

        while (exit){

            System.out.println("Type in the search or sort method you wanna use:  ");
            String method = myObj.nextLine();


            switch (method){
                case "sortwind":
                    StormList.sortWind();
                    StormList.printListData();
                    break;
                case "searchname":
                    System.out.println("Which hurricane do you wanna search: ");
                    String name = myObj.nextLine();
                    StormList.searchName(name);
                case "seaarchCategory":
                    System.out.println("Which Category do you wanna search: ");
                    int Category = myObj.nextInt();
                    StormList.searchCategory(Category);
                    break;
                case "searchmonth":
                    System.out.println("Which month do you wanna search: ");
                    String month = myObj.nextLine();
                    StormList.searchMonth(month);
                    break;
                case "exit":
                    exit = false;
                    break;

                default:
                    System.out.println("INVAILD COMMAND");
                    break;

            }


        }














    }




}
