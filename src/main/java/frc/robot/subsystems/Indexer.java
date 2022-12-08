// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Indexer extends SubsystemBase {
  WPI_TalonSRX indexerMotor;
  WPI_TalonSRX feederMotor;

  MotorControllerGroup motors;

  /** Creates a new Indexer. */
  public Indexer() {
    indexerMotor = new WPI_TalonSRX(Constants.INDEXER_MOTOR_INDEXER);
    feederMotor = new WPI_TalonSRX(Constants.INDEXER_MOTOR_FEEDER);

    indexerMotor.setNeutralMode(NeutralMode.Brake);
    feederMotor.setNeutralMode(NeutralMode.Brake);

    indexerMotor.setInverted(true);

    motors = new MotorControllerGroup(indexerMotor, feederMotor);
  }

  public void Index(){
    motors.set(Constants.INDEXER_MOTOR_PERCENTSPEED);
  }

  public void Terminate(){
    motors.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
