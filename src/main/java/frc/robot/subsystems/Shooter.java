// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  WPI_TalonFX masterMotor;
  WPI_TalonFX followerMotor;
  
  /** Creates a new Shooter. */
  public Shooter() {
    masterMotor = new WPI_TalonFX(Constants.SHOOTER_MASTERMOTOR);
    followerMotor = new WPI_TalonFX(Constants.SHOOTER_FOLLOWERMOTOR);

    masterMotor.configFactoryDefault();

    masterMotor.setNeutralMode(NeutralMode.Coast);
    followerMotor.setNeutralMode(NeutralMode.Coast);

    masterMotor.config_kP(0, Constants.SHOOTER_kP);
    masterMotor.config_kI(0, Constants.SHOOTER_kI);
    masterMotor.config_kD(0, Constants.SHOOTER_kD);
    masterMotor.config_kF(0, Constants.SHOOTER_kF);

    followerMotor.follow(masterMotor);
    masterMotor.setInverted(true);
  }

  public void Shoot(int rpm, boolean hoodUp){
    if (hoodUp){
      // Put hood up
    }
    else{
      // Put hood down
    }

    masterMotor.set(TalonFXControlMode.Velocity, rpm);
  }

  public int LookUpRPM(int POV){
    int rpmSet;

    switch (POV){
      case 0:
        rpmSet = Constants.SHOOTER_SHOOTRPM_LOW;
      case 90:
        rpmSet = Constants.SHOOTER_SHOOTRPM_MID;
      case 180:
        rpmSet = Constants.SHOOTER_SHOOTRPM_HIGH;
      default:
        rpmSet = Constants.SHOOTER_IDLERPM;
    }

    return rpmSet;
  }

  @Override
  public void periodic() {
    
  }
}
