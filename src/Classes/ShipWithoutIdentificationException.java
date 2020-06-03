/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Fenetres.DialogErreur;

/**
 *
 * @author vange
 */
public class ShipWithoutIdentificationException extends Exception
{
    public ShipWithoutIdentificationException(java.awt.Frame fen,  String Mess)
    {
        super(Mess);
        DialogErreur Err = new DialogErreur(fen, "Erreur :-( GRRRR !" ,true, Mess);
        Err.setVisible(true);
    }
}
