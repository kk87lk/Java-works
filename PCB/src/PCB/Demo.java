package PCB;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		PCBui unit = new PCBui();
		PCB pcb = new PCB();
		pcb.Create();
		pcb.Create();
		pcb.Display();
		pcb.Active(1);
		pcb.Display();
	}

}
