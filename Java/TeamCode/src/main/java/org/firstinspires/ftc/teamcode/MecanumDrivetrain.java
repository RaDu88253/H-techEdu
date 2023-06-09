package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MecanumDrivetrain {

    public DcMotorEx fata_stanga, fata_dreapta, spate_stanga, spate_dreapta;
    //se declară 4 obiecte de tip motor (DcMotorEx), reprezentând motorul fiecărei roți

    public MecanumDrivetrain(HardwareMap map){

        //robotul are o configurație a pieselor, salvată pe telefonul folosit pentru a controla robotul, unde se specifică ce fel
        //de piesă electronică este folosită în fiecare port al control hub-ului și al expansion hub-ului (niște plăcii similare
        //cu arduino, procesorul robotului), iar fiecărui port i se atribuie un nume. Această configurație poartă numele de hartă
        //și este salvată într-un obiect de tipul HardwareMap. Ea poate fi accesată într-un OpMode sau LinearOpMode sub numele de
        //hardwareMap

        //pentru a asocia un obiect din program cu o componentă a robotului, se va folosi comanda:

        fata_stanga = map.get(DcMotorEx.class, "fs");
        fata_dreapta = map.get(DcMotorEx.class, "fd");
        spate_stanga = map.get(DcMotorEx.class, "ss");
        spate_dreapta = map.get(DcMotorEx.class, "sd");

        /*
            ***MENȚIUNI***
            * dacă în cadrul comenzii este folosit un nume care nu se găsește în configurația robotului, robotul nu va porni și va
              afișa eroarea de Uncaught Exception: NullPointerException
            * nu contează dacă piesa respectivă este conectată la port sau nu. Numele de "fs" spre exemplu este atribuit portului,
              nu piesei, motiv pentru care programul nu va da eroare nici dacă portul respectiv este liber
            * câmpul deviceName al funcției HardwareMap.get() este case sensitive (se face diferența între litere mari și litere mici)
         */

        /*

            Fiecare motor are un encoder, care se leagă cu un cablu separat. Acestea oferă date utile, măsurând
            poziția curentă a motorului. Această măsură se face în "tick-uri". !!!REZOLUȚIA VARIAZĂ DE LA MOTOR LA MOTOR!!!. Spre
            exemplu, motoarele 5202 series Yellow Jacket PLanetary Gear Motors de la goBILDA (motoarele de pe șasiu) au o rezoluție
            de 537.7 ticks/rotație.

            Encoder-ul este mecanic, așadar își schimbă poziția chiar dacă nu este alimentat, iar atunci când este alimentat și se
            efectuează citiri, acesta va afișa în tick-uri poziția sa curentă față de poziția inițială

            Pentru a putea lucra mai ușor cu acestea, vom folosi funcția <DcMotorEx>.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);.

            Aceasta face ca pozitia actuală a tuturor encoderelor să fie

         */

        fata_stanga.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        fata_dreapta.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        spate_stanga.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        spate_dreapta.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        fata_stanga.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fata_dreapta.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        spate_stanga.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        spate_dreapta.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        /*

            Functia <DcMotorEx>.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER); face ca motoarele să funcționeze fără feedback
            din partea encoderelor. Encoderele pot fi citite și în modul RUN_WITHOUT_ENCODER, dar modul RUN_USING_ENCODER
            limitează puterea motoarelor la 80%, motiv pentru care este evitat.

         */

        fata_stanga.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fata_dreapta.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        spate_stanga.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        spate_dreapta.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        /*

            Această funcție face ca motoarele să rămână tensionate atunci când primesc puterea 0 (puterea este un număr real cu
            valoare între -1 și 1). Contrar acestui mod este modul FLOAT, unde motoarele sunt lăsate să se învârtă din inerție,
            până când se opresc de la sine.

         */

        fata_stanga.setDirection(DcMotorSimple.Direction.REVERSE);
        fata_dreapta.setDirection(DcMotorSimple.Direction.FORWARD);
        spate_stanga.setDirection(DcMotorSimple.Direction.REVERSE);
        spate_dreapta.setDirection(DcMotorSimple.Direction.FORWARD);

        /*

        Această funcție setează direcția în care se învârt motoarele (invers acelor de ceasornic pe majoritatea, cât timp
        direcția e setată pe .FORWARD), deoarele motoarele de pe stânga sunt montate în oglindă cu cele de pe dreapta, pentru
        a putea folosi aceeași valoare pentru toate motoarele (spre exemplu, valoarea 1 face toate roțile să se învârtă înainte)

         */

    }


    public void miscare(double y, double x, double rot){

        //TODO: testat chestia asta

        /*
            Această funcție permite mișcarea omnidirecțională a unui șasiu cu roți mecanum, prin compunere de
            vectori.
            Mișcarea bazei poate fi văzută în diagrama aceasta (https://cdn11.bigcommerce.com/s-eem7ijc77k/images/stencil/original/products/1995/24906/3606-Series-Product-Insight-5__94466.1561476446.png?c=2),
            făcută de goBILDA.

            y reprezintă ordonata (sus-jos) a joystick-ului folosit, în general cel din stânga și are rolul de a
            face robotul să se miște față-spate, iar x reprezintă abscisa (stânga-dreapta) aceluiași joystick,
            având rolul de a face robotul să se miște stânga-dreapta. Prin compunerea acestora rezultă o mișcare
            omnidirecțională. În variabila rot se salvează o valoare care indică viteza cu care să se rotească
            robotul pe loc. Unele persoană preferă rotirea robotului pe abscisa joystick-ului din dreapta, caz în
            care se salvează valoarea x a acelui joystick, dar alte persoane, precum driver-ul nostru, preferă
            rotația pe triggers (L2 și R2), caz în care rot se salvează ca fiind L2 - R2.

            Când unui motor i se atribuie o putere, acesta rămâne la puterea respectivă cât timp este alimentat,
            până când i se atribuie o altă putere.

            Această funcție trebuie apelată constant, prin utilizarea unei bucle (în principal
            while(opModeIsActive)) pe durata întregului TeleOp, preferabil pe un thread separat de
            orice wait() sau orice altă funcție care îngheață thread-ul curent. În caz contrar, robotul rămâne la
            ultima putere atribuită pe timpul wait-ului și devine incontrolabil pe perioada acestuia.

         */

        fata_stanga.setPower(y + x + rot);
        fata_dreapta.setPower(y - x - rot);
        spate_dreapta.setPower(y + x - rot);
        spate_stanga.setPower(y - x + rot);

    }

}
