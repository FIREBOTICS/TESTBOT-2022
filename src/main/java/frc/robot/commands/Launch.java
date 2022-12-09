package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Catapult;

/** An example command that uses an example subsystem. */
public class Launch extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  
  private final Catapult m_catapult;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Launch(Catapult catapult) {
    m_catapult = catapult;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(catapult);

  }
}