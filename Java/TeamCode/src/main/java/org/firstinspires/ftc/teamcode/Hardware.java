package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Hardware {

    private DcMotorEx fata_stanga, fata_dreapta, spate_stanga, spate_dreapta;

    public Hardware(HardwareMap map){

        fata_stanga = map.get(DcMotorEx.class, "fs");
        fata_dreapta = map.get(DcMotorEx.class, "fd");
        spate_stanga = map.get(DcMotorEx.class, "ss");
        spate_dreapta = map.get(DcMotorEx.class, "sd");

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

    public void fataSpate(double power){

        fata_stanga.setPower(power);
        fata_dreapta.setPower(power);
        spate_dreapta.setPower(power);
        spate_stanga.setPower(power);

    }



}