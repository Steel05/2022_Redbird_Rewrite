// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  WPI_TalonFX masterMotor;
  WPI_TalonFX followerMotor;

  DoubleSolenoid hoodPiston;
  
  /** Creates a new Shooter. */
  public Shooter() {
    
    hoodPiston = new DoubleSolenoid(Constants.SHOOTER_HOODPISTON_ID, PneumaticsModuleType.REVPH, Constants.SHOOTER_HOODPISTON_CHANNEL_FORWARD, Constants.SHOOTER_HOODPISTON_CHANNEL_REVERSE);

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
      hoodPiston.set(Value.kForward);
    }
    else{
      hoodPiston.set(Value.kReverse);
    }

    masterMotor.set(TalonFXControlMode.Velocity, rpm);
  }

  public void Terminate(){
    masterMotor.set(TalonFXControlMode.PercentOutput, 0);
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
      case -1:
        rpmSet = Constants.SHOOTER_IDLERPM;
      default:
        rpmSet = Constants.SHOOTER_IDLERPM;
    }

    return rpmSet;
  }

  public boolean CheckHood(Integer POV) {
    if (POV.equals(270)){
      return true;
    }

    return false;
  }

  @Override
  public void periodic() {
    
  }
}
