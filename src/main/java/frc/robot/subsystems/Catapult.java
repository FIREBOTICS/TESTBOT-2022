package frc.robot.subsystems;

import java.lang.module.ModuleDescriptor;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Catapult extends SubsystemBase {
    private final Solenoid m_Solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.solenoidChannel);
    private final DoubleSolenoid m_DoubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.dSChannelForward, Constants.dSChannelBackward);

    public Catapult() {
        m_DoubleSolenoid.set(Value.kOff);
    }
    public void singleSolenoid(boolean extend) {
        m_Solenoid.set(extend);
    }

    public void doubleSolenoid(short value) {
        switch (value) {
            case  1: m_DoubleSolenoid.set(Value.kForward); break;
            case  0: m_DoubleSolenoid.set(Value.kOff); break;
            case -1: m_DoubleSolenoid.set(Value.kReverse); break;
        }
    }

}
