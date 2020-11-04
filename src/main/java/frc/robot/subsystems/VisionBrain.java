package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
        SmartDashboard.putNumber("Test value", SmartDashboard.getNumber("Test value", 0) + 1);
        testEntry.setDouble(SmartDashboard.getNumber("Test value", 0));
    }
}
