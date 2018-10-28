package PCB;

import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PCB pcb = new PCB();
        PCBui unit = new PCBui(pcb);
        Scanner select = new Scanner(System.in);
        int num = 7;
        while (num != 0) {
            System.out.println("Select an option:");
            System.out.println("1.Create process");
            System.out.println("2.Suspend process");
            System.out.println("3.Active process");
            System.out.println("4.End process");
            System.out.println("5.Display process");
            num = select.nextInt();
            switch (num) {
            case 1:
                break;
            case 2:
                System.out.print("Input the pid:");
                Scanner input = new Scanner(System.in);
                pcb.Suspend(input.nextInt());
                break;
            case 3:
                System.out.print("Input the pid:");
                Scanner input1 = new Scanner(System.in);
                pcb.Active(input1.nextInt());
                break;
            case 4:
                System.out.print("Input the pid:");
                Scanner input2 = new Scanner(System.in);
                pcb.End(input2.nextInt());
                break;
            case 5:
                pcb.Display();
                break;
            default:
                break;
            }
        }
    }
}
