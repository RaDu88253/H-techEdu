package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class TeleOp extends LinearOpMode {

    public MecanumDrivetrain hard;

    @Override
    public void runOpMode(){

        hard = new MecanumDrivetrain(hardwareMap);
        waitForStart();

        while(opModeIsActive()){

            idle();

        }



    }

}
