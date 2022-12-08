// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Collector extends SubsystemBase {
  WPI_TalonFX collectorMotor;

  DoubleSolenoid extendPiston;

  boolean extended;
  /** Creates a new Collector. */
  public Collector() {
    collectorMotor = new WPI_TalonFX(Constants.COLLECTOR_MOTOR);

    collectorMotor.setNeutralMode(NeutralMode.Coast);

    extendPiston = new DoubleSolenoid(Constants.COLLECTOR_EXTENDPISTON_ID, PneumaticsModuleType.REVPH, Constants.COLLECTOR_EXTENDPISTON_CHANNEL_FORWARD, Constants.COLLECTOR_EXTENDPISTON_CHANNEL_REVERSE);
  }

  public void Activate(boolean dump){
    extendPiston.set(Value.kForward);

    if (!dump){
      collectorMotor.set(ControlMode.PercentOutput, Constants.COLLECTOR_MOTOR_PERCENTSPEED);
    }
    else{
      collectorMotor.set(ControlMode.PercentOutput, -Constants.COLLECTOR_MOTOR_PERCENTSPEED);
    }
  }

  public void Retract(){
    extendPiston.set(Value.kReverse);
    collectorMotor.set(ControlMode.PercentOutput, 0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
