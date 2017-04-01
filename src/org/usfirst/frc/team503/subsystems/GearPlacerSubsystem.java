package org.usfirst.frc.team503.subsystems;

import org.usfirst.frc.team503.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */


public class GearPlacerSubsystem extends Subsystem {
	private DoubleSolenoid outerGearSolenoid;
	private DoubleSolenoid innerGearSolenoid;
	public GearPlacerSubsystem(){
		if (Robot.bot.hasGearPlacer()){
		//outerGearSolenoid = new DoubleSolenoid(Robot.bot.outerGearSolenoidID1, Robot.bot.outerGearSolenoidID2);
	//		innerGearSolenoid = new DoubleSolenoid(Robot.bot.innerGearSolenoidID1, Robot.bot.innerGearSolenoidID2);
		}
		else{
			outerGearSolenoid = null;
			innerGearSolenoid = null;
		}
	}

    public void GearPlacer(){
    	outerGearSolenoid.set(Value.kForward);
    }
    
    private static GearPlacerSubsystem instance = new GearPlacerSubsystem();                                        
    
	public static GearPlacerSubsystem getInstance(){                                          
		return instance;
	}
	
	public void moveGearClampBackOpen(){
		outerGearSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	public void moveGearClampBackClose(){
		outerGearSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	public void moveGearClampFrontOpen(){
		innerGearSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	public void moveGearClampFrontClose(){
		innerGearSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
    public void initDefaultCommand() {
       
    }
}

