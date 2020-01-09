/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
 * @param fLId
 * @param bRId
 * @param bLId
 * @param fRId
   */

  CANSparkMax FL;
  CANSparkMax FR;
  CANSparkMax BL;
  CANSparkMax BR;

  SpeedControllerGroup leftMotors;
  SpeedControllerGroup rightMotors;

  DifferentialDrive drive;


  public Drivetrain(int FLId, int FRId, int BLId, int BRId) {

    FL = new CANSparkMax(FLId, MotorType.kBrushless);
    FR = new CANSparkMax(FRId, MotorType.kBrushless);
    BL = new CANSparkMax(BLId, MotorType.kBrushless);
    BR = new CANSparkMax(BRId, MotorType.kBrushless);

    FL.setInverted(false);
    FR.setInverted(false);
    BL.setInverted(false);
    BR.setInverted(true);

    leftMotors = new SpeedControllerGroup(FL, BL);
    rightMotors = new SpeedControllerGroup(FR, BR);

    drive = new DifferentialDrive(leftMotors, rightMotors);
    
  }

  public void Driving(Joystick leftDriver, Joystick rightDriver) {
    drive.arcadeDrive(leftDriver.getY(), rightDriver.getX(), true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
