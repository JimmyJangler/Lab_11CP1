import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        final String menu = "A - Add  D - Delete  P - Print  Q - Quit";
        boolean done = false;
        String cmd = "";
        String item = "";
        int listRemove = 0;
        int listLength = 0;

        do {
            listLength = list.size();
            //display list
            displayList();
            //Display menu and get a menu choice (bulletproof with safeinput
            cmd = SafeInput.getRegExString(in, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();

            switch(cmd)
            {
                case "A":
                    //prompt the user for list item (bulletproof with safeinput)
                    //add to the list
                    item = SafeInput.getNonZeroLenString(in, "What would you like to add to the list?");
                    list.add(item);
                    break;
                case "D":
                    //prompt for number to remove from list (bulletproof with safeinput)
                    //translate to index by subtracting 1
                    listRemove = SafeInput.getRangedInt(in, "Which item would you like to remove from the list?", 1, listLength) -1;
                    //remove from list
                    list.remove(listRemove);
                    break;
                case "P":
                    displayList();
                    break;
                case "Q":
                    done = SafeInput.getYNConfirm(in, "Are you done?");
                    break;
            }

        }while(!done);

    }

    private static void displayList() {
        System.out.println("---------------------------------------------------");
        if (list.size() != 0) {
            for (int x = 0; x < list.size(); x++) {
                System.out.printf("%3d         %-5s", x + 1, list.get(x));
                System.out.println();
            }
        } else {
            System.out.println("-------------------List is Empty-------------------");
        }
        System.out.println("---------------------------------------------------");

    }
}