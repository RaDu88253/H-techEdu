package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp  /* linia asta îi spune telefonului să afișeze clasa asta în lista de opmode-uri de tip teleop, pe săgeata din dreapta de
         pe ftc driver station. dacă linia asta este absentă, programul este compilat, dar nu este accesibil de pe telefon și nu
         poate fi folosit
         */

public class LinearOpModeTeleOp extends LinearOpMode { /* prin extiderea clasei LinearOpMode putem face un program care comunică cu
robotul, care atribuie comenzi acestuia, care poate prelua și trimite date de la cele 2 controllere și care poate afișa date pe
ecranul telefonului.
    */

    //in general, inainte de override se declară variabiele

    public MecanumDrivetrain drive;


    @Override
    /*
    atunci când opmode-ul este ales din driver station și se apasă init, robotul apelează funcția runOpMode(),
    predefinită în clasa LinearOpMode. Pentru a face această funcție să funcționeze com dorim, este necesar să
    specificăm @Override, pentru a suprascrie conținutul clasei
     */

    public void runOpMode(){

        //in cadrul acestei functii pot fi accesate obiectele predefinite în cadrul obiectului de tip LinearOpMode. Câteva dintre
        // aceste obiecte sunt hardwareMap, telemetry, gamepad1 și gamepad2, care sunt cele mai folosite astfel de obiecte
        // la inceputul acestei funcții se realizează inițializarea componentelor prin căurarea acestora pe hardwareMap.

        drive = new MecanumDrivetrain(hardwareMap);

        while(opModeInInit()){
            //instructiuni

            /*
                functia opModeInInit() returnează valoarea true dacă a fost apăsat butonul de init, dar încă nu a fost apăsat alt
                 buton (nici start și nici stop), sau valoarea false în orice alt caz. Această perioadă este „faza de init a
                 robotului”
             */
        }

        waitForStart(); //această funcție îngheață thread-ul până când este apăsat butonul de start

        while (opModeIsActive()){

            //bucla in care se va scrie cam tot opMode-ul

            /*
                functia opModeIsActive() verifică dacă robotul este pornit (a fost apăsat butonul de start, iar cel de oprire nu)
                și returnează true dacă este, false dacă nu
             */


            telemetry.addLine("Robotul merge"); //așa se afișează text pe ecranul telefonului
            telemetry.addData("Viteza motor fs", drive.fata_stanga.getVelocity()); //așa se afișează date pe ecranul
            // telefonului, funcția are 2 parametri: un string, care este numele datelor, și un tip de date primar (număr, string sau
            // logic (true/false))
            telemetry.update(); //face ca datele de pe ecran să fie actualizate la fiecare iterație a buclei în care se află comanda

        }




    }
}
