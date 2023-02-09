// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.Catapult;
import frc.robot.subsystems.Drivetrain;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  //private RobotContainer m_robotContainer;
  public static Drivetrain m_drivetrain = new Drivetrain();
  public static Catapult m_catapult = new Catapult();
  public static Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
  public static XboxController XboxController0 = new XboxController(Constants.Xbox0);
  public static XboxController XboxController1;


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.

    // m_robotContainer = new RobotContainer();
    // XboxController1 = new XboxController(Constants.XboxController1);
    }


  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    //m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }

    pcmCompressor.enableDigital();
    // m_DoubleSolenoid.set(kReverse);

  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    double getLeftY = XboxController0.getLeftY();
    double getRightY = XboxController0.getRightY();
    System.out.println("left: " + XboxController0.getLeftTriggerAxis());
    System.out.println("right:" + XboxController0.getRightTriggerAxis());
    System.out.println();

    m_drivetrain.drive(getLeftY, getRightY);
    /*
    // new RunCommand(() -> m_drivetrain.drive(
    //     getLeftY,
    //     getRightY),
    //   m_drivetrain);
    */
    
    
    m_catapult.setDefaultCommand(
      new RunCommand(() -> m_catapult.singleSolenoid(
          XboxController0.getLeftBumper()),
        m_catapult)
    );
    

    // m_catapult.singleSolenoid(XboxController0.getLeftBumper());
    if (XboxController0.getLeftTriggerAxis() > 0)       {m_catapult.doubleSolenoid((short) -1.);}
    else if (XboxController0.getRightTriggerAxis() > 0) {m_catapult.doubleSolenoid((short) 1);}
    else           {System.out.println("hello, this is kOff");m_catapult.doubleSolenoid((short) 0);}
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
