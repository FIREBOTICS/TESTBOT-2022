package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Catapult extends SubsystemBase {
    private final Solenoid m_Solenoid = new Solenoid(null, Constants.solenoidChannel);

    public void retract() {}
    public void launch() {}


}
