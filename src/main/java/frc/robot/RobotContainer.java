// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Drivetrain.Drive_ARCADE;
import frc.robot.commands.Drivetrain.Drive_BRAKE;
import frc.robot.commands.Shooter.Shooter_ACTIVE;
import frc.robot.commands.Shooter.Shooter_IDLE;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Controllers
  public static XboxController driverController;
  public static XboxController operatorController;

  // Subsystems
  public static Drivetrain drivetrain;
  public static Shooter shooterSystem;

  // Buttons
  private JoystickButton shooterBinding;
  private JoystickButton brakeButton;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    driverController = new XboxController(Constants.CONTROLLER_DRIVER);
    operatorController = new XboxController(Constants.CONTROLLER_OPERATOR);

    drivetrain = new Drivetrain();
    shooterSystem = new Shooter();

    drivetrain.setDefaultCommand(new Drive_ARCADE());
    shooterSystem.setDefaultCommand(new Shooter_IDLE());

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    shooterBinding = new JoystickButton(operatorController, operatorController.getPOV());
    shooterBinding.whileHeld(new Shooter_ACTIVE(), true);

    brakeButton = new JoystickButton(driverController, XboxController.Button.kB.value);
    brakeButton.whileHeld(new Drive_BRAKE());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null;
  }
}
