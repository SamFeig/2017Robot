package org.usfirst.frc.team503.robot;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Name:		RobotState 
 * Purpose:		
 * Author: 		Jyotsna Joshi
 * Date:		February 2017 
 * Comments:
 */
public class RobotState extends Subsystem {

    // Put methods for controlling this subsystem
	private boolean shooterIsRunning;
	private boolean intakeIsRunning;
	private boolean currentDriveGear;
	private boolean indexerIsRunning;
	private boolean climberIsRunning;
	private boolean climberIsAccelerated;
	private boolean turretIsRunning;
	private boolean driveTrainIsReversed;
	private boolean gearPlacerBack;
	private boolean gearPlacerFront;
	private boolean climberIsRunningSlow;
	private boolean turretIsLocked;
	private State robotState;
	private TurretState turretState;
	private ShootingPresets shootingPreset;
	private double turretAngle;
	private boolean hint;
    	
	public RobotState() {
		shooterIsRunning = false; 
		turretIsLocked = false;
		climberIsRunningSlow = false; 
		intakeIsRunning = false;
		currentDriveGear = false;    //low gear
		indexerIsRunning = false;
		climberIsRunning = false;
		climberIsAccelerated = false;
		turretIsRunning = false;
		driveTrainIsReversed = false;
		gearPlacerBack = false; //closed
		gearPlacerFront = false; //closed
		hint = false;
		robotState = State.DISABLED;
		turretState = TurretState.DISABLED;
		shootingPreset = ShootingPresets.HopperRed;
	}	
	
	private static RobotState instance = new RobotState();
	
	public static RobotState getInstance(){
		return instance;
	}
	
	public enum State{
		DISABLED, AUTON, TELEOP, TEST, ENABLED;
	}
	
	public enum TurretState{
		DISABLED, RESET_TURRET, SEEKING_TARGET, TARGET_FOUND, RUNNING_PID, ON_TARGET, TAKING_HINT;
	}
	
	public enum ShootingPresets{
		Batter(18.0,4000,271.0), HopperRed(29.9,4300,0), CenterPeg(29.9,4500,503), PegNearHopperBlue(36.0, 5050, 271.0), PegNearHopperRed(32.0, 5050,301), HopperBlue(32.0,4350,204.0);
		//livonia peg near hopper 266.66537145811753
		//livonia batter 283.5324107344833
		public double deflectorAngle;
		public int rpm;
		public double turretAngle; 
		private ShootingPresets(double deflectorAngle, int rpm, double turretAngle){
			this.deflectorAngle = deflectorAngle;
			this.rpm = rpm;
			this.turretAngle = turretAngle;
		}
		
	}
	
	
	public boolean getTurretIsLocked(){
		return turretIsLocked;
	}
	
	public void setTurretIsLocked(boolean lock){
		turretIsLocked = lock;
	}
	
	public double getTurretAngle(){
		return turretAngle;
	}
	
	public void setTurretAngle(double angle){
		turretAngle = angle;
	}
	
	public boolean getTurretHint(){
		return hint;
	}
	
	public void setTurretHint(boolean hint){
		this.hint = hint;
	}
	
	
	public ShootingPresets getShooterPreset(){
		return shootingPreset;
	}
	
	public void setShootingPreset(ShootingPresets preset){
		shootingPreset = preset;
	}
	
	public boolean getGearPlacerBack(){
		return gearPlacerBack;
	}
	
	public void setGearPlacerBack(boolean gearPlacer){
		this.gearPlacerBack = gearPlacer;
	}
	
	public boolean getGearPlacerFront(){
		return gearPlacerFront;
	}
	
	public boolean getClimberRunningSlow(){
		return climberIsRunningSlow;
	}
	
	public void setClimberRunningSlow(boolean climber){
		climberIsRunningSlow = climber;
	}
	
	public void setGearPlacerFront(boolean gearPlacer){
		this.gearPlacerFront = gearPlacer;
	}
	
	
	public synchronized TurretState getTurretState(){
		return turretState;
	}
	
	public synchronized void setTurretState(TurretState state){
		turretState = state;
	}
	
	public State getState(){
		return robotState;
	}
	
	public void setState(State state){
		robotState = state;
	}
	
	public void setTurretStatus(boolean status){
		turretIsRunning = status;
	}
	
	public boolean getTurreStatus(){
		return turretIsRunning;
	}
	
	public void setDriveTrainReversed(boolean reverse){
		driveTrainIsReversed = reverse;
	}
	
	public boolean getDriveTrainReversed(){
		return driveTrainIsReversed;
	}
	
	public void setShooterStatus(boolean status) {
		shooterIsRunning = status; 
	}
	
	public boolean getShooterStatus() {
		return shooterIsRunning; 
	}
	
	public void setClimberStatus(boolean status){
		climberIsRunning = status;
	}
	
	public void setClimberAccelerationStatus(boolean status){
		climberIsAccelerated = status;
	}
	
	public boolean getClimberStatus(){
		return climberIsRunning;
	}
	
	public boolean getClimberCanAccelerate(){
		return (!climberIsAccelerated);
	}
	
	public void setcurrentGear(boolean status) {
		currentDriveGear = status; 
	}
	
	public boolean getCurrentGear() {
		return currentDriveGear; 
	}
	
	public void setIntakeStatus(boolean status) {
		intakeIsRunning = status; 
	}
	
	public boolean getIntakeStatus() {
		return intakeIsRunning; 
	}
	
	public void setIndexerStatus(boolean status) {
		indexerIsRunning = status; 
	}
	
	public boolean getIndexerStatus() {
		return indexerIsRunning; 
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

