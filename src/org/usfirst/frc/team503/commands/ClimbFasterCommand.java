package org.usfirst.frc.team503.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team503.robot.OI;
import org.usfirst.frc.team503.robot.Robot;
import org.usfirst.frc.team503.robot.RobotState;
import org.usfirst.frc.team503.subsystems.ClimberSubsystem;

/**
 *
 */
public class ClimbFasterCommand extends Command {
	
	public ClimbFasterCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(ClimberSubsystem.getInstance());
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if (OI.getClimbFastButton()){
		if ((!RobotState.getInstance().getClimberStatus()) || (RobotState.getInstance().getClimberRunningSlow())){
			ClimberSubsystem.getInstance().setPower(-1);
			RobotState.getInstance().setClimberStatus(true);
			//RobotState.getInstance().setClimberAccelerationStatus(true);
			RobotState.getInstance().setClimberRunningSlow(false);
		} else {
			ClimberSubsystem.getInstance().setPower(0);
			RobotState.getInstance().setClimberStatus(false);
			//RobotState.getInstance().setClimberAccelerationStatus(false);
			RobotState.getInstance().setClimberRunningSlow(false);
		}
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
