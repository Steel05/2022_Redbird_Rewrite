// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.Collector.Collector_ACTIVATE;
import frc.robot.commands.Compressor.Compress_ACTIVE;
import frc.robot.commands.Drivetrain.Drive_ARCADE;
import frc.robot.commands.Drivetrain.Drive_BRAKE;
import frc.robot.commands.Indexer.Indexer_ACTIVATE;
import frc.robot.commands.Shooter.Shooter_ACTIVE;
import frc.robot.commands.Shooter.Shooter_IDLE;
import frc.robot.subsystems.Collector;
import frc.robot.subsystems.Compress;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Indexer;
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
  public static Collector collectorSystem;
  public static Indexer indexerSystem;
  public static Compress compressorSystem;

  // Buttons
  private JoystickButton brakeButton;
  private JoystickButton collectorCollect;
  private JoystickButton collectorDump;
  private JoystickButton indexerBinding;
  private POVButton upButton;
  private POVButton rightButton;
  private POVButton downButton;
  private POVButton leftButton;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    driverController = new XboxController(Constants.CONTROLLER_DRIVER);
    operatorController = new XboxController(Constants.CONTROLLER_OPERATOR);

    drivetrain = new Drivetrain();
    shooterSystem = new Shooter();
    collectorSystem = new Collector();
    indexerSystem = new Indexer();
    compressorSystem = new Compress();

    drivetrain.setDefaultCommand(new Drive_ARCADE());
    shooterSystem.setDefaultCommand(new Shooter_IDLE());
    compressorSystem.setDefaultCommand(new Compress_ACTIVE());

    drivetrain.ResetEncoders();

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
    brakeButton = new JoystickButton(driverController, XboxController.Button.kB.value);
    brakeButton.whileHeld(new Drive_BRAKE());

    upButton = new POVButton(operatorController, 0);
    upButton.whileHeld(new Shooter_ACTIVE(), true);

    rightButton = new POVButton(operatorController, 90);
    rightButton.whileHeld(new Shooter_ACTIVE(), true);

    downButton = new POVButton(operatorController, 180);
    downButton.whileHeld(new Shooter_ACTIVE(), true);

    leftButton = new POVButton(operatorController, 270);
    leftButton.whileHeld(new Shooter_ACTIVE(), true);

    collectorCollect = new JoystickButton(operatorController, XboxController.Button.kA.value);
    collectorCollect.whileHeld(new Collector_ACTIVATE(false), true);

    collectorDump = new JoystickButton(operatorController, XboxController.Button.kB.value);
    collectorDump.whileHeld(new Collector_ACTIVATE(true), true);

    indexerBinding = new JoystickButton(operatorController, XboxController.Axis.kRightTrigger.value);
    indexerBinding.whileHeld(new Indexer_ACTIVATE(), true);
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
