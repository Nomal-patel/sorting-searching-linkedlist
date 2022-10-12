

public class Assingment5 {

    //Crates tthe basic class and structure for Storm
    public static class Storm{
        public String name;                 //name of the huricane
        public String monthFormed;          //the month of which the storm formed
        public int maxWind;                 //the maximum recorded wind speed
        public int category;                //The storm's category (1-5) for named tropical storm (0)

        public Storm(String n, int w, String m, int c){
            this.name = n;
            this.maxWind = w;
            this.monthFormed = m;
            this.category = c;
        }//end Storm

        /***********************************************************************************
         * getter
         */
        public String getName() {
            return name;
        }

        public String getMonthFormed() {
            return monthFormed;
        }

        public int getMaxWind() {
            return maxWind;
        }

        public int getCategory() {
            return category;
        }

        /***********************************************************************************
         * setter
         */
        public void setName(String name) {
            this.name = name;
        }

        public void setMonthFormed(String monthFormed) {
            this.monthFormed = monthFormed;
        }

        public void setMaxWind(int maxWind) {
            this.maxWind = maxWind;
        }

        public void setCategory(int category) {
            this.category = category;
        }
    }//end class Storm

    //begin node class which is gonna take care of the one sepration of nodes

    public static class Node{
        public Storm s;
        public Node next;

        public  Node previous;

        Node(){
            s = null;
            next = null;
        }

        public Storm getS(){
            return s;
        }

        public  Node getNext(){
            return next;
        }
    }

    //This is the list with the format for the list and also the
    // inster function and push back function
    public static class Linkedlist{
        private Node head;
        private Node tail;
        //Pointer to the end of the list
        //Constructor. Sets the head and tail to NULL
        Linkedlist() {
            Node head;
            Node tail;

        }

        public Linkedlist(Node head, Node tail) {
            this.head = head;
            this.tail = tail;

        }

        //updated pushback function from the singly linked list

        public void push_back(Storm newS) {
            Node temp = new Node();
            temp.s = newS;
            temp.next = null;
            if(head == null) {
                temp.previous = null;
                head = temp;
                tail = temp;
                return;
            }
            else {
                tail.next = temp;
                temp.previous = tail;
                tail = temp;
            }
        }

        //updated insert method

        public  void insert(Storm newS, int index) {
            Node temp = head;
            int counter = 0;
            while(counter < index-1 && temp != null) {
                temp = temp.next;
                counter++;
            }
            if(temp == null || temp.next == null) {
                return;
            }
            else {
                Node newNode = new Node();
                newNode.s = newS;
                newNode.next = temp.next;
                newNode.previous = temp;
                temp.next.previous = newNode;
                temp.next = newNode;
                return;
            }
        }

        //The function to print the data

        public void printListData(){
            Node tempPtr;
            tempPtr = head;
            while (tempPtr != null){
                System.out.println("Hurricane: " + tempPtr.s.getName() + "\n" +
                        "Wind speed: " + tempPtr.s.getMaxWind() + " MPH\n"+
                        "Month formed: " + tempPtr.s.getMonthFormed() + "\n" +
                        "Category: " + tempPtr.s.getCategory() + "\n");
                System.out.println("------------------------------------------");
                tempPtr =  tempPtr.next;
            }
        }


        //printing the list in reverse from tail to head


        public void printListDataReverse(){
            Node tempPtr;
            tempPtr = tail;
            while (tempPtr != null){
                System.out.println("Hurricane: " + tempPtr.s.getName() + "\n" +
                        "Wind speed: " + tempPtr.s.getMaxWind() + " MPH\n"+
                        "Month formed: " + tempPtr.s.getMonthFormed() + "\n" +
                        "Category: " + tempPtr.s.getCategory() + "\n");
                System.out.println("------------------------------------------");
                tempPtr =  tempPtr.previous;
            }
        }


        int size() {
            int count = 0;                                      //Starts the counter at zero
            Node temp = head;                                  //Start with the head
            while(temp != null) {                               //As long as the temp pointer is not null
                count++;                                        //Increment the counter
                temp = temp.next;                              //Get the next node
            }
            return count;                                       //Return the count/total
        }

        public void sortWind(){
            Node temp;
            int size = this.size();
            for (int i=0; i<size-1; i++){
                temp = head;
                for (int j=0; j<size-i-1; j++){
                    Node t1 = temp;
                    Node t2 = temp.next;
                    if(t1.s.maxWind > t2.s.maxWind){
                        Storm t = t2.s;
                        t2.s = t1.s;
                        t1.s = t;
                    }
                    temp = temp.next;
                }
            }
        }

        public void searchName(String searchVal){
            Node temp =  head;
           boolean found = false;
           while (temp != null){

               if(temp.s.name.equals(searchVal)){
                   System.out.println("Hurricane: " + temp.s.getName() + "\n" +
                           "Wind speed: " + temp.s.getMaxWind() + " MPH\n"+
                           "Month formed: " + temp.s.getMonthFormed() + "\n" +
                           "Category: " + temp.s.getCategory() + "\n");                    found = true;
               }
               temp = temp.next;
           }
            if(!found){
                System.out.println("Couldn't find hurricane with name: " + searchVal);
            }
        }

        public void searchCategory(int searchCat){
            Node temp =  head;
            boolean found = false;
            while (temp != null){

                if(temp.s.getCategory() == searchCat){
                    System.out.println("Hurricane: " + temp.s.getName() + "\n" +
                            "Wind speed: " + temp.s.getMaxWind() + " MPH\n"+
                            "Month formed: " + temp.s.getMonthFormed() + "\n" +
                            "Category: " + temp.s.getCategory() + "\n");                    found = true;
                }
                found = true;
                temp = temp.next;
            }
            if(!found){
                System.out.println("Couldn't find hurricane with category: " + searchCat);
            }

        }

        public void searchMonth(String searchMon){
            Node temp =  head;
            boolean found = false;
            while (temp != null){

                if(temp.s.monthFormed.equals(searchMon)){
                    System.out.println("Hurricane: " + temp.s.getName() + "\n" +
                            "Wind speed: " + temp.s.getMaxWind() + " MPH\n"+
                            "Month formed: " + temp.s.getMonthFormed() + "\n" +
                            "Category: " + temp.s.getCategory() + "\n");                    found = true;
                }
                temp = temp.next;
            }
            if(!found){
                System.out.println("Couldn't find hurricane with month: " + searchMon);
            }
        }














    }



}

