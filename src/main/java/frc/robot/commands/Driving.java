/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

/**
 * An example command that uses an example subsystem.
 */
public class Driving extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  NetworkTableInstance inst;
  NetworkTable table;
  NetworkTableEntry move;
  

  private final Drivetrain driveTrain;

  /**
   * Creates a new ExampleCommand.
   *
   * @param driveTrain The subsystem used by this command.
   */
  public Driving(Drivetrain subsystem) {
    driveTrain = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    inst = NetworkTableInstance.getDefault();
    inst.startClient("10.25.26.157", 1735);
    inst.startClientTeam(2526);
    table = inst.getTable("Vision");
    move = table.getEntry("Move");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (move.getBoolean(false) == true) {
      driveTrain.vision();
    }
    driveTrain.Driving(RobotContainer.getLeft(), RobotContainer.getRight());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    inst.stopClient();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
