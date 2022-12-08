// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  
  WPI_TalonFX leftMotorOne;
  WPI_TalonFX leftMotorTwo;
  WPI_TalonFX leftMotorThree;

  WPI_TalonFX rightMotorOne;
  WPI_TalonFX rightMotorTwo;
  WPI_TalonFX rightMotorThree;

  MotorControllerGroup leftMotors;
  MotorControllerGroup rightMotors;

  DifferentialDrive differentialDrive;

  public Drivetrain() {
    leftMotorOne = new WPI_TalonFX(Constants.DRIVETRAIN_LEFTMOTOR_ONE);
    leftMotorTwo = new WPI_TalonFX(Constants.DRIVETRAIN_LEFTMOTOR_TWO);
    leftMotorThree = new WPI_TalonFX(Constants.DRIVETRAIN_LEFTMOTOR_THREE);

    rightMotorOne = new WPI_TalonFX(Constants.DRIVETRAIN_RIGHTMOTOR_ONE);
    rightMotorTwo = new WPI_TalonFX(Constants.DRIVETRAIN_RIGHTMOTOR_TWO);
    rightMotorThree = new WPI_TalonFX(Constants.DRIVETRAIN_RIGHTMOTOR_THREE);

    leftMotorOne.setNeutralMode(NeutralMode.Coast);
    leftMotorTwo.setNeutralMode(NeutralMode.Coast);
    leftMotorThree.setNeutralMode(NeutralMode.Coast);

    rightMotorOne.setNeutralMode(NeutralMode.Coast);
    rightMotorTwo.setNeutralMode(NeutralMode.Coast);
    rightMotorThree.setNeutralMode(NeutralMode.Coast);

    leftMotorOne.configOpenloopRamp(Constants.DRIVETRAIN_RAMPTIME_SECONDS);
    leftMotorTwo.configOpenloopRamp(Constants.DRIVETRAIN_RAMPTIME_SECONDS);
    leftMotorThree.configOpenloopRamp(Constants.DRIVETRAIN_RAMPTIME_SECONDS);

    rightMotorOne.configOpenloopRamp(Constants.DRIVETRAIN_RAMPTIME_SECONDS);
    rightMotorTwo.configOpenloopRamp(Constants.DRIVETRAIN_RAMPTIME_SECONDS);
    rightMotorThree.configOpenloopRamp(Constants.DRIVETRAIN_RAMPTIME_SECONDS);

    leftMotors = new MotorControllerGroup(leftMotorOne, leftMotorTwo, leftMotorThree);
    rightMotors = new MotorControllerGroup(rightMotorOne, rightMotorTwo, rightMotorThree);

    leftMotors.setInverted(true);

    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void ArcadeDrive(double speed, double turnBy){
    differentialDrive.arcadeDrive(speed, turnBy);
  }

  public void CurveDrive(double speed, double turnBy, boolean turnInPlace){
    differentialDrive.curvatureDrive(speed, turnBy, turnInPlace);
  }

  public void Brake(boolean brake){
    if (brake){
      leftMotorOne.setNeutralMode(NeutralMode.Brake);
      leftMotorTwo.setNeutralMode(NeutralMode.Brake);
      leftMotorThree.setNeutralMode(NeutralMode.Brake);

      rightMotorOne.setNeutralMode(NeutralMode.Brake);
      rightMotorTwo.setNeutralMode(NeutralMode.Brake);
      rightMotorThree.setNeutralMode(NeutralMode.Brake);
    }
    else{
      leftMotorOne.setNeutralMode(NeutralMode.Coast);
      leftMotorTwo.setNeutralMode(NeutralMode.Coast);
      leftMotorThree.setNeutralMode(NeutralMode.Coast);
  
      rightMotorOne.setNeutralMode(NeutralMode.Coast);
      rightMotorTwo.setNeutralMode(NeutralMode.Coast);
      rightMotorThree.setNeutralMode(NeutralMode.Coast);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
