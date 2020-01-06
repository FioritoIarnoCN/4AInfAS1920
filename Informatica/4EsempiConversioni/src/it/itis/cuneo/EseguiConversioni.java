package it.itis.cuneo;

/**
 * Created by inf.fioritoi2801 on 30/09/2019.
 */
public class EseguiConversioni {

    //esempio di conversione tra wrapper, partendo da un primitivo

    public static void main(String[] args){

        //float: tipo primitivo, cioè una variabile semplice che non possiede metodi
        //Float: classe wrapper, cioè contiene dello stesso tipo e i metodi che ne permettono l'eleborazione

        Float f;
        //Non è necessario usare il parse con il float
        f = new Float("0.524d");

        //System.out.println(String s)
        //La firma del metodo sopra richiede una stringa come parametro, quindi il float viene convertito in una stringa al momento della chiamata
        System.out.println(f);

        //System.out.println(float fPrimitivo)
        //Se alla firma sopra viene parrato un Float wrapper, esso ne fa automaticamente la conversione (cast implicito)(da java 1.6)
        System.out.println(f);

        int n;
        n = Integer.parseInt("6");    //Parse serve se ciò che è da convertire è una stringa
        System.out.println(n);


        //----------------------------------------------------------------------------------------//


        Float ogF;
        ogF = new Float(n);

        String s2;
        s2 = " " + ogF;
        System.out.println("s2 = \"\" + ogF: " + s2);

        s2 = new String(" " + ogF);
        System.out.println("s2 = new String(\"\" + ogF) " + s2);

        s2 = ogF.toString();
        System.out.println("s2 = ogF.toString(): " + s2);

        //-----------------------------------------------------------------------------------------//

        //double -> Integer
        double dN = 6.5d;   //La d serve per definire il tipo della costante
        int intN = (int) dN;    //intN = 6
        Integer iN = new Integer(intN);
        iN = intN;  //Wrapper = primitivoDelloStessoTipo
    }

}
