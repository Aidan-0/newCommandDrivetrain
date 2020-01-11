/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
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

  CANSparkMax fL;
  CANSparkMax fR;
  CANSparkMax bL;
  CANSparkMax bR;

  SpeedControllerGroup leftMotors;
  SpeedControllerGroup rightMotors;

  DifferentialDrive drive;
  double deadZone;
  double slowZone;

  public Drivetrain(int fLId, int fRId, int bLId, int bRId) {

    fL = new CANSparkMax(fLId, MotorType.kBrushless);
    fR = new CANSparkMax(fRId, MotorType.kBrushless);
    bL = new CANSparkMax(bLId, MotorType.kBrushless);
    bR = new CANSparkMax(bRId, MotorType.kBrushless);

    fL.setInverted(false);
    fR.setInverted(true);
    bL.setInverted(false);
    bR.setInverted(true);

    leftMotors = new SpeedControllerGroup(fL, bL);
    rightMotors = new SpeedControllerGroup(fR, bR);


    drive = new DifferentialDrive(leftMotors, rightMotors);

    deadZone = 0.2;
    slowZone = 0.6;

  }

  public void Driving(Joystick leftDriver, Joystick rightDriver) {

     drive.arcadeDrive(leftDriver.getY(), rightDriver.getX(), true);

     /*
    if (leftDriver.getY() < -deadZone || leftDriver.getY() > deadZone) {
      if (leftDriver.getY() < -slowZone || leftDriver.getY() > slowZone) {
        rightMotors.set(leftDriver.getY()/4);
      }
      else {
        rightMotors.set(leftDriver.getY()/2);
      }
    }
    if (rightDriver.getY() < -deadZone || rightDriver.getY() > deadZone) {
      if (rightDriver.getY() < -slowZone || rightDriver.getY() > slowZone) {
        leftMotors.set(-rightDriver.getY()/4);
      }
      else {
        leftMotors.set(-rightDriver.getY()/2);
      }
    }
     /*
     if (leftDriver.getY() < -deadZone || leftDriver.getY() > deadZone) {
       if (leftDriver.getY() < -slowZone || leftDriver.getY() > slowZone) {
        leftMotors.set(leftDriver.getY()/2);
        rightMotors.set(leftDriver.getY()/2);
       }
       else {
        leftMotors.set(leftDriver.getY());
        rightMotors.set(leftDriver.getY());
       }
      }
     if (rightDriver.getX() < -deadZone || rightDriver.getX() > deadZone) {
      if (rightDriver.getX() < -slowZone || rightDriver.getX() > slowZone) {
        leftMotors.set(rightDriver.getX()/2);
        rightMotors.set(rightDriver.getX()/2);
      }
      else {
        leftMotors.set(rightDriver.getX());
       rightMotors.set(rightDriver.getX());
      }
     }
     else {
      leftMotors.set(0);
      rightMotors.set(0);
     }
     */
  }

  public void vision() {
     drive.arcadeDrive(0.3, 0.3);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
