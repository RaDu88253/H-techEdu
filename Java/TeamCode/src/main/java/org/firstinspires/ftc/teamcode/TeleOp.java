package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class TeleOp extends LinearOpMode {

    public Hardware hard;

    @Override
    public void runOpMode(){

        hard = new Hardware(hardwareMap);
        waitForStart();

        while(opModeIsActive()){

            idle();

        }



    }

}
