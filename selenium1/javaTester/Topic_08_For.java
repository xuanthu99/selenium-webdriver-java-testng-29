package javaTester;

import java.util.ArrayList;
import java.util.List;

public class Topic_08_For {
    public static void main(String[] args){
        //Biểu thức vòng lăp (loop)
        int number = 100;

        //for (clasic - interator)
        for(int i = 0; i < number; i++){
            if (i==5){
                System.out.println(i);
                break;
            }
          //  System.out.println(i);
        }

        // Collection: List/Set/Queue/Map
        List <String> name = new ArrayList<String>();
        name.add("Manual Testing");
        name.add("Automation Testing");
        name.add("UI Testing");

        //for each
//        for (String a: name){
//            System.out.println(a);
//        }
        for (String a: name){
            if(a.equals("Automation Testing")){
                System.out.println("Interview");
            }
        }

        int i  =  1000;
        //while
        while(i < number) {
            System.out.println(i);
            i++;
        }
        //do-while
        do{//action trước
            System.out.println(i);
            i++;
        } while(i< number);
    }
}
