package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class TeleOp extends LinearOpMode {

    public DcMotorEx fata_stanga, fata_dreapta, spate_stanga, spate_dreapta;

    public void initHardware(){

        fata_stanga = this.hardwareMap.get(DcMotorEx.class, "fs");
        fata_dreapta = this.hardwareMap.get(DcMotorEx.class, "fd");
        spate_stanga = this.hardwareMap.get(DcMotorEx.class, "ss");
        spate_dreapta = this.hardwareMap.get(DcMotorEx.class, "sd");

        fata_stanga.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fata_dreapta.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        spate_stanga.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        spate_dreapta.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fata_stanga.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fata_dreapta.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        spate_stanga.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        spate_dreapta.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        fata_stanga.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fata_dreapta.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        spate_stanga.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        spate_dreapta.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        fata_stanga.setDirection(DcMotorSimple.Direction.REVERSE);
        fata_dreapta.setDirection(DcMotorSimple.Direction.FORWARD);
        spate_stanga.setDirection(DcMotorSimple.Direction.REVERSE);
        spate_dreapta.setDirection(DcMotorSimple.Direction.FORWARD);



    }

    public void runOpMode(){

        initHardware();

        waitForStart();

        while(opModeIsActive()){

            fata_stanga.setPower(1);



        }



    }

}
