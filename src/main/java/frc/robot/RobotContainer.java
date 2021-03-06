/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Driving;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.UpdateVision;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.VisionBrain;



/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final VisionBrain m_visionBrain = new VisionBrain();
  private final Drivetrain driveTrain = new Drivetrain(Constants.fLId, Constants.fRId, Constants.bLId, Constants.bRId);

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final UpdateVision visionUpdater = new UpdateVision(m_visionBrain);
  private final Driving driving = new Driving(driveTrain);

  public static Joystick leftDriver = new Joystick(0);
  public static Joystick rightDriver = new Joystick(1);


  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    driveTrain.setDefaultCommand(driving);
    System.out.println("Testting");
    m_visionBrain.setDefaultCommand(visionUpdater);
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  public static Joystick getLeft() {
    return leftDriver;
  }

  public static Joystick getRight() {
    return rightDriver;
  }

  private void configureButtonBindings() {
    
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
  public Command getDriving(){
    return driving;
  }
}
