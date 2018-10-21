package PCB;

import java.util.Scanner;

class PCBUnit {

    public int pid = 0;

    public int uid = 0;

    // public int processStatus = (Integer) null;// 0:running 1:ready 2£ºsuspend
    // 3:active-suspend
    public PCBUnit next = null;

    public PCBUnit(int input_pid, int input_uid) {
        pid = input_pid;
        uid = input_uid;
    }

    public int getpid() {
        return pid;
    }
}

public class PCB {

    PCBUnit Head_run_static = new PCBUnit(0, 0);

    PCBUnit Head_ready_static = new PCBUnit(0, 0);

    PCBUnit Head_wait_static = new PCBUnit(0, 0);
    // PCBUnit Head_run = Head_run_static;
    // PCBUnit Head_ready = Head_ready_static;
    // PCBUnit Head_wait = Head_wait_static;

    void Display() {
        PCBUnit Head_run = Head_run_static;
        System.out.print('\n' + "Running: ");
        while (Head_run != null) {
            if (Head_run.pid != 0)
                System.out.print("[PID:" + Head_run.pid + " UID:" + Head_run.uid + "] ");
            Head_run = Head_run.next;
        }
        PCBUnit Head_ready = Head_ready_static;
        System.out.print('\n' + "Waiting: ");
        while (Head_ready != null) {
            if (Head_ready.pid != 0)
                System.out.print("[PID:" + Head_ready.pid + " UID:" + Head_ready.uid + "] ");
            Head_ready = Head_ready.next;
        }
        PCBUnit Head_wait = Head_wait_static;
        System.out.print('\n' + "Suspending: ");
        while (Head_wait != null) {
            if (Head_wait.pid != 0)
                System.out.print("[PID:" + Head_wait.pid + " UID " + Head_wait.uid + "] ");
            Head_wait = Head_wait.next;
        }
    }

    void Create() {
        PCBUnit Head_wait = Head_wait_static;
        Scanner input = new Scanner(System.in);
        while (Head_wait.next != null)
            Head_wait = Head_wait.next;
        System.out.print("Input the pid & uid:");
        PCBUnit newUnit = new PCBUnit(input.nextInt(), input.nextInt());
        Head_wait.next = newUnit;
    }

    void Active(int input_pid) {
        // Scanner input = new Scanner(System.in);
        // System.out.print("Input the pid of process you want to active:");
        PCBUnit Head_wait = Head_wait_static;
        PCBUnit Head_ready = Head_ready_static;
        PCBUnit frontProcess = new PCBUnit(0, 0);
        for (; Head_wait.next != null; Head_wait = Head_wait.next) {
            if (Head_wait.pid == input_pid)
                break;
            frontProcess = Head_wait;
        }
        PCBUnit activedProcess = Head_wait;
        if (Head_wait == null) {
            System.out.println("Invalid pid!");
            return;
        } else {
            frontProcess.next = activedProcess.next;
            while (Head_ready.next != null)
                Head_ready = Head_ready.next;
            Head_ready.next = activedProcess;
            activedProcess.next = null;
        }
    }

    void Suspend(int input_pid) {
        PCBUnit Head_ready = Head_ready_static;
        PCBUnit Head_wait = Head_wait_static;
        PCBUnit frontProcess = new PCBUnit(0, 0);
        for (; Head_ready.next != null; Head_ready = Head_ready.next) {
            if (Head_ready.pid == input_pid)
                break;
            frontProcess = Head_ready;
        }
        PCBUnit activedProcess = Head_ready;
        if (Head_ready == null) {
            System.out.println("Invalid pid!");
            return;
        } else {
            frontProcess.next = activedProcess.next;
            while (Head_wait.next != null)
                Head_wait = Head_wait.next;
            Head_wait.next = activedProcess;
            activedProcess.next = null;
        }
    }

    void End(int input_pid) {
        PCBUnit Head_run = Head_run_static;
        PCBUnit Head_ready = Head_ready_static;
        PCBUnit Head_wait = Head_wait_static;
        PCBUnit frontProcess = new PCBUnit(0, 0);
        PCBUnit endProcess = new PCBUnit(0, 0);
        // PCBUnit frontProcess3 = new PCBUnit(0, 0);
        Scanner input = new Scanner(System.in);
        System.out.print('\n' + "Input the status of the process you want to end(1.running 2.waiting 3.suspending):");
        switch (input.nextInt()) {
        case 1: {
            for (; Head_run.next != null; Head_run = Head_run.next) {
                if (Head_run.pid == input_pid) {
                    endProcess = Head_run;
                    break;
                }
                frontProcess = Head_run;
            }
            if (endProcess != null) {
                frontProcess.next = endProcess.next;
                return;
            }
            break;
        }
        case 2: {
            for (; Head_ready.next != null; Head_ready = Head_ready.next) {
                if (Head_ready.pid == input_pid) {
                    endProcess = Head_ready;
                    break;
                }
                frontProcess = Head_ready;
            }
            int pid = endProcess.getpid();
            if (pid == input_pid) {
                frontProcess.next = endProcess.next;
                return;
            }
            break;
        }
        case 3: {
            for (; Head_wait.next != null; Head_wait = Head_wait.next) {
                if (Head_wait.pid == input_pid) {
                    endProcess = Head_wait;
                    break;
                }
                frontProcess = Head_wait;
            }
            if (endProcess != null) {
                frontProcess.next = endProcess.next;
                return;
            }
            break;
        }
        }
    }
}
