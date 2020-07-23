/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   * 
   * @param fLId
   * @param bRId
   * @param bLId
   * @param fRId
   */

  WPI_TalonSRX fL;
  WPI_TalonSRX fR;
  WPI_TalonSRX bL;
  WPI_TalonSRX bR;

  SpeedControllerGroup leftMotors;
  SpeedControllerGroup rightMotors;

  DifferentialDrive drive;

  public Drivetrain(int fLId, int fRId, int bLId, int bRId) {

    fL = new WPI_TalonSRX(fLId);
    fR = new WPI_TalonSRX(fRId);
    bL = new WPI_TalonSRX(bLId);
    bR = new WPI_TalonSRX(bRId);

    fL.setInverted(true);
    bL.setInverted(true);
    bR.setInverted(true);

    leftMotors = new SpeedControllerGroup(fL, bL);
    rightMotors = new SpeedControllerGroup(fR, bR);

    drive = new DifferentialDrive(leftMotors, rightMotors);

  }

  public void Driving(Joystick leftDriver, Joystick rightDriver) {
    drive.arcadeDrive(leftDriver.getY(), -rightDriver.getX());
 
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
