package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class VisionBrain extends SubsystemBase{
    public NetworkTableEntry testEntry;
    NetworkTableInstance inst;
    NetworkTable table;
    
    public VisionBrain() {
        inst = NetworkTableInstance.getDefault();

        table = inst.getTable("zach");

        testEntry = table.getEntry("testZach");

        System.out.println("Hey guys, vision brain has been created");
    }

    public void ReadNetworkTable() {

    }

    public void PublishNetworkTable() {
        testEntry.setDouble(100);
        System.out.println("Hi m");
    }
}
