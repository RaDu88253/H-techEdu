package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/*

        Aceasta este o clasă. Majoritatea fișierelor, dacă nu chiar toate, vor fi salvate ca și clase, iar clasa va avea obligatoriu
    același nume ca fișierul. Pentru a crea o clasă, dați click pe directorul în care vreți să creați clasa > new > Java Class.
    La începutul fiecărei clase apare scris package <nume>, reprezentând directorul în care se găsește clasa respectivă. După aceea
    urmează mai multe import-uri, care reprezintă bibliotecile și clasele folosite, unde e cazul. Acestea sunt importate automat.

 */
public class ExempluClasa {

    public int a, b, c;

    public double x;

    String operatie;

    public void f(LinearOpMode m){
        operatie = "(" + Integer.toString(a) + " + " + Integer.toString(b) + " + " + Integer.toString(c) + ") "
                + " / " + Double.toString(x) + " = " + Double.toString((a + b + c) / x);
        m.telemetry.addLine(operatie);

        /*Output: ((<a> + <b> + <c>) / <x> = <rezultat>)
        Telemetry este o clasă pe care o folosim pentru a interacționa cu driver station-ul(telefonul cu android de pe care
        controlăm robotul) și o folosim pentru a afișa diverse date pe ecranul telefonului.
        telemetry cu "t" mic reprezintă un obiect din clasa Telemetry, predefinit în clasele OpMode și LinearOpMode. Prin
        convenție, în limbajul java, numele claselor încep cu majuscule, fiecare cuvânt din interiorul numelui fiind scris cu
        litera mare (ex: NumeDeClasa), iar numele obiectelor, variabilelor, functiilor etc. sunt scrise cu minuscule, fiecare
        cuvânt din interiorul numelui fiind scris totcu literă mare (ex: numeDeVariabila).
        Clasele OpMode și LinearOpMode sunt clasele în care vom scrie codul care va face robotul să se miște și să comunice cu
        telefonul, prin extinderea și suprascrierea acestora.

         */




    }
    public ExempluClasa(int a, int b, int c, double x){ //acesta este un constructor

        //un constructor este o functie care poartă numele clasei mamă și creează un obiect din aceasta. Poate primi
        // unul sau mai mulți parametri, în funcție de cum este definită

        this.a = a; //prin cuvântul cheie this se face referire la câmpul a al obiectului nou format
                    //câmpul a al obiectului ia valoarea parametrului a
        this.b = b;
        this.c = c;
        this.x = x;

    }

    public ExempluClasa(){ //constructor fara parametri
        a = 5;//daca nu se folosesc parametri cu acelasi nume ca cel al unui camp, nu e necesara folosirea cuvantului cheie this
              //nu este necesar ca toate câmpurile obiectului să fie inițializate, acestea primind valoarea 0, false sau null
              // dacă nu sunt inițializate explicit
    }

    /*
    Pentru a defini un obiect cu un constructor, se definește un obiect de tipul clasei respective și este inițializat cu
    numeObiect = new NumeClasa(parametri)
    ex:

        ExempluClasa e1, e2;

        e1 = new ExempluClasa(1, 2, 3, 0.5); //a = 1, b = 2, c = 3, x = 0.5
        e2 = new ExempluClasa(); //a = 5, b = 0, c = 0, x = 0

    */

}
