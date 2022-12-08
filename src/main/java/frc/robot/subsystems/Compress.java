// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Compress extends SubsystemBase {
  Compressor compressor;

  public Compress() {
    compressor = new Compressor(Constants.COMPRESSOR_ID, PneumaticsModuleType.REVPH);
  }

  public void Activate(){
      compressor.enableAnalog(Constants.COMPRESSOR_RANGE_MIN, Constants.COMPRESSOR_RANGE_MAX);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
